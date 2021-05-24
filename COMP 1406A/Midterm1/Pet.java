public class Pet {
    private String name;
    private final int birth_year;
    private String type_of_pet; // such as "cat" "dog" "eel"
    private Pet[] list_of_children;

    public Pet(String name, int birth_year, String type){
        this.name = name;
        this.birth_year = birth_year;
        this.type_of_pet = type;
    }

    public Pet(){
        this.name = "";
        this.birth_year = 0;
        this.type_of_pet = "";
    }

    public String getName(){
        return name;
    }

    public int getbirth_year(){
        return this.birth_year;
    }

    public String gettype_of_pet(){
        return this.type_of_pet;
    }

    public Pet[] getlist_of_children(){
        return this.list_of_children;
    }

    public void setlist_of_children(Pet[] children){
        list_of_children =  new Pet[children.length];
        for(int i = 0; i<children.length;i++){
            list_of_children[i] = children[i];
        }
    }

    public int getnumber_of_children(){
        int number_of_children = 0;
        for(int i = 0;i<list_of_children.length;i++){
            if(list_of_children[i] != null){
                number_of_children++;
            }
        }
        return number_of_children;
    }
}
