/** Represents a Policy.
 * @author Matei Paleacu, mateipaleacu@cmail.carleton.ca
 * @version 1.0
 * @since 1.0
 */


public class Policy {

private static int NEXT_POLICY_NUMBER = 1;
private int policyNumber;
protected float amount;

    /**default constructor used to initialize policy objects
     * @param amt an amount for the policy in a float
     */
    public Policy(float amt) {
    amount = amt;
    policyNumber = NEXT_POLICY_NUMBER++;
    }

    /**getter for the policy number
     * 
     * @return an int policy number
     */
    public int getPolicyNumber() { 
    return policyNumber; 
    }

    /**getter for the amount var
     * 
     * @return a float amount value for the respective policy
     */
    public float getAmount() { 
    return amount; 
    }
    
    /**method returns a toString representation of the
     * @return returns a string representation of the 
     */ 
    public String toString() {
    return String.format("Policy: %04d amount: $%1.2f", policyNumber, amount);
    }

    /**method returns false
     * 
     * @return false
     */
    public boolean isExpired() {
    return false;
    }

    /**method returns the amount for the given policy 
     * 
     * @return amount var of policy
     */
    public float handleClaim(){
        return amount;
    }

}
