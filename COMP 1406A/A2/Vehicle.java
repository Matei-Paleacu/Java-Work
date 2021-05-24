public class Vehicle {
    public String make;
    public String model;
    public int year;
    public String color;
    public String plate;
    public Driver owner;
    public Boolean reportedStolen = false;

    // basic method to initiate vehicle object class given the parameters
    public Vehicle(String make, String model, int year, String color, String plate){
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.plate = plate;
    }

    // default vehicle constructor
    public  Vehicle(){
        this.make = " ";
        this.model = " ";
        this.year = 0;
        this.color = " ";
        this.plate = " ";
    }

    // toString method to print out vehicle object
    public String toString(){
        if(plate == ""){
            return "";
        }
            return "A " + color + " " +  year + " " + make + " " + model + " with plate " + plate; 
    }
    
}
