/*

Code adapted from a stackoveerflow answer by Todd Davies
https://stackoverflow.com/a/27153988


Note: This works fine in VS Code on my Windows 10 machine displaying "└── " or "┌── " well.
      When I run the same code in cmd or powershell, they do not display nicely. 

      If you are running in Windows and using cmd/powershell, you can change the alt_display value
      to change the appearance

*/

public class PrintBinaryTree{
    
    public static boolean alt_display = !false;

    public static String toString(BinaryTree bt){
        return toString(bt.getRoot(), new StringBuilder(), true, new StringBuilder()).toString();
    }

    public static void print(BinaryTree bt){
        System.out.println( toString(bt) );
    }

    public static StringBuilder toString(Node root, StringBuilder prefix, boolean isTail, StringBuilder sb) {
        if(root == null){return sb;}
        if(root.getRight() != null) {
            toString(root.getRight(), new StringBuilder().append(prefix).append(isTail ? "|   " : "    "), false, sb);
        }
        if(alt_display){
            sb.append(prefix).append(isTail ? "\\-- " : "/-- ").append(root.getData().toString()).append("\n");
        }else{
            sb.append(prefix).append(isTail ? "└── " : "┌── ").append(root.getData().toString()).append("\n");
        }
        if(root.getLeft() != null) {
            toString(root.getLeft(), new StringBuilder().append(prefix).append(isTail ? "    " : "|   "), true, sb);
        }
        return sb;
    }
        

}
