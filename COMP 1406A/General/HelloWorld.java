import java.util.Date;
class HelloWorld{
    public static void main(String[] args) {
        System.out.println("Hello, World!"); // prints hello world
        System.out.println("matei is cool");
        int[] numbers = new int[3];
        numbers[0] = 7;
        numbers[1] = 18;
        numbers[2] = 24;
        int i;
        for (i = 0; i < numbers.length; i++){
            System.out.println(numbers[i]);
        }
        Date dateIssued = new Date();
        System.out.println(dateIssued);
    }
}