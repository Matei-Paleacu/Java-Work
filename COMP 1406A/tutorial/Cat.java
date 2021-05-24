public class Cat extends Animal{
    public Cat( String name, int birthYear){
        super(name,birthYear);
    }
    public Cat(){
        super("cat", 2000);
    }
    public String noise(){
        int tmp = (int) ( Math.random() * 2 + 1); // will return either 1 or 2
        if(tmp == 1){
            return "prrr";
        }else{
            return "meow";
        }
    }
}
