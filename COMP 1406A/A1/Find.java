public class Find {
    // Function locate_Sequence calculated given a sequence input wether that sequence exists in the stored array. If it does exitst
    // then it will return the position of the first value in the sequence otherwise it returns -1
    static int[] locate_Sequence(int[] x){
                int[] output_value = {-1};
                int[] numbers = {3,6,9,7,5,1,0,8};
                System.out.println(numbers.length);
                int values_has_been_found = 0;
                int last_matched_value = 0;
                int number_of_matches_found = 0;
                for(int i = 0; i< x.length; i++){                                   // For loop goes the the inputed array of sequence
                    for( int k = 0; k < numbers.length; k++){                        // For loop goes throught the stored array
                        if(x[i] == numbers[k]){                                     //If statment compares if the current value of the inputed sequence is equal to the current value in the given array
                            number_of_matches_found++;
                            if (values_has_been_found == 0){                        //If statment is used to only store the first position of the sequence to be returned
                                values_has_been_found++;
                                output_value[0] = k;
                                last_matched_value = output_value[0];
                            } else {                                                 //This else will the executed if there is more than one value that is present in the inputed sequence
                                if(last_matched_value + 1 < k){                    //If statment uses the starting position of the sequence that was stored as the var "last_matched_value", and cheques if that value plus 1 is less than var k
                                                                                   // which is the counter used to move throught the original given array. This means if the k var is larger
                                                                                   // we know that there was a value in the provided sequence that is not in the given array and was moved over.
                                    output_value[0] = -1;
                                    return output_value;                           //If there is a value in the provided sequence that is not in the array then the program will automatically return -1 with going throught the rest of the inputed sequence
                                }
                                last_matched_value = last_matched_value + 1;
                            }
                        }
                    }
                }
                if (number_of_matches_found < x.length){                          //This if statment is used befor returing the value of the sequence to check if there are any values that where entered in the input that where not in the input
                    output_value[0] = -1;
                }
                return output_value;
            } 

    public static void main(String[] args) {
        int[] input_values = {7,5,1,0};
        int[] output = locate_Sequence(input_values);
        System.out.println(output[0]);
    }
}
