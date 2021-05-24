import java.io.File;   
import java.util.Scanner; 


public class BinaryTree {
	protected Node root = null;
    protected int  size = 0;
    public boolean found = false;

	public BinaryTree(){
		size = 0;
	}

  public BinaryTree(String s){
		root = new Node(s);
		size = 1;
	}

	public int getSize(){ return this.size; }
	public Node getRoot(){ return this.root; }


	public boolean contains(String target){
		found = false;
		if( root == null ){ 
            return false; 
        }
        search(root,target);
		return found;
	}


    private void search(Node node, String target){
        if(node == null){
            return;
        }
        if(node.getData().equals(target)){
			found = true;
		}
        search(node.left,target);

        search(node.right,target);
    }


	public void loadFromFile(String fname){
		BinaryTree bt = new BinaryTree();
		try{
			Scanner file = new Scanner( new File(fname) );
			while( file.hasNextLine()){
				bt.add(file.nextLine().strip());
			}
		}catch(Exception e){
			System.out.println("Something went wrong!!");
		}
		this.root = bt.root;
		this.size = bt.size;
	}

	public void add(String s){
		addRandom(s);
	}

	
	/* add a node in a random place in the tree. */
	private void addRandom(String s){
		if(root == null && size == 0){
			root = new Node(s);
		}else{
		  Node tmp = root;
		  boolean left = Math.random() < 0.5; 
		  Node child = left ? tmp.getLeft() : tmp.getRight();
		  while(child != null){
			tmp = child;
			left = Math.random() < 0.5;
			child = left ? tmp.getLeft() : tmp.getRight();
		  }
		  // assert: child == null
		  // yea! we have a place to add s
		  if(left){
		  	tmp.setLeft(new Node(s));
		  }else{
			  tmp.setRight(new Node(s));
		  }
		}
		size += 1;
	}

	public boolean isBST(){
	if(recursion_BST(root,'a','z') == false){
		return false;
		}
		return true;
	}
//root,root.data.charAt(0),root.data.charAt(0)

	private boolean recursion_BST(Node node, char min, char max){
		if(node == null){
			return true;
		}
		if(node.left != null && node.data.compareTo(node.left.data) < 0 ){
			return false;
		}
		if(node.data.toLowerCase().charAt(0) < min){
			return false;
		}
		if(node.right != null && node.data.compareTo(node.right.data) > 0){
			return false;
		}
		if(node.data.charAt(0) > max){
			return false;
		}
		return recursion_BST(node.left, min, node.data.charAt(0)) && recursion_BST(node.right, node.data.charAt(0), max);
		/*
		char fill = min.charAt(0);
		fill--;
		min = Character.toString(fill);
		char fill2 = max.charAt(0);
		fill2++;
		max = Character.toString(fill2);
		*/


		/*
		if(root == null){
			return true;
		}
		if(l != null && root.data.charAt(0) <= l.data.charAt(0)){
			return false;
		}

		if(r != null && root.data.charAt(0) >= r.data.charAt(0)){
			return false;
		}

		return recursion_BST(node.left, l, node) && 
		recursion_BST(node.right, node, r);
		
		if(root.left != null && root.data.compareTo(root.left.data) < 0){
			return false;
		}
		if(root.right != null && root.data.compareTo(root.right.data) > 0){
			return false;
		}
		return recursion_BST(root.left) && recursion_BST(root.right);
		*/
	}




	/** Computes the height of the binary tree
	  *
		* The height is the length of the longest path from
		* the root of the tree to any other node.
		*
		* @return the height of the tree
		*/
	public final int height(){
	  if( root == null ){ return -1; }
	  if( size == 1){ return 0; }
	  return heightRecursive(root);
	}
	protected final static int heightRecursive(Node root){
		if( root == null ){
			return -1;
		}
		int leftHeight = heightRecursive(root.getLeft());
		int rightHeight = heightRecursive(root.getRight());
		if( leftHeight < rightHeight){
			return 1 + rightHeight;
		}else{
			return 1 + leftHeight;
		}
	}


	public static void main(String[] args){
		/*
		BinaryTree t = new BinaryTree("cat");
		System.out.println("height = " + t.height() + ",  size = " + t.getSize());
		t.add("dog");
		t.add("eel");
		t.add("cow");
		t.add("rat");
		System.out.println("height = " + t.height() + ",  size = " + t.getSize());
		System.out.println(t);

		System.out.println("height = " + t.height() + ",  size = " + t.getSize());
		t.loadFromFile("sample.txt");
		System.out.println(t);
		*/

		/*
		BinaryTree test = new BinaryTree("cat");
		System.out.println(test.root);
		test.add("dog");
		test.add("eel");
		test.add("monkey");
		test.add("8");
		test.add("panda");
        System.out.println(test.contains("monkey"));
		System.out.println( " ");
		System.out.println(test.isBST());
		*/
			System.out.println(" TESTER 1 ");
			BinaryTree t = new BinaryTree("octopus");
			System.out.println("height = " + t.height() + ",  size = " + t.getSize());
			t.add("dog");
			t.add("eel");
			t.add("pose");
			t.add("zebra");
			t.add("ant");
			t.add("elephant");
			System.out.println(t);
			System.out.println("height = " + t.height() + ",  size = " + t.getSize());
			System.out.println("\nCONTAINS TEST: "+t.contains("eel")+"\n");
			System.out.println("IS BST TEST: "+t.isBST()+"\n");
			System.out.println(" TESTER 2: LOAD FILE \n");
			t.loadFromFile("slama.txt");
			System.out.println("height = " + t.height() + ",  size = " + t.getSize());
			System.out.println(t);
			System.out.println("CONTAINS TEST [T2]: "+t.contains("cat")+"\n");
			System.out.println("IS BST TEST [T2]: "+t.isBST()+"\n");
		
	}
	


	@Override
	public String toString() {
		return PrintBinaryTree.toString(this);
	}
}
