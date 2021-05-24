public class CompanyClient extends Client{
    
    //constructor of company client calling super of client 
    public CompanyClient(String n){
        super(n);
    }

    //makeClaim method given a policy nuber returns the corrisponding policys amount using the handleClaim() method
    public float makeClaim(int polNum){
        Policy[] policies = getPolicies();
        Policy cancel_Policy = getPolicy(polNum);
        for(int i = 0; i <policies.length;i++){                             //for loop searches throught all the policy objects in the policy array
            if(policies[i] == null){                                        //If current policy object is null then we break out of the for loop
                break;
            }
            if(policies[i] == cancel_Policy){                               //checks if the current policy we are at in the array has the same policy number as the given policy number in the parameters
                return policies[i].handleClaim();
            }
        }
        return 0;
    }
}
