/** Represents a ExpiringPolicy which is a type of Policy.
 * @author Matei Paleacu, mateipaleacu@cmail.carleton.ca
 * @version 1.0
 * @since 1.0
 */
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class ExpiringPolicy extends Policy{
    private Date expiryDate = new Date();

    /**constructor for the Expiring Policy class, which also calls the Policy class constructors using super
     * 
     * @param amount var for amount of the policy
     * @param date expirey date of the policy
     */
    public ExpiringPolicy(float amount, Date date){
        super(amount);
        this.expiryDate = date;
    }

    /**second constructor if a date object is not given in the parameters
     * 
     * @param amount var for hte amounf of the policy
     */
    public ExpiringPolicy(float amount){
        super(amount);
        GregorianCalendar aCalendar = new GregorianCalendar();
        aCalendar.add(Calendar.YEAR,1);
        expiryDate = aCalendar.getTime();

    }

    /**getter method to retrive encapsulated exiryDate value
     * 
     * @return date object of the expiring policy 
     */
    public Date getExpiryDate(){
        return expiryDate;
    }

    /**toString method converts the exiring policy object to a string representation
     * @return String representation of expiring policy
     */
    public String toString(){
        SimpleDateFormat dateFormatter = new SimpleDateFormat("MMMM dd, yyyy (hh:mma)");
        String result = dateFormatter.format(expiryDate);
        if(isExpired() == true){                                                                //if the policy is exipred then a different output will be shown
            return "Expiring" + super.toString() + " expired on: " + result;
        } else{
            return "Expiring" + super.toString() + " expires: " + result;
        }
    }

    /**method used to check is a expiring policy has expired
     * @return bool value based o expire of policy object
     */
    public boolean isExpired(){
        Date today = new Date();
        if(today.after(expiryDate) == true){                                                    //if uses the .after() method to check if the date today is after the expirery date
            return true;
        }else{
            return false;
        }
    }

    /**method returns the amount of the policy based on the expirery of the expiring policy
     * @return amount var or default value 0 
     */
    public float handleClaim(){
        if(isExpired() == false){
            return amount;
        }else{
            return 0;
        }
    }

}
