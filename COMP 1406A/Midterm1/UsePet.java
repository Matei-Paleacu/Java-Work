import java.util.*;
public class UsePet {


    public Boolean find_child(Pet pet, String name){
        Pet[] children = pet.getlist_of_children();
        for(int i = 0; i<children.length;i++){
            System.out.print(children[i].getName()+"\n");
            System.out.println(name + " name");
            if(children[i].getName().equals(name)){
                System.out.println("in");
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args){
    UsePet fun_pet = new UsePet();
    Pet pet1 = new Pet("Fluffy",2012,"cat");
    Pet pet2 = new Pet("Igor",2013,"cat");
    Pet pet3 = new Pet("Wei",2014,"owl");
    Pet[] children = {pet2,pet3};
    pet1.setlist_of_children(children);
    Scanner sc = new Scanner(System.in); //System.in is a standard input stream.
    System.out.print("Enter a name for the pet");
    String a = sc.nextLine();
    sc.close();
    Pet[] out = pet1.getlist_of_children();
    for(int i =0; i<out.length;i++){
        System.out.println(out[i].getName());
    }
    boolean outp = fun_pet.find_child(pet1, a);
    if(outp == true){
        System.out.println("yes," + pet1.getName() + " has a child named " + a);
    } else{
        System.out.println("no," + pet1.getName() + " does not have a child named " + a);
    }
}
}
