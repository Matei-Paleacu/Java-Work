
import java.util.Random;
import java.util.Calendar;
import java.util.Arrays;

/** Tutorial #5 
    <p>
	Testing program for the Animal, Cat and Dog classes.
        
	 @version 1.1
*/

public class AnimalApp {
	/** number of animals in collection */
	public static int SIZE = 7;

	/** a collection of names for generating random animals */
	public static String[] names = {"Fluffy", "Tiger", "Spot", 
	    "Bubbles", "Dodger", "Ace", "Flower", "Tiny", "Pip", 
			"Chyanne", "Darla", "Maggie", "Cookie", "Booboo"};
	
	
	public static void main(String[] args){
		//
		// use short-circuiting of AND (&&) operator instead of nested if statements 
		// (if you don't know what short-cicruiting is please ask!)
		///
		if( args.length == 1                      // check for single command line argument 
//		    && CheckForInt.isInt(args[0])           // if so, check if it an integer
				&& Integer.parseInt(args[0]) > 0)     // if so, check that it is positive
	    {
			SIZE = Integer.parseInt(args[0]);
		}

		System.out.println("SIZE = " + SIZE + " for this execution");
		
		Random rnd = new Random();
		
		/* get the current year based on computer's clock */
	    Calendar now = Calendar.getInstance();   
		int year = now.get(Calendar.YEAR);  
		System.out.println("The year is " + year);
		
		/* some animals */
		Animal[] animal_list = new Animal[SIZE];

		/* randomly pick a cat or dog */
		for(int i=0; i<SIZE; i+=1){
			if(Math.random() < 0.5){
				animal_list[i] = new Cat( names[rnd.nextInt(names.length)],2010 + rnd.nextInt(6));
			}else{
				animal_list[i] = new Dog( names[rnd.nextInt(names.length)],2010 + rnd.nextInt(6));
			}
		}
	
		for(Animal animal: animal_list){
			System.out.print(animal + " ... ");
			System.out.println(animal.noise());
		}

		/*  uncomment these lines once your Animal class implements the Comparable interface
		System.out.println( "before " + Arrays.toString(animal_list) );
		Arrays.sort(animal_list);
		System.out.println( "after  " + Arrays.toString(animal_list) );
		*/

	}
}

