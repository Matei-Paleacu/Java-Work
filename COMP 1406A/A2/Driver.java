public class Driver {
    public String license;
    public String name;
    public String street;
    public String city;
    public String province;

    // basic method to initiate driver object class given the parameters
    public  Driver(String license, String name, String street, String city, String province){
        this.license = license;
        this.name = name;
        this.street = street;
        this.city = city;
        this.province = province;
    }
    // default driver constructor
    public  Driver(){
        this.license = " ";
        this.name = " ";
        this.street = " ";
        this.city = " ";
        this.province = " ";
    }
    // toString method to print out driver object
    public String toString(){
        return "#" + license + " " +  name + " living at " + street+ ", " + city + ", " + province;
    }
    
}
