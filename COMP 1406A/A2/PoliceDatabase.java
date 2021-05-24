import java.util.Date;
public class PoliceDatabase {
    Vehicle[] vehicles;
    int numVehicles = 0;
    Driver[] drivers;
    int numDrivers = 0;
    Infraction[] infractions;
    int numInfraction = 0;
    int max_numDriver = 2000;
    int max_numVehicles = 1000;
    int max_numInfractions = 800;

    //initializes policedata base arrays
    public PoliceDatabase(){
        vehicles = new Vehicle[1000];
        drivers = new Driver[2000];
        infractions = new Infraction[800];      
    }

    //method used to register a driver object in the driver object array
    public void registerDriver(Driver aDriver){
        if(numDrivers < max_numDriver){
            drivers[numDrivers] = aDriver;
            numDrivers ++;
        }
    }
// take licesnse and look throught drivers to find matching driver then set aVehicle.ower = to the driver we found with the matching license plater
    public void registerVehicle(Vehicle aVehicle, String license){
        if(numVehicles < max_numVehicles){
            vehicles[numVehicles] = aVehicle;
            numVehicles ++;
        }
        for(int i = 0; i<drivers.length; i++){// for loop goes through drivers
            if(drivers[i].license == license){ //compares the drivers license with the given one in method
                aVehicle.owner = drivers[i];
                break;
            }
        }
    }

    public void unregisterVehicle(String plate){ //use array list?
//        int pos_of_remove_value = 0;
        int i = 0;
        for(i = 0; i<vehicles.length; i++){
            if(vehicles[i].plate == plate){ // finds plate of vehicle the needs to be removed
//                pos_of_remove_value = i;
                vehicles[i].make = "";
                vehicles[i].model = "";
                vehicles[i].year = 0;
                vehicles[i].color = "";
                vehicles[i].plate = "";
                break;
            }
        }
        /*
        System.out.println("here");
        for(int k = 0; k<pos_of_remove_value; k++){
            vehicles_new[k] = vehicles[k];
        }
        System.out.println("here2");
        for(int j = pos_of_remove_value+1; j<vehicles.length;j++){
            vehicles_new[j] = vehicles[j];
        }
        System.out.println("here3");
        int yk = 0;
        for(int l = 0; l<vehicles_new.length; l++){
            if(vehicles_new[l] != null){
                System.out.println("true");
                vehicles[yk] = vehicles_new[l];
                yk++;
            }
   
        }
        */
//        for(int h = 0; h<vehicles.length;h++){
//            System.out.println(vehicles[h]);
//        }
//        System.out.println("here4");
//        int k = i+1;
//        int j = i;
//        for(j =i;j<vehicles.length;j++){
//            vehicles[j] = vehicles[k];
//            k++;
//       }
    }

    //method changes bool reportedStole as true
    public void reportStolen(String plate){
        for(int i = 0; i<vehicles.length;i++){
            if(vehicles[i] == null){
                break;
            }
            if(vehicles[i].plate == plate){ // if the vehicle passed in is found then its bool reportedStolen is set to true
                vehicles[i].reportedStolen = true;
                break;
            }
        }
    }

    public void changeOwner(String plate, String license){
        String name = "";
        String street= "";
        String city= "";
        String province= "";
        for(int k = 0; k<vehicles.length;k++){            //for loops finds the new owner with the info of: name,street, city, province, to be used to change
            if(vehicles[k].owner.license == license ){
                 name = vehicles[k].owner.name ;
                 street = vehicles[k].owner.street ;
                 city = vehicles[k].owner.city ;
                 province = vehicles[k].owner.province ;
                 break;
            }
        }
        for(int i = 0; i<vehicles.length;i++){
            if(vehicles[i].plate == plate ){ //once the plate that is needed too be changed is found all the info is changed and set
                vehicles[i].owner.license = license;// opens for loop to find other driver to change name and address and all info accordingly
                vehicles[i].owner.name = name;
                vehicles[i].owner.street = street;
                vehicles[i].owner.city = city;
                vehicles[i].owner.province = province;
                break;
            }
        }
    }

    //method creates a new infraction object that is stored with the passed in data, along with the licese of the driver is passed in
    public Infraction issueInfraction(String license, float amount, String description, Date date){
        Infraction i = new Infraction(amount, description,date);
        for(int k = 0; k<drivers.length;k++){
            if(drivers[k] == null){
                break;
            }
            if(drivers[k].license == license){
                i.driver = drivers[k];
                i.driver.license = license;
                break;
            }
        }
        if(numInfraction < max_numInfractions){ 
            infractions[numInfraction] = i;
            numInfraction ++;
        }
        
        
        return i; 
    }

    //method checks if the passed in driver has any infractions by lookingthrought the infractions array
    public boolean hasOutstandingInfraction(Driver d){
        String license = d.license;
        for(int i = 0;i<infractions.length;i++){
            if(infractions[i].driver == null){
                break;
            }
            if(infractions[i].driver.license == license){
                if(infractions[i].outstanding == false){
                    return true;
                }
            }
        }
        return false;
    }

    //methode checks if the passes in plate has any outstanding infractions that are not payed or if it has been reported stolen
    public boolean shouldStopVehicle(String plate){
        Driver owner;
        boolean outstanding = false;
        for(int i =0; i<vehicles.length;i++){ //for loops goes throught vehicles length
            if(vehicles[i].plate == plate){ // checks if the inpute plate is a match
                owner = vehicles[i].owner;
                outstanding = hasOutstandingInfraction(owner);
                if(outstanding == true || vehicles[i].reportedStolen == true){ //if checks if outstanding is false, checks if the vehicle is reported as true
                    return true;
                }else{
                    break;
                }

            }
 
        }
        return false;
    }
    // displayes the current infractions for a current passed in license 
    public void showInfractionsFor(String license){
        int num_of_outstanding_infractions = 0;
        String infraction ="";
        for(int i = 0; i<infractions.length;i++){    //for loop goes throught the infractions object array
            if(infractions[i].driver == null){
                break;
            }
            if(infractions[i].driver.license == license){  //checks if the current infraction object has a matching licesne as the one passed in
                infraction = infractions[i].toString();
                System.out.println(infraction);
                if(infractions[i].outstanding == false){ //checks if the infraction that the llop is on is still yet to be payed
                    num_of_outstanding_infractions++;
                }
            }
        }
        System.out.println("Total outstanding infractions = " + num_of_outstanding_infractions);
    }
    //returns object array of drivers that havent resived and infraction
    public Driver[] cleanDrivers(){
        int num_of_clean_drivers = 0;
        int num_of_non_clean_drivers = 0;
        for(int k = 0; k<drivers.length;k++){            //for loop goes throught each driver that had been stored
            num_of_non_clean_drivers = 0;
            for(int i = 0; i<infractions.length;i++){   //for loop goes throught each infraction
                if(infractions[i] == null){
                    break;
                }
                if(drivers[k] == infractions[i].driver){ //if checks if the current driver in loop has an infraction(is present in the infraction object array)
                    num_of_non_clean_drivers++;
                }
            }
            if(num_of_non_clean_drivers == 0){ // if the drivers was not found in the infracction array then it is added as a clean driver
                num_of_clean_drivers++;
            }
        }
        Driver[] clean_drivers = new Driver[num_of_clean_drivers];  // sets array size based on the number of clean drivers so there are no "null" spots
        num_of_clean_drivers = 0;
        for(int k = 0; k<drivers.length;k++){             //for loops do the same as the ones above
            num_of_non_clean_drivers = 0;
            for(int i = 0; i<infractions.length;i++){
                if(infractions[i] == null){
                    break;
                }
                if(drivers[k] == infractions[i].driver){
                    num_of_non_clean_drivers++;
                }
            }
            if(num_of_non_clean_drivers == 0){  //this time if the driver is listed as a clean driver then it is added to the clean drivers object array ewhich is reatured
                clean_drivers[num_of_clean_drivers] = drivers[k]; // the position in the array is also showed by var clean array which is changed each time a new player is added
                num_of_clean_drivers++;
            }
        }
        return clean_drivers;
    }

    // method shows all drivers that have had atleast one infraction
    public void showInfractionReport(){
        String output = "";
        Driver owner;
        int num_of_infractions = 0;
        double total_paid = 0.0;
        for(int k = 0; k<drivers.length;k++){ //for loop goes throught drivers object array
            owner = drivers[k];
            num_of_infractions = 0;
            total_paid = 0.0;
            for(int i = 0; i<infractions.length;i++){ // for loops goes throught infraction objects array
                if(infractions[i].driver == null){
                    break;
                }
                if(infractions[i].driver == drivers[k]){ // checks the matching drivers
                    num_of_infractions++;
                    if(infractions[i].outstanding == true){ // checks if the infraction has been paid yet, then it is adde to total paid
                        total_paid += infractions[i].amount;
                    }
                }
            }
            if(num_of_infractions > 0){ // if only used if the current driver has had an infraction then outputs the below string
                 output = String.format("%20s", owner.name + ": " + num_of_infractions + " infractions, total paid = $ " + String.format("%.2f", total_paid));
                 System.out.println(output);
            }
            
        }
    }

    public static  PoliceDatabase example() { // Register all drivers and their vehicles
        PoliceDatabase pdb = new PoliceDatabase();
    
        pdb.registerDriver(new Driver("L1567-34323-84980", "Matt Adore",
                "1323 Kenaston St.", "Gloucester", "ON"));
        pdb.registerDriver(new Driver("L0453-65433-87655", "Bob B. Pins",
                "32 Rideau Rd.", "Greely", "ON"));
        pdb.registerDriver(new Driver("L2333-45645-54354", "Stan Dupp",
                "1355 Louis Lane", "Gloucester", "ON"));
        pdb.registerDriver(new Driver("L1234-35489-99837", "Ben Dover",
                "2348 Walkley Rd.", "Ottawa", "ON"));
        pdb.registerDriver(new Driver("L8192-87498-27387", "Patty O'Lantern",
                "2338 Carling Ave.", "Nepean", "ON"));
        pdb.registerDriver(new Driver("L2325-45789-35647", "Ilene Dover",
                "287 Bank St.", "Ottawa", "ON"));
        pdb.registerDriver(new Driver("L1213-92475-03984", "Patty O'Furniture",
                "200 St. Laurant Blvd.", "Ottawa", "ON"));
        pdb.registerDriver(new Driver("L1948-87265-34782", "Jen Tull",
                "1654 Stonehenge Cres.", "Ottawa", "ON"));
        pdb.registerDriver(new Driver("L0678-67825-83940", "Jim Class",
                "98 Oak Blvd.", "Ottawa", "ON"));
        pdb.registerDriver(new Driver("L0122-43643-73286", "Mark Mywords",
                "3 Third St.", "Ottawa", "ON"));
        pdb.registerDriver(new Driver("L6987-34532-43334", "Bob Upandown",
                "434 Gatineau Way", "Hull", "QC"));
        pdb.registerDriver(new Driver("L3345-32390-23789", "Carrie Meehome",
                "123 Thurston Drive", "Kanata", "ON"));
        pdb.registerDriver(new Driver("L3545-45396-88983", "Sam Pull",
                "22 Colonel By Drive", "Ottawa", "ON"));
        pdb.registerDriver(new Driver("L1144-26783-58390", "Neil Down",
                "17 Murray St.", "Nepean", "ON"));
        pdb.registerDriver(new Driver("L5487-16576-38426", "Pete Reedish",
                "3445 Bronson Ave.", "Ottawa", "ON"));
        pdb.registerVehicle(new Vehicle("Honda", "Civic", 2015, "yellow", "W3EW4T"),
                "L0453-65433-87655");
        pdb.registerVehicle(new Vehicle("Pontiac","Grand Prix",2007,"dark green","GO SENS"),
                "L0453-65433-87655");
        pdb.registerVehicle(new Vehicle("Mazda", "RX-8", 2004, "white", "OH YEAH"),
                "L2333-45645-54354");
        pdb.registerVehicle(new Vehicle("Nissan","Altima",2017,"bergundy", "Y6P9O7"),
                "L1234-35489-99837");
        pdb.registerVehicle(new Vehicle("Saturn", "Vue", 2002, "white", "9R6P2P"),
                "L2325-45789-35647");
        pdb.registerVehicle(new Vehicle("Honda", "Accord", 2018, "gray", "7U3H5E"),
                "L2325-45789-35647");
        pdb.registerVehicle(new Vehicle("Chrysler", "PT-Cruiser", 2006, "gold", "OLDIE"),
                "L2325-45789-35647");
        pdb.registerVehicle(new Vehicle("Nissan", "Cube", 2010, "white", "5Y6K8V"),
                "L1948-87265-34782");
        pdb.registerVehicle(new Vehicle("Porsche", "959", 1989, "silver", "CATCHME"),
                "L0678-67825-83940");
        pdb.registerVehicle(new Vehicle("Kia", "Soul", 2018, "red", "J8JG2Z"),
                "L0122-43643-73286");
        pdb.registerVehicle(new Vehicle("Porsche", "Cayenne", 2014, "black", "EXPNSV"),
                "L6987-34532-43334");
        pdb.registerVehicle(new Vehicle("Nissan", "Murano", 2010, "silver", "Q2WF6H"),
                "L3345-32390-23789");
        pdb.registerVehicle(new Vehicle("Honda", "Element", 2008, "black", "N7MB5C"),
                "L3545-45396-88983");
        pdb.registerVehicle(new Vehicle("Toyota", "RAV-4", 2010, "green", "R3W5Y7"),
                "L3545-45396-88983");
        pdb.registerVehicle(new Vehicle("Toyota", "Celica", 2006, "red", "FUNFUN"),
                "L5487-16576-38426");
    
        return pdb;
    }

}

