import java.util.Stack;
import java.io.File;
import java.io.FileWriter;   
import java.io.IOException;
import java.util.Scanner;
import java.util.*;
import java.io.BufferedWriter;
public class BST extends BinaryTree{
  public String[] values;
  public int size = 0;
  public ArrayList<String> print_list=new ArrayList<String>();
  public ArrayList<String> new_tree=new ArrayList<String>();
  public int print_size = 0;
  public int k = 0;
  public int k2 = 0;

	// You MUST have a zero argument constructor that
	// creates an empty binary search tree
	// You can can add code to this if you want (or leave it alone).
  // We will create all BSTs for testing using this constructor 
  public BST(){}



  @Override
  public boolean contains(String s){
      int compareValue  = 0;
      Node current = root;
      Stack<Node> node_stack = new Stack<Node>();
      while(current != null || node_stack.size() > 0){                      //while loops till the current node is null or the the stack is empty and each node has been visited
          while(current != null){                                           // while loops till the end of far left of the tree is reached the goes backwards in the stack checking the right side of each node
              compareValue = current.data.compareTo(s);
              if(compareValue == 0){                                        //comapreTo returns 0 if both string are the same
                  return true;
              }
              node_stack.push(current);
              current = current.left;
          }

          current = node_stack.pop();                                       //goes backwards throught the stack to check the right side now of binary tree (line 27 and 28)
          current = current.right;
      }
    return false;
  }


  @Override
  public void add(String s){
      if(contains(s) != true){                                              //New node with string s will be added to the binary tree as long as the string does not already exist in the tree
        if(root == null){
          root = new Node(s);
        }else{
          recursive_add(root, s);
        }
     }
  }

  private void recursive_add(Node pos, String s){
    if(s.compareTo(pos.data) < 0){
      if(pos.getLeft() == null){
        pos.setLeft(new Node(s));
      }else{
        pos = pos.getLeft();
        recursive_add(pos, s);
      }
    }
    if(s.compareTo(pos.data) > 0 ){
      if(pos.getRight() == null){
        pos.setRight(new Node(s));
      }else{
        pos = pos.getRight();
        recursive_add(pos, s);
      }
    }
  }



  public BST makeBalanced(){
    BST smaller = new BST();
    if(root != null){
      recursive_setData(root);
      smaller.root = build_smaller_tree(0, new_tree.size()-1);
      smaller.isBST();
      return smaller;
    }
    return smaller;
  }

  private Node build_smaller_tree(int lower, int upper){
    if(lower == upper){
      return new Node(new_tree.get(lower));
    }
    int middle = lower +(upper - lower)/2;
    Node root_node = new Node(new_tree.get(middle));
    if(middle - 1 >= lower){
      root_node.setLeft(build_smaller_tree(lower, middle-1));
    }
    if(middle + 1 <= upper){
      root_node.setRight(build_smaller_tree(middle + 1, upper));
    }
    return root_node;
  }

  private void recursive_setData(Node node){
    if(node == null){
      return;
    }
    recursive_setData(node.left);
    new_tree.add(node.data);
    recursive_setData(node.right);
  }



  public boolean saveToFile(String fname){
    print_setData(root);
    BufferedWriter bw = null;
    try{
      File file = new File(fname);
      FileWriter fw = new FileWriter(file);
      bw = new BufferedWriter(fw);
      for(String num : print_list){
        bw.write(num);
        bw.newLine();
      }
      bw.close();
      return true;
      } catch (IOException ioe){
        ioe.printStackTrace();
        return false;
      }
    }

  private void print_setData(Node node){
    if(node == null){
      return;
    }
    print_list.add(node.data);
    print_setData(node.left);
    print_setData(node.right);
  }

  /*
  private void printData(Node node){
    if(node == null){
      return;
    }
    if(node.left != null){
      print_list.add(node.left.data);
    }
    if(node.right != null){
      print_list.add(node.right.data);
    }
    printData(node.left);
    printData(node.right);
  }
*/

public void loadFromFile(String fname){
  BinaryTree bst = new BST();
  try{
    Scanner file = new Scanner( new File(fname) );
    while( file.hasNextLine() ){
      bst.add(file.nextLine().strip());
    }
  }catch(Exception e){
    System.out.println("Something went wrong!!");
  }
  this.root = bst.root;
  this.size = bst.size;
}

}
