import java.util.GregorianCalendar;

public class PoliceDatabaseTestProgram {
    public static void main(String args[]) {
        PoliceDatabase pdb = PoliceDatabase.example();

        System.out.println("Here are the drivers:");
        for (int i=0; i<pdb.numDrivers; i++)
            System.out.println(pdb.drivers[i]);

        System.out.println("\nHere are the vehicles:");
        for (int i=0; i<pdb.numVehicles; i++)
            System.out.println(pdb.vehicles[i]);
            

        System.out.println("\nRemoving 3 vehicles (i.e., W3EW4T, FUNFUN and CATCHME) ...");
        pdb.unregisterVehicle("W3EW4T");
        pdb.unregisterVehicle("FUNFUN");
        pdb.unregisterVehicle("CATCHME");
        System.out.println("\nHere are the remaining vehicles:");
        for (int i=0; i<pdb.numVehicles; i++)
            System.out.println(pdb.vehicles[i]);

        System.out.println("\nHere is the owner of the Honda Accord:");
        System.out.println(pdb.vehicles[4].owner);
        System.out.println("Ilene Dover sells the car to Sam Pull, here is the owner now:");
        pdb.changeOwner("7U3H5E", "L3545-45396-88983");
        System.out.println(pdb.vehicles[4].owner);

        System.out.println("\nHere are the stolen cars at this time:");
        for (int i=0; i<pdb.numVehicles; i++)
            if (pdb.vehicles[i].reportedStolen)
                System.out.println(pdb.vehicles[i]);
        
        System.out.println("\nReport some cars as stolen...");
        pdb.reportStolen("OH YEAH");
        pdb.reportStolen("OLDIE");

        System.out.println("\nHere are the stolen cars now:");
        for (int i=0; i<pdb.numVehicles; i++)
            if (pdb.vehicles[i].reportedStolen)
                System.out.println(pdb.vehicles[i]);

        System.out.println("\nHere are some infractions:");
        Infraction i = new Infraction(75.0f, "Illegal U-Turn",
                new GregorianCalendar(2017, 11, 14, 7, 8).getTime());
        i.pay();
        System.out.println(i);
        System.out.println(new Infraction(175.0f, "Speeding in excess of 20km",
                new GregorianCalendar(2018, 1, 2, 14, 22).getTime()));
        for(int k = 0;k<pdb.infractions.length;k++)
            System.out.println(pdb.infractions[k].driver);
    }
}
