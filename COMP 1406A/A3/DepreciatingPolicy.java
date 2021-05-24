/** Represents a DepreciatingPolicy which is a type of Policy.
 * @author Matei Paleacu, mateipaleacu@cmail.carleton.ca
 * @version 1.0
 * @since 1.0
 */


public class DepreciatingPolicy extends Policy{
    private float rate;


    /**constructor for for the Depreciating Policy class, which also calls the Policy class constructors using super
     * @param amt an amount for the policy in a float
     * @param rate a flaot representing the depreciating amount for the policy
     */
    public DepreciatingPolicy(float amount, float rate){
        super(amount);
        this.rate = rate*100;
    }

    /**getter for the rate var which is encapsulated
     * 
     * @return a float rate for the depreciating policy 
     */
    public float getRate(){
        return rate;
    }

    /**method returns a toString representation of the Depreciating Policy
     * @return a string representation of the depreciating policy
     */
    public String toString(){
        return "Depreciating" + super.toString() + " rate: " + String.format("%.1f", rate) + "%";
    }

    /**checks if the Depreciating policy has depreciated to 0 aka expired
     * @return true or false value if the amount of the policy has depreciated to 0
     */
    public boolean isExpired(){
        float empty = 0.0f;
        return empty == getAmount();
        
    }

    /**method depreciates the amount of the policy by the given rate var
     * 
     */
    public void depreciate(){
        float amountN = getAmount();
        float reduce = amountN*(rate/100);
        amountN = amountN - reduce;
        this.amount = amountN;
    }


    /**method depreciated the amount but returns the undepreciated amount var
     * @return amount var befor it was depreciated
     */
    public float handleClaim(){
        float re_amount = amount;
        depreciate();
        return re_amount;
    }



}
