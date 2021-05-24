
/** Assignment 1 - Winter 2021
  * <p>
  * Problem 3
  * <p> 
  * In this problem, you will complete three methods to check if a SUDOKU game is valid or not.
  */
  public class SudokuChecker{
   

    /** checks if row 'row' is OK in the grid */	
  public static boolean checkRow(int row, byte[][] grid){
//      int[] invalid_rows = new int[grid.length];
      int[] values = {1,2,3,4,5,6,7,8,9};
      int[] used_values = new int[values.length];
//      byte b_row = (byte) row;
      byte[] check_row = grid[row];                                     // check_row var stores the row the user wishes to check
      int i = 0;
      int pos_new_value = 0;
      
      int pos_values = 0;
      for(i = 0; i<check_row.length;i++){                               //for loop goes through each value in the row
          if(check_row[pos_values] == values[i]){                       //checks if element in row is in array values which means it is a number from 1-9
            i = -1;
              for(int z =0; z<used_values.length; z++){                 //for loop goes throught the length of used values which is an array of numbers that have already appeared in the array
                  if(check_row[pos_values] == used_values[z]){          // if check if the current ele in row is equal to ele in array
                      return false;                                     // if they are qual that means there is a double value wich makes the row false
                  }    
              }
              used_values[pos_new_value] = check_row[pos_values];   // else if the ele is not found then it is added to the used_values array
//              for(int k = 0; k<used_values.length;k++){
//                System.out.println(used_values[k]);
//              }
//              System.out.println("hi");
              pos_values++;
              pos_new_value++;
              if(used_values[8] > 0){                               //if the final ele in used values is great then zero (this means that there is a val that has been added there) then all the values in the row are correct then we return true
                return true;
              }  
          }  
      }
    return true;
  }

    /** checks if column 'col' is OK in the grid */
  public static boolean checkColumn(int col, byte[][] grid){
      int[] values = {1,2,3,4,5,6,7,8,9};
      int[] used_values = new int[values.length];
      int pos_counter = 0;
      int i =0;
      for(byte[] row: grid){                                        // for loop goes through each row in the given grid
        for(i=0;i<values.length;i++){                               //for loop goe through each ele in values array
          if(row[col] == values[i]){                                //if the row we are at with the correct row is equal to a ele in array values this means it is a number [1-9]
            i=-1;
            for(int k =0; k<used_values.length; k++){               //for loop goes through the used values array
              if(row[col] == used_values[k]){                       //if the ele we are looking at is in the used array that means that the val has already been found and is not a valid row and will return false
                return false;
              }
            }
            used_values[pos_counter] = row[col];                    // if the values is not found then it will be added to the used array
//            for(int y =0; y<used_values.length;y++){
//              System.out.println(used_values[y]);
//            }
//            System.out.println("hi");
            pos_counter++;
            if(used_values[8] > 0){                                 //if the last ele in used values array is greator than zero that means a new value has been added so all vals in the row is valid
              return true;
            }
            break;
          }
        }

      }
    return true;
  }

    /** checks if the subregion 'region' is OK in the grid */
  public static boolean checkSubregion(int region, byte[][] grid){
      int[] values = {1,2,3,4,5,6,7,8,9};
      int[] used_values = new int[values.length];
      int pos_counter = 0;
      int pos_val_counter = 0;
      int i =0;
      int m =0;
//      for(byte[] row: grid){
//        i++;
//        if(i>3 && i <7){
//          System.out.println("hi" + row[0]);
//        } else{
//          System.out.println("no" + row[0]);
//        }
//      }
      if( region == 1){                                                         // If the requested subgrid from the user is 1 the following code is executed
        for(byte[] row: grid){                                                  // for loop goes throught each row in grid
          pos_counter =0;
          for(i=0;i<values.length;i++){                                         //For loop goes throught the values array
            if(row[pos_counter] == values[i]){                                  // if checks if the value in the row is equal to a val in vcalues array
              i = -1;
              for(int k =0; k<used_values.length; k++){                     // following for loop and if is the same as previously disscused checking if the ele we are at is in used_values array, if it is then false is returned else it will be added to the array
                if(row[pos_counter] == used_values[k]){
                  return false;
                }
              }
              if(pos_counter > 2){                                          //once the counter reaches 2 it will switch to the next row to keep it on subgrid 1
                break;
              }
              used_values[pos_val_counter] = row[pos_counter];
              for(int y =0; y<used_values.length;y++){
                System.out.println(used_values[y]);
              }
              System.out.println("hi");
              pos_val_counter++;
              pos_counter++;
              if(used_values[8] > 0){
                return true;
              }
            }
          }
        }
      }
    if( region == 2){                                                     // Subgrid 2 code is the same
      for(byte[] row: grid){
        pos_counter = 3;                                                  // now counter starts at 3
        for(i=0;i<values.length;i++){
          if(row[pos_counter] == values[i]){
            i = -1;
            for(int k =0; k<used_values.length; k++){
              if(row[pos_counter] == used_values[k]){
                return false;
              }
            }
            if(pos_counter > 5){                                        // counter stops at 5 to stay on subgrid 2
              break;
            }
            used_values[pos_val_counter] = row[pos_counter];
            for(int y =0; y<used_values.length;y++){
              System.out.println(used_values[y]);
            }
            System.out.println("hi");
            pos_val_counter++;
            pos_counter++;
            if(used_values[8] > 0){
              return true;
            }
          }
        }
      }
    }
  if( region == 3){                                                   //Subgrid 3 is the same 
    for(byte[] row: grid){
      pos_counter = 6;                                                // counter starts at 6 and goes till the end of the row 
      for(i=0;i<values.length;i++){
        if(pos_counter > 8){
          break;
        }
        if(row[pos_counter] == values[i]){
          i = -1;
          for(int k =0; k<used_values.length; k++){
            if(row[pos_counter] == used_values[k]){
              return false;
            }
          }

          used_values[pos_val_counter] = row[pos_counter];
          for(int y =0; y<used_values.length;y++){
            System.out.println(used_values[y]);
          }
          System.out.println("hi");
          pos_val_counter++;
          pos_counter++;
          if(used_values[8] > 0){
            return true;
          }
        }
      }
    }
  }
  if(region == 4){
    for(byte[] row: grid){
      m++;
      if(m>3 && m<7){                                                           // new if statment is added so the rest of the code only runs when we are at the rows for the middle subgrid (4,5,6)
        pos_counter = 0;
        for(i=0;i<values.length;i++){
          if(pos_counter > 2){
            break;
          }
          if(row[pos_counter] == values[i]){
            i = -1;
            for(int k =0; k<used_values.length; k++){
              if(row[pos_counter] == used_values[k]){
                return false;
              }
            }
  
            used_values[pos_val_counter] = row[pos_counter];
            for(int y =0; y<used_values.length;y++){
              System.out.println(used_values[y]);
            }
            System.out.println("hi");
            pos_val_counter++;
            pos_counter++;
            if(used_values[8] > 0){
              return true;
            }
          }
        }

      }

    }
  }
  if(region == 5){
    for(byte[] row: grid){
      m++;
      if(m>3 && m<7){
        pos_counter = 3;
        for(i=0;i<values.length;i++){
          if(pos_counter > 5){
            break;
          }
          if(row[pos_counter] == values[i]){
            i = -1;
            for(int k =0; k<used_values.length; k++){
              if(row[pos_counter] == used_values[k]){
                return false;
              }
            }
  
            used_values[pos_val_counter] = row[pos_counter];
            for(int y =0; y<used_values.length;y++){
              System.out.println(used_values[y]);
            }
            System.out.println("hi");
            pos_val_counter++;
            pos_counter++;
            if(used_values[8] > 0){
              return true;
            }
          }
        }

      }

    }
  }
  if(region == 6){
    for(byte[] row: grid){
      m++;
      if(m>3 && m<7){
        pos_counter = 6;
        for(i=0;i<values.length;i++){
          if(pos_counter > 8){
            break;
          }
          if(row[pos_counter] == values[i]){
            i = -1;
            for(int k =0; k<used_values.length; k++){
              if(row[pos_counter] == used_values[k]){
                return false;
              }
            }
  
            used_values[pos_val_counter] = row[pos_counter];
            for(int y =0; y<used_values.length;y++){
              System.out.println(used_values[y]);
            }
            System.out.println("hi");
            pos_val_counter++;
            pos_counter++;
            if(used_values[8] > 0){
              return true;
            }
          }
        }

      }

    }
  }
  if(region == 7){
    for(byte[] row: grid){
      m++;
      if(m>6){                                                        // if statments is now adjusted to used the last 3 rows for the final 3 subgrids (7,8,9)
        pos_counter = 0;
        for(i=0;i<values.length;i++){
          if(pos_counter > 2){
            break;
          }
          if(row[pos_counter] == values[i]){
            i = -1;
            for(int k =0; k<used_values.length; k++){
              if(row[pos_counter] == used_values[k]){
                return false;
              }
            }
  
            used_values[pos_val_counter] = row[pos_counter];
            for(int y =0; y<used_values.length;y++){
              System.out.println(used_values[y]);
            }
            System.out.println("hi");
            pos_val_counter++;
            pos_counter++;
            if(used_values[8] > 0){
              return true;
            }
          }
        }

      }

    }
  }
  if(region == 8){
    for(byte[] row: grid){
      m++;
      if(m>6){
        pos_counter = 3;
        for(i=0;i<values.length;i++){
          if(pos_counter > 5){
            break;
          }
          if(row[pos_counter] == values[i]){
            i = -1;
            for(int k =0; k<used_values.length; k++){
              if(row[pos_counter] == used_values[k]){
                return false;
              }
            }
  
            used_values[pos_val_counter] = row[pos_counter];
            for(int y =0; y<used_values.length;y++){
              System.out.println(used_values[y]);
            }
            System.out.println("hi");
            pos_val_counter++;
            pos_counter++;
            if(used_values[8] > 0){
              return true;
            }
          }
        }

      }

    }
  }
  if(region == 9){
    for(byte[] row: grid){
      m++;
      if(m>6){
        pos_counter = 6;
        for(i=0;i<values.length;i++){
          if(pos_counter > 8){
            break;
          }
          if(row[pos_counter] == values[i]){
            i = -1;
            for(int k =0; k<used_values.length; k++){
              if(row[pos_counter] == used_values[k]){
                return false;
              }
            }
  
            used_values[pos_val_counter] = row[pos_counter];
            for(int y =0; y<used_values.length;y++){
              System.out.println(used_values[y]);
            }
            System.out.println("hi");
            pos_val_counter++;
            pos_counter++;
            if(used_values[8] > 0){
              return true;
            }
          }
        }

      }

    }
  }
return true;
  }




  public static boolean check(byte[][] grid){
    // check the subregions
    for(int subregion=0; subregion<9; subregion+=1){  
      if( !checkSubregion(subregion, grid) ){
        return false;
      }
    }

    // check the rows
    for(int row=0; row<9; row+=1){                    
      if( !checkRow(row, grid) ){
        return false;
      }
    }

   // check the rows
   for(int col=0; col<9; col+=1){                    
      if( !checkColumn(col, grid) ){
        return false;
      }
    }
  
        
        // if we get this far then we conclude that the grid
        // must be valid (because if it was not, we would have
        // returned false somewhere above)
    return true;
  }
    


  public static void main(String[] args){
  //  System.out.println(checkRow(0,example1));
  //  System.out.println(checkColumn(0, example1));
  System.out.println(checkSubregion(9, example1));

//    System.out.print("exmample1 | expected output is true  | actual output is ");
//    System.out.println(check(example1));

//    System.out.print("exmample2 | expected output is false | actual output is ");
//    System.out.println(check(example2));

  }


    /** sample valid game */
  public static byte[][] example1 = new byte[][]{
    {5,3,4,6,7,8,9,1,2},
    {6,7,2,1,9,5,3,4,8},
    {1,9,8,3,4,2,5,6,7},
    {8,5,9,7,6,1,4,2,3},
    {4,2,6,8,5,3,7,9,1},
    {7,1,3,9,2,4,8,5,6},
    {9,6,1,5,3,7,2,8,4},
    {2,8,7,4,1,9,6,3,5},
    {3,4,5,2,8,6,1,7,9}};

  /** sample invalid game */
  public static byte[][] example2 = new byte[][]{
    {5,3,4,6,7,8,9,1,2},
    {6,7,2,1,9,5,3,4,8},
    {1,9,8,3,4,2,5,6,7},
    {8,5,9,7,6,1,4,2,3},
    {4,2,6,8,5,3,7,9,1},
    {7,1,3,9,2,4,8,5,6},
    {9,6,1,5,3,7,2,8,3},
    {2,8,7,4,1,9,6,2,6},
    {3,4,5,2,8,6,1,8,8}};

}