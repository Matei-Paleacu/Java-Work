package MidtermPrac;

public class PersonSample extends Person implements Comparable<PersonSample>{

    public PersonSample(String name, int age, String birthCity){
        super(name,age,birthCity);
    }

    public int compareTo(PersonSample one){
        if(this.age < one.age){
            return -1;
        }
        if(this.age > one.age){
            return 1;
        }else{
            if(this.name.length() < one.name.length()){
                return -1;
            }
            if(this.name.length() > one.name.length()){
                return 1;
            }else{
                return 0;
            }
        }
    }

    public static void main(String[] args){
        PersonSample g = new PersonSample("Matei", 28, "Ottawa");
        PersonSample c = new PersonSample("Lucas", 28, "Carleton");
        System.out.println(g.compareTo(c));
    }
}
