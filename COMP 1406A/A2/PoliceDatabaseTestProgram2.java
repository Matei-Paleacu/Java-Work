import java.util.GregorianCalendar;

public class PoliceDatabaseTestProgram2 {
    public static void addInfractions(PoliceDatabase pdb) {
        pdb.issueInfraction("L0453-65433-87655", 75, "Illegal U-Turn",
                new GregorianCalendar(2010, 6, 14, 7, 8).getTime()).pay();
        pdb.issueInfraction("L2325-45789-35647", 175, "Speeding in excess of 20km",
                new GregorianCalendar(2011, 2, 2, 14, 22).getTime()).pay();
        pdb.issueInfraction("L2325-45789-35647", 75, "Illegal U-Turn",
                new GregorianCalendar(2012, 3, 22, 4, 34).getTime()).pay();
        pdb.issueInfraction("L2325-45789-35647", 150, "Wrong way up 1-way street",
                new GregorianCalendar(2014, 6, 14, 8, 2).getTime()).pay();
        pdb.issueInfraction("L2325-45789-35647", 500, "Running red light",
                new GregorianCalendar(2017, 9, 12, 5, 15).getTime());
        pdb.issueInfraction("L0678-67825-83940", 100, "Failure to signal",
                new GregorianCalendar(2008, 2, 3, 11, 55).getTime()).pay();
        pdb.issueInfraction("L0678-67825-83940", 250, "Speeding in excess of 30km",
                new GregorianCalendar(2010, 9, 6, 9, 22).getTime()).pay();
        pdb.issueInfraction("L0678-67825-83940", 280, "Speeding in excess of 30km",
                new GregorianCalendar(2015, 7, 7, 9, 5).getTime()).pay();
        pdb.issueInfraction("L0678-67825-83940", 300, "Speeding in excess of 30km",
                new GregorianCalendar(2017, 11, 3, 12, 15).getTime());
        pdb.issueInfraction("L0678-67825-83940", 350, "Speeding in excess of 30km",
                new GregorianCalendar(2018, 1, 1, 2, 4).getTime());
        pdb.issueInfraction("L6987-34532-43334", 500, "Running red light",
                new GregorianCalendar(2017, 7, 2, 22, 17).getTime());
        pdb.issueInfraction("L3545-45396-88983", 75, "Illegal U-Turn",
                new GregorianCalendar(2007, 3, 4, 20, 12).getTime()).pay();
        pdb.issueInfraction("L3545-45396-88983", 175, "Speeding in excess of 20km",
                new GregorianCalendar(2011, 5, 4, 23, 25).getTime()).pay();
        pdb.issueInfraction("L1144-26783-58390", 175, "Speeding in excess of 20km",
                new GregorianCalendar(2012, 10, 1, 19, 38).getTime());
        pdb.issueInfraction("GARBAGE ID", 100, "Loving Java too much",
                new GregorianCalendar(2017, 11, 24, 19, 38).getTime());
    }

    public static void main(String args[]) {
        // Make a new database and add some vehicles/owners etc..
        PoliceDatabase pdb = PoliceDatabase.example();
        addInfractions(pdb);

        System.out.println("Vehicles that should be stopped:");
        for (int i=0; i<pdb.numVehicles; i++)
            if (pdb.shouldStopVehicle(pdb.vehicles[i].plate))
                System.out.println(pdb.vehicles[i]);

        System.out.println("\nReport OH YEAH, W3EW4T and LUVJAVA as stolen:");
        pdb.reportStolen("OH YEAH");
        pdb.reportStolen("W3EW4T");
        pdb.reportStolen("LUVJAVA"); // This one won’t work, but shouldn’t crash

        System.out.println("\nVehicles that should be stopped:");
        for (int i=0; i<pdb.numVehicles; i++)
            if (pdb.shouldStopVehicle(pdb.vehicles[i].plate))
                System.out.println(pdb.vehicles[i]);

        System.out.println("\nHere are all the clean drivers:");
        for (Driver d: pdb.cleanDrivers())
            System.out.println(d);

        System.out.println("\nHere is the infraction report:");
        pdb.showInfractionReport();

        System.out.println("\nHere is the status of Jim Class:");
        pdb.showInfractionsFor("L0678-67825-83940");
    }
}

