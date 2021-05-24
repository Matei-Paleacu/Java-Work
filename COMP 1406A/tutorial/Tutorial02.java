import java.util.Random;

public class Tutorial02{

	// an array of strings to use
	public static String[] words = {"cat", "dog", "eel", "owl", "fox", "kitten", "puppy", "elver", "owlet", "kit"};

	public static void strings(){
        int char_num = 0;
        String long_word = "";
        for(String w: words){
            //String current_word = w;
            System.out.println(w.substring(0,1).toUpperCase() + w.substring(1) + ", is " + w.length() + " letters long.");
            char_num += w.length();
            if( long_word.length() < w.length()){
                long_word = w;
            }
        }
        System.out.println("The longest word is " + long_word.toUpperCase());
        System.out.println("There were " + String.valueOf(char_num) + " characters in total.");
	}
	// .toUpperCase()
	public static int[][] rollRandomDice(int n, long seed){
		Random d1 = new Random();
		Random d2 = new Random();
		int[][] rolls = new int[6][6];
		// probably should use a loop since you need more than 1-2 rolls, even 3600 rolls later on.
		int first_roll = d1.nextInt(6);
		int second_roll = d2.nextInt(6);
		//first_roll ++;
		//second_roll ++;



			for(int x = 0; x<36; x++){
				first_roll = d1.nextInt(6);
				second_roll = d2.nextInt(6);
				rolls[first_roll][second_roll] ++;
				//System.out.print(first_roll);
				//System.out.println(second_roll);
			}
		
		return null;
	}
	
	public static void diceRollResults(int[][] rolls){

		System.out.println(java.util.Arrays.deepToString(rolls));

	}
	

	public static void testPoint2D(){
		// 
		// add your code for part 3 here
		//
	}
	
	public static void main(String[] args){
		// Question 1
		System.out.println("Question 1\n----------");
		strings();

		// Question 2
		System.out.println("\nQuestion 2\n----------");
		int[][] rolls = rollRandomDice(36, 0);
		diceRollResults(rolls);
		
		// Question 3
		System.out.println("\nQuestion 3\n----------");
		testPoint2D();
	
	}
	
}