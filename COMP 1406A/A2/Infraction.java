import java.util.Date;

public class Infraction {
    Float amount;
    String description;
    Date dateIssued = new Date();
    Boolean outstanding = false;
    Driver driver = null;

    // basic method to initiate infraction object class given the parameters
    public  Infraction(Float amount, String description, Date dateIssued){
        this.amount = amount;
        this.description = description;
        this.dateIssued = dateIssued;
    }
// default infraction constructor
    public Infraction(){
        this(0.0f, " ", new Date(01/01/1970));
        this.amount = 0.0f;
        this.description = " ";
        
    }
    //toString method to print out infraction object based on outstanding, to show wether the infraction has been payed
    public String toString(){
        if(outstanding == true){
            return "$" + String.format("%.2f", amount) + " Infraction on " +  dateIssued +  "[PAID IN FULL]";
        } else{
            return "$" + String.format("%.2f", amount) + " Infraction on " +  dateIssued +  "[OUTSTANDING]";
        }
        
    }

    //pay method used to pay off outstanding infraction
    public void pay(){
        outstanding = true;
    }

    
}
