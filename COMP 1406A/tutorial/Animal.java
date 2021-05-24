import java.time.ZonedDateTime;  // used for obtaining the current year
import java.time.ZoneId;         // used for setting time zone
import java.util.Random;

/**
Basic abstract animal class for tutorial.
<p>
Example class for tutorials in COMP 1406. 
Students will complete the toString() method (overriding
the method inherited from Object) and write subclasses that 
define the abstract method noise(). 

@author m. jason hinek
@version 1.3

*/
public abstract class Animal{

	/** internal storage of animal's name  
	<p>
	private/protected attributes and methods may or may not have javadoc 
	documentation with them. If the javadoc is the API (interface) for the
	class, then users of the class should not know about these attributes and
	methods. It goes against the notion of <strong>information hiding</strong>
	if we make them visible like this.
	*/
	protected String name;

	/** internal storage of the animal's birth year */
	protected int birthYear;

	/** Getter for an animal's name
	    @return the name of this animal
	*/
	public final String getName(){ return this.name; }

	
	/** Getter for an animal's year of birth 
      @return the birth year of this animal
	*/
	public final int getBirthyear(){ return this.birthYear; }

	public final String toString(){
		int current_year = ZonedDateTime.now( ZoneId.of("America/Montreal")).getYear();
		return "the" + name + "current age is: " + (current_year - birthYear) + " years old";
	}

/*
	public Boolean compareTo(Animal A, Animal B){
		if(A.birthYear < B.birthYear){
			return true;
		}else{
			return false;
		}
	}
*/
	
	/**
	Initializes an animal with the given name and birth year.
	
	@param name is the animal's name
	@param year is the animal's year of birth
	*/
	public Animal(String name, int year){
		this.name = name;
		this.birthYear = year;
	}



	/*****************************************************
	 _   _          _ ___    _                __  _ 
	| \ / \   |\ | / \ |    /  |_|  /\  |\ | /__ |_ 
	|_/ \_/   | \| \_/ |    \_ | | /--\ | \| \_| |_ 
													
	*******************************************************/

	/** 
	A string representation of the noise an animal makes.
	<p>
	The method must be overridden by child classes.
	
	@return a string representation of the noise this animal makes
	*/
	public abstract String noise();



}
