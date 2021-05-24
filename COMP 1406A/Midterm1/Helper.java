public class Helper {
    public static void smooth(double[] input){
        int location = 0;
        double total = 0.0;
        double avg = 0.0;
        for(int i = 0; i<input.length;i++){
                total = total + input[i];
                location++;
           if(location == 2){
            avg = total/2;
            input[i] = avg;
            input[i-1] = avg;
            location = 0;
            total = 0.0;
            }
        }
    }
    public static void main(String[] args){
        double[] grades = {1.0,3.0,2.5,3.5};
        smooth(grades);
        for(int i = 0;i<grades.length;i++){
            System.out.println(grades[i]);
        }

    }
}
