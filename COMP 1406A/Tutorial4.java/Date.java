
/**
Abstract Date class for tutorial.
<p>
Example class for tutorials in COMP 1406. 
Students will override the comparable method. 

@author m. jason hinek
@version 1.3

*/
public abstract class Date implements Comparable<Date>{

	protected int year;
	protected Month month;
	protected byte day;


	public Date(int year, Month month, byte day){
		this.year = year;
		this.month = month;
		this.day = day;
	}


	/** 
	A string representation of a date is of the form "DD/MM/YYYY"
	
	@return a string representation of a date in the format "DD/MM/YYYY"
	*/
    @Override
	public String toString(){
		return 	day + "/" + month + "/" + year;
	}

    @Override
    public boolean compareTo(Date a, Date b){
        if(a.year == b.year){
            if(a.month == b.month){
                if(a.day == b.day){
                    return true;
                }
            }
        } if(a.year < b.year){
            return true;
        }else{
            return false;
        }

    }

}

