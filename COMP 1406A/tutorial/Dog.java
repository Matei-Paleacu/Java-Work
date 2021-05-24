public class Dog extends Animal{
    public Dog( String name, int birthYear){
        super(name,birthYear);
    }
    public Dog(){
        super("dog", 2000);
    }
    public String noise(){
        int tmp = (int) ( Math.random() * 2 + 1); // will return either 1 or 2
        if(tmp == 1){
            return "grrrr";
        }else{
            return "woof";
        }
    }
}
