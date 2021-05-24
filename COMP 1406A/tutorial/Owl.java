public class Owl extends Animal{
    boolean wise;
    public Owl( String name, int birthYear,Boolean wise){
        super(name,birthYear);
        this.wise = wise;
    }
    public Owl(){
        super("owl", 2000);
        int tmp = (int) ( Math.random() * 2 + 1); // will return either 1 or 2
        if(tmp == 1){
            wise = true;
        }else{
            wise = false;
        }
    }
    public String noise(){
        int tmp = (int) ( Math.random() * 2 + 1); // will return either 1 or 2
        if(tmp == 1){
            return "hoot";
        }else{
            return "hooooot";
        }
    }
/*
    public String toString(){
        return "this is owl:" + name + "which is born in" + birthYear;
    }
    */
}
