import java.util.GregorianCalendar;

public class ClientTester {
    public static void main(String args[]) {
        // Create an individual client, open some policies and then make some claims
        IndividualClient ic = new IndividualClient("Bob B. Pins");
        ic.openPolicyFor(100);
        ic.openPolicyFor(200, 0.10f);
        ic.openPolicyFor(300, new GregorianCalendar(2021, 3, 2, 23, 59).getTime());
        ic.openPolicyFor(400, new GregorianCalendar(2009, 5, 4, 12, 00).getTime());
        Policy p = new Policy(500);
        System.out.println("Here are the Individual Client's policies:");
        for (int i=0; i<ic.getNumPolicies(); i++)
            System.out.println("  " + ic.getPolicies()[i]);

        System.out.println("Making claims:");
        System.out.println(String.format("  Claim for policy 0001: $%6.2f",ic.makeClaim(1)));
        System.out.println(String.format("  Claim for policy 0002: $%6.2f",ic.makeClaim(2)));
        System.out.println(String.format("  Claim for policy 0003: $%6.2f",ic.makeClaim(3)));
        System.out.println(String.format("  Claim for policy 0004: $%6.2f",ic.makeClaim(4)));
        System.out.println(String.format("  Claim for policy 0005: $%6.2f",ic.makeClaim(5)));
        System.out.println("Here are the Individual Client's policies after claims:");
        for (int i=0; i<ic.getNumPolicies(); i++)
            System.out.println("  " + ic.getPolicies()[i]);
        System.out.println(String.format("The total policy coverage for this client: $%1.2f",ic.totalCoverage()));

        // Create a company client, open some policies and then make some claims
        CompanyClient cc = new CompanyClient("The Pillow Factory");
        cc.openPolicyFor(1000);
        cc.openPolicyFor(2000, 0.10f);
        cc.openPolicyFor(3000, new GregorianCalendar(2021, 3, 2, 23, 59).getTime());
        cc.openPolicyFor(4000, new GregorianCalendar(2009, 5, 4, 12, 00).getTime());
        System.out.println("\nHere are the Company Client's policies:");
        for (int i=0; i<cc.getNumPolicies(); i++)
            System.out.println("  " + cc.getPolicies()[i]);

        System.out.println("Making claims:");
        System.out.println(String.format("  Claim for policy 0006: $%7.2f",cc.makeClaim(6)));
        System.out.println(String.format("  Claim for policy 0007: $%7.2f",cc.makeClaim(7)));
        System.out.println(String.format("  Claim for policy 0008: $%7.2f",cc.makeClaim(8)));
        System.out.println(String.format("  Claim for policy 0009: $%7.2f",cc.makeClaim(9)));
        System.out.println(String.format("  Claim for policy 0005: $%7.2f",cc.makeClaim(5)));

        System.out.println("Here are the Company Client's policies after claims:");
        for (int i=0; i<cc.getNumPolicies(); i++)
            System.out.println("  " + cc.getPolicies()[i]);
        System.out.println(String.format("The total policy coverage for this client: $%1.2f",cc.totalCoverage()));
        System.out.println("Cancelling policy #12 ... did it work: " + cc.cancelPolicy(12));
        System.out.println("Cancelling policy #8 ... did it work: " + cc.cancelPolicy(8));
        System.out.println(String.format("The total policy coverage for this client: $%1.2f",cc.totalCoverage()));
    }
}