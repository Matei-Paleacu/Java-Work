import java.util.Date;

public abstract class Client {
    private static final int MAX_POLICIES_PER_CLIENT = 10;
    private static int NEXT_CLIENT_ID = 1;
    private   String        name;
    private   int           id;
    protected Policy[]      policies;
    protected int           numPolicies;

    public Client(String n) {
        name = n;
        id = NEXT_CLIENT_ID++;
        policies = new Policy[MAX_POLICIES_PER_CLIENT];
        numPolicies = 0;
    }

    // getter fot the name var
    public String getName() { 
        return name; 
    }

    // getter fot the id var
    public int getId() { 
        return id; 
    }

    // getter fot the policies array
    public Policy[] getPolicies() { 
        return policies; 
    }

    // getter fot the numPolicies var
    public int getNumPolicies() { 
        return numPolicies; 
    }

    //toString method used to print out Client info
    public String toString() {
        return String.format(getClass()+" Client: %06d amount: %s", id, name);
    }

    // returns the sum of all the amount of policies in the policies array
    public float totalCoverage(){
        float totalCoverage = 0.0f;
        for(int i = 0; i<this.policies.length;i++){                                 //for loop searches throught all the policy objects in the policy array
            if(policies[i] != null){                                                //if the policy is not "null" then its amount is added to total var coverage
                totalCoverage =  totalCoverage + policies[i].amount;
            }
        }
        return totalCoverage;
    }

    // adds a new policy to the policies array
    public Policy addPolicy(Policy p){
        if(numPolicies<10){                                                         //If to check if the number of max policies per client has been reached, which is 10
            policies[numPolicies] = p;
            numPolicies++;
            return p;
        }
        return null;
    }

    //creates a new policy object
    public Policy openPolicyFor(float amt){
        Policy new_policy = new Policy(amt);
        return addPolicy(new_policy);
    }

    //creates a new depreciating policy object
    public Policy openPolicyFor(float amt, float rate){
        DepreciatingPolicy new_dPolicy = new DepreciatingPolicy(amt, rate);
        return addPolicy(new_dPolicy);
    }

    //creates a new expiring policy object
    public Policy openPolicyFor(float amt, Date expire){
        ExpiringPolicy new_ePolicy = new ExpiringPolicy(amt, expire);
        return addPolicy(new_ePolicy);
    }

    //returns the policy object with the given pol number
    public Policy getPolicy(int polNum){
        for(int i = 0; i<this.policies.length;i++){                                 //for loop searches throught all the policy objects in the policy array
            if(policies[i] == null){                                                //If current policy object is null then we break out of the for loop
                break;
            }
            if(policies[i].getPolicyNumber() == polNum){                            //checks if the current policy we are at in the array has the same policy number as the given policy number in the parameters
                return policies[i];
            }
        }
        return null;
    }

    //removes a given policy with the matching policy number from the policies array
    public boolean cancelPolicy(int polNum){
        Policy[] changed_policy = new Policy[policies.length-2];
        int k = 0;
        boolean found =  false;
        Policy cancel_Policy = getPolicy(polNum);
        for(int i = 0; i<this.policies.length;i++){                                 //for loop searches throught all the policy objects in the policy array
            if(policies[i] == null){                                                //If current policy object is null then we break out of the for loop
                break;
            }
            if(policies[i] == cancel_Policy){                            //checks if the current policy we are at in the array has the same policy number as the given policy number in the parameters
                found = true;
                
            }else{                                                                  //else if the current policy is not the one we are looking to remove and is not null then it is added to the new array
                changed_policy[k] = policies[i];
                k++;
            }
        }
        policies = changed_policy;
        return found;
    }
    
    //abstract makeClaim method implemented in other classes
    public abstract float makeClaim(int polNum);
}
