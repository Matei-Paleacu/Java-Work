public class IndividualClient extends Client{
    private int claims_made = 0; 
    
    //default constructor which calls the super class to initialize client object
    public IndividualClient(String n){
        super(n);
    }

    //methode returns the policy amount or the default value of zero 
    public float makeClaim(int polNum){
        Policy[] policies = getPolicies();
        Policy cancel_Policy = getPolicy(polNum);
        for(int i = 0; i <policies.length;i++){                                                     //for loop searches throught all the policy objects in the policy array
            if(policies[i] == null){                                                                //If current policy object is null then we break out of the for loop
                break;
            }
            if(policies[i] == cancel_Policy){                                                       //checks if the current policy we are at in the array has the same policy number as the given policy number in the parameters
                if(policies[i].toString().charAt(0) == 'D'){                                        //checks if the first char in the string rep of the current policy in the array is a 'D', meaning it is a Depreciating Policy
                    ((DepreciatingPolicy)policies[i]).depreciate();                                 //casts policy object as a Depreciating Policy object
                    return policies[i].amount;
                }
                if(policies[i].toString().charAt(0) == 'E'){                                        //checks if the first char in the string rep of the current policy in the array is a 'E', meaning it is a Expiring Policy
                    if(((ExpiringPolicy)policies[i]).isExpired() == true){                          //casts policy object as a Expiring Policy object
                        return 0;
                    }else{
                        return policies[i].amount;
                    }
                }
                if(claims_made == 0){                                                               //checks if this is the first claim, as there is only allowed one claim per policy
                    cancelPolicy(polNum);
                    claims_made++;
                    return policies[i].amount;
                }
             }
         }
        return 0;                                                                                   //returns 0 as a default value if no other value is returned
    }
}
