import java.util.Date;
import java.util.GregorianCalendar;


public class PolicyTester {
    public static void main(String args[]) {
        System.out.println(new Policy(320));
        DepreciatingPolicy p1 = new DepreciatingPolicy(500.1f, 0.1f);
        System.out.println(p1);
        p1.depreciate();
        System.out.println(p1);
        System.out.println(new ExpiringPolicy(1000));
        Date expDate = new GregorianCalendar(2021, 3, 2, 23, 59).getTime();
        ExpiringPolicy p2 = new ExpiringPolicy(2000, expDate);
        System.out.println(p2);
        System.out.println(p2.isExpired());
        expDate = new GregorianCalendar(2013, 3, 1, 23, 59).getTime();
        ExpiringPolicy p3 = new ExpiringPolicy(2000, expDate);
        System.out.println(p3);
        System.out.println(p3.isExpired());
    }
}
