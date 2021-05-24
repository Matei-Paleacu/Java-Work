/**
 * A Temperature object represents temperature (with a value and scale)
 * Assignment 2
 */

public class Temperature{
  public  double temp_Out;
  public  String st;
  public  Scale s;



    /** Initializes a temperature object with given value in Celcius
     *
     *  If the initial temperature is less than -273.15C then the temperature
     *  object will be initialized with -273.15C.
     *
     * @param temp is the initial temperature in Celsius.
     */
      public Temperature(double temp){
        if(temp < -273.15){     //checks if temp
          temp = -273.15;
        }
        temp_Out = temp;
        s = Scale.CELSIUS;
        st = Double.toString(temp);
        st = st + "C";
          

      }
    
    
    /** Initializes a temperature object with given value using the specified scale
     * <par>
     * If the temperature is lower than absolute zero, in the given scale,
     * then set the temperature to absolute zero (in that scale).
     * <par>
     * Example: new Temperature(12.3, Scale.KELVIN)
     *
     * @param temp is the initial temperature
     * @param scale is the scale of initial temperature and must a constant
     *        defined in the Scale enum type.
     */
      public Temperature(double temp, Scale scale){

        if(scale.toString() == "CELSIUS"){  //check if scale is celsius
          if(temp < -273.15){ // absolute zero
            temp = -273.15;
          }
          s = Scale.CELSIUS;
          st = Double.toString(temp);
          st = st + "C";
        }
        if(scale.toString() == "FAHRENHEIT"){ //check if scale is farenheit
          if(temp < -459.67){ // absolute zero
            temp = -459.67;
          }
          s = Scale.FAHRENHEIT;
          st = Double.toString(temp);
          st = st + "F";
        }
        if(scale.toString() == "KELVIN"){ // check if scale is kelvin
          if(temp < 0){       //absolute zero
            temp = 0;
          }
          s = Scale.KELVIN;
          st = Double.toString(temp);
          st = st + "K";
        }
        temp_Out = temp;
      }
    
    
    /** Initializes a temperature object with given value using the specified scale
     * <par>
     * If the temperature is lower than absolute zero, in the given scale,
     * then set the temperature to absolute zero (in that scale).
     * <par>
     * Example: each of the following will create the same temerature 12.3K
     *          new Temperature(12.3, "Kelvin")
     *          new Temperature(12.3, "k")
     *          new Temperature(12.3, "kel"
     *
     * @param temp is the initial temperature
     * @param scale is a the scale of initial temperature. As long as the input string
     *        can uniquely identify one of the three scales it is acceptable.
     *        Case is not important. Abbreviations are allowed.
     */
      public Temperature(double temp, String scale){
        temp_Out = temp;
        String start_temp = scale.toString().toUpperCase();
        if(start_temp.charAt(0) == 'C'){  // checks if the first letter is caps C
          if(temp < -273.15){ // absolute zero
            temp = -273.15;
          }
          s = Scale.CELSIUS;
          st = Double.toString(temp);
          st = st + "C";
        }
        if(start_temp.charAt(0) == 'F'){ // checks if the first letter is caps F
          if(temp < -459.67){ // absolute zero
            temp = -459.67;
          }
          s = Scale.FAHRENHEIT;
          st = Double.toString(temp);
          st = st + "F";
        }
        if(start_temp.charAt(0) == 'K'){ // checks if the first letter is caps K
          if(temp < 0){ // absolute zero
            temp = 0;
          }
          s = Scale.KELVIN;
          st = Double.toString(temp);
          st = st + "K";
        }
      }
    
    
    
    
    /** getter for the scale. The output will always be one of the enum objects from Scale.
     *
     * @return the current scale of this object. 
     */
      public Scale getScale(){
        return s;
      }
    
     /** getter for the temperature
      *
      * @return the temperature of the object using the current scale
      */
      public double getTemp(){
        return temp_Out;
      }
    
    
      /** setter for scale
      *
      * @param scale is the new scale of the temperature and must be
      *        a constant from the Scale enum type.
      */
      public void setScale(Scale scale){
        String start_temp = scale.toString().toUpperCase();
        if(s.toString() == "CELSIUS"){ // conversion from celsius to wanted temp
          if(start_temp.charAt(0) == 'F'){ // going to fahrenheit
            s = Scale.FAHRENHEIT;
            temp_Out = (temp_Out*1.8)+32;
            st = Double.toString(temp_Out);
            st = st + "F";
          }
          if(start_temp.charAt(0) == 'C'){ // going to celsius
            s = Scale.CELSIUS;
            st = Double.toString(temp_Out);
            st = st + "C";
          }
          if(start_temp.charAt(0) == 'K'){ // going to kelvin
            s = Scale.KELVIN;
            temp_Out = temp_Out+273.15;
            st = Double.toString(temp_Out);
            st = st + "K";
          }
        }
        if(s.toString() == "FAHRENHEIT"){ // conversion from fahrenheit to wanted temp
          if(start_temp.charAt(0) == 'F'){ // going to fahrenheit
            s = Scale.FAHRENHEIT;
            st = Double.toString(temp_Out);
            st = st + "F";
          }
          if(start_temp.charAt(0) == 'C'){ // going to celsius
            s = Scale.CELSIUS;
            temp_Out = (temp_Out-32)*(0.5555);
            st = Double.toString(temp_Out);
            st = st + "C";
          }
          if(start_temp.charAt(0) == 'K'){ // going to kelvin
            s = Scale.KELVIN;
            temp_Out = (temp_Out-32)*(0.5555) + 273.15;
            st = Double.toString(temp_Out);
            st = st + "K";
          }
        }
        if(s.toString() == "KELVIN"){ // conversion from kelvin to wanted temp
          if(start_temp.charAt(0) == 'F'){// going to fahrenheit
            s = Scale.FAHRENHEIT;
            temp_Out = (temp_Out-273.15)*(1.8) + 32;
            st = Double.toString(temp_Out);
            st = st + "F";
          }
          if(start_temp.charAt(0) == 'C'){// going to celsius
            s = Scale.CELSIUS;
            temp_Out = temp_Out-273.15;
            st = Double.toString(temp_Out);
            st = st + "C";
          }
          if(start_temp.charAt(0) == 'K'){// going to kelvin
            s = Scale.KELVIN;
            st = Double.toString(temp_Out);
            st = st + "K";
          }
        }
        

      }
    
    
    
      /** setter for temperature
      *  <par>
      * If the temperature is lower than absolute zero, in the given scale,
      * then sets the temperature to absolute zero (in that scale).
      *
      * @param temp is the new temperature
      * @param scale is the scale of the new temperature. It must be
      *        a constant from the Scale enum type.
      */
      public void setTemp(double temp, Scale scale){
        String start_temp = scale.toString().toUpperCase();

        if(start_temp.charAt(0) == 'F'){ // checks if first char is F
          if(temp < -459.67){ // absolute zero
            temp = -459.67;
          }
          s = Scale.FAHRENHEIT;
          st = Double.toString(temp_Out);
          st = st + "F";
        }
        if(start_temp.charAt(0) == 'C'){ // checks if first char is C
          if(temp < -273.15){ // absolute zero
            temp = -273.15;
          }
          s = Scale.CELSIUS;
          st = Double.toString(temp_Out);
          st = st + "C";
        }
        if(start_temp.charAt(0) == 'K'){ // checks if first char is K
          if(temp < 0){ // absolute zero
            temp = 0;
          }
          s = Scale.KELVIN;
          st = Double.toString(temp_Out);
          st = st + "K";
        }
        temp_Out = temp;
      }
    
    
    
    
    
    
    
    
    
    
    /* ------------------------------------------------- */
    /* ------------------------------------------------- */
    /* do not change anything below this                 */
    /* ------------------------------------------------- */
    /* ------------------------------------------------- */
    
    
    
      /** String representation of a temperature object    */
      @Override
      public String toString(){
        return "" + this.getTemp() + this.getScale().name().charAt(0);
      }

      /** Gives names to the three temperature 
    scales we will consider in this assignment.
*/

public enum Scale{
	CELSIUS, FAHRENHEIT, KELVIN, NONE;
}
public static void main(String[] args){ // main used for testing methods
    Temperature t = new Temperature(-500, "f");
    System.out.println(t.st);
    System.out.println(t.getScale());
    t.setScale(Scale.KELVIN);
    System.out.println(t.getScale());
    System.out.println(t.st);
    t.setScale(Scale.FAHRENHEIT);
    System.out.println(t.st);
    System.out.println(t.getScale());
    }
 }
