public class Node{
    protected String data;
    protected Node   left;
    protected Node   right;
  
    public Node(String data){
      this(data, null, null);
    }
  
    public Node(String data, Node left, Node right){
      this.data = data;
      this.left = left;
      this.right = right;
    }
  
    public String getData(){return this.data;}
    public Node   getLeft(){ return this.left;}
    public Node   getRight(){ return this.right;}
  
    public void setData(String s){ this.data = s;}
    public void setLeft(Node left){ this.left = left;}
    public void setRight(Node right){ this.right = right;}
    public void setLeftRight(Node left, Node right){
      this.left = left;
      this.right = right;
    }
    public void setAll(String data, Node left, Node right){
      this.data = data;
      this.left = left;
      this.right = right;
    }
  
  
    
  
  }
