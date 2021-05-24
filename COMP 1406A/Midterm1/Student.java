public class Student {
    String name;
    int id_number;
    Double[] grades;

    public Student(String name, int id_number, Double[] grades){
        this.name = name;
        this.id_number = id_number;
        this.grades = grades;
    }

    public String toString(){
        return "This is " + name + " with Id number: " + id_number;
    }

    public Double getAverage(){
        double total = 0.0;
        int num_of_grades = 0;
        if(grades.length<1){
            return -1.0;
        } else{
            for(int i = 0; i<grades.length;i++){
                total = total + grades[i];
                num_of_grades++;
            }
            return total/num_of_grades;
        }

    }
    public static void main(String[] args){
        Double[] grades = {56.8,97.0};
        Student matei = new Student("Matei", 16 , grades);
        System.out.println(matei.toString());
        System.out.println(matei.getAverage());
    }
}
