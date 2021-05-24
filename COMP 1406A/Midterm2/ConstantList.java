public class ConstantList {
    private final int[] my_ints;

    public ConstantList(int[] input){
        my_ints = input;
    }

    public int getEle(int pos){
        return my_ints[pos];
    }

    public int[] getList(){
        return my_ints;
    }
}
