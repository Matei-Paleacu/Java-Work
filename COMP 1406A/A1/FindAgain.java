

public class FindAgain {
    //locate_all_sequence_locations method takes a target sequence and an array and returns how many times the sequences appears in the array along with the 
    // exact positions where they are found.
    public static int[] locate_all_sequence_locations (int[] target, int[] array){
        int[] output_value = array;
        int values_has_been_found = 1;
        int number_of_matches_found = 0;
        boolean found_actual_sequence = false;
        
        for(int i = 0; i< target.length; i++){                                          //for loop goes through the given target sequence to find
//            System.out.println(target[i] + " tar");                               
            for( int k = 0; k < array.length; k++){                                     //for loop goes throught the given array
//                System.out.println(array[k] + " arr");                    
                if(target[i] == array[k]){                                             //if checks if the element we are at in the given sequence can be found in the given array input
//                    System.out.println(target[i] + " match");
                    int  part_of_array = k;
                    for(int z = 0; z<target.length;z++){                             
//                        System.out.println(array[part_of_array] + " array part");
                        if(part_of_array == array.length  ){                           // if checks if we are at the end of the given array
                            found_actual_sequence = false;
                        } else{
                            if(target[z] == array[part_of_array]){                    // if checks if the elements we are at is in the target sequence if found the sqitches the bool var to true
                                found_actual_sequence = true;
                            } else{
                                found_actual_sequence = false;
                            }
                            part_of_array++;
                        }
                    }
//                    System.out.println(found_actual_sequence);
                    if(found_actual_sequence == true){                              // if the found bool var is true then we have found a match and changes var as needed
                        number_of_matches_found++;                      
                        output_value[values_has_been_found] = k;
                        values_has_been_found++;
                    }
//                    System.out.println(k + " k");
//                    System.out.println(array.length + " lenttt");
//                    System.out.println(k+2 == array.length );
                    if(k+2 == array.length){                                        // if we are at the end of going throught our given array we adjust the output value
                        int [] final_output = new int[number_of_matches_found+1];
                        output_value[0] = number_of_matches_found;
                        for(int g = 0; g<number_of_matches_found+1; g++){          // for loop is used to create a new array that is used to return to the user
//                            System.out.println(g + " g");
                            final_output[g] = output_value[g];
                        }
                        return final_output;
                    }                             
                }
            }
        }
        int [] final_output = new int[number_of_matches_found+1];
        output_value[0] = number_of_matches_found;
        for(int g = 0; g<number_of_matches_found+1; g++){       // for loop does the same thing as above making a new array to return to only take the first elements from the output_value array
//            System.out.println(g + " g");
           final_output[g] = output_value[g];
        }
        return final_output;
    }
    public static void main(String[] args) {
        int[] input_values = {1,2,3,1,2,4,1};
        int[] t1 = {4,1};
        int[] output = locate_all_sequence_locations(t1,input_values);
        for(int h = 0; h<output.length; h++){
            System.out.println(output[h]);
        }
        
    }
}

