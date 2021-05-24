import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

public class TestBST extends BST{

    static int med_tree_size = 20;
    static int big_tree_size = 80;
    static String last = "";


    public static String[] alph = {"A","B","C","D","E","F","G","H","I","J",
                                   "K","L","M","N","O","P","Q","R","S","T",
                                   "U","V","W","X","Y","Z"};
    private static class NoRecursionException extends Exception{ public NoRecursionException(String s){super(s);}}
    static boolean verb = !true;
    static String check = "."; // "✓";


	public static void inorder(Node root, ArrayList<String> items){
		if(root == null){ return;}
		if(root.getLeft() != null){
			inorder(root.getLeft(), items);
		}
		items.add(root.getData());
		if(root.getRight() != null){
			inorder(root.getRight(), items);
		}
	}


    public TestBST(){super();}
    public TestBST(int size){
        super();
        String value = "";
        String val = "";
        int index = -1;
        size = size * 1000;
        Node prev = new Node("?");
        int count = 0;
        int pos = 0;
        for(String s1: alph){
            for(String s2:alph){
                for(String s3:alph){
                    for(String s4:alph){
                        for(String s5:alph){
                            Node n = new Node(s1+s2+s3+s4+s5, prev, null);
                            prev = n;
                            count += 1;
                            last = s1+s2+s3+s4+s5;
                            if(count >= size){
                                this.root = prev;
                                this.size = size + 1;
                                return;
                            }
                        }
                    }
                }
            }
        }
        /*
        for(int i=0; i<size; i+=1){
            index = (index + 1) % alph.length;

            value = value + alph[index];
            Node n = new Node(value);
            n.setLeft(next);
            next = n;
        }
        root = next;
        size = size + 1;
        */

    }
    public static boolean same(BinaryTree t1, BinaryTree t2){
        String s1 = PrintBinaryTree.toString(t1).strip();
        String s2 = PrintBinaryTree.toString(t2).strip();
        return s1.equals(s2);
    }
    public static boolean similar(BinaryTree t1, BinaryTree t2){
        ArrayList<String> l1 = new ArrayList<String>();
        ArrayList<String> l2 = new ArrayList<String>();
        inorder(t1.root, l1); Collections.sort(l1);
        inorder(t2.root, l2); Collections.sort(l2);
        return l1.equals(l2);
    }
    

    public static double testContains0(double outof){
        int grade = 0;
        int tests = 0;

        System.out.print("contains(size 00 tree) : ");
        for(String s : new String[]{"something", ""}){
            tests += 1;
            try{
                BST t = new TestBST();
                if( t.contains(s) == false ){
                    grade += 1; if(verb) System.out.print(check);
                }
            }catch(Exception e){ if(verb){ System.out.print("x"); } }
        }  System.out.println( " [" + grade + "/" + tests + " tests passed] [" + (1.0*grade/tests*outof) + "/" + outof + " marks]");
        return 1.0*grade/tests*outof;
    }
    public static double testContains1(double outof){
        int grade = 0;
        int tests = 0;

       System.out.print("contains(size 01 tree) : ");
        for(String s : new String[]{"a", "b"}){ tests += 1;
            try{
                BST t = new TestBST();
                t.add("a");
                if( t.contains(s) == ("a".equals(s)) ){
                    grade += 1; if(verb) System.out.print(check);
                }
            }catch(Exception e){ if(verb){ System.out.print("x"); } }
        }  System.out.println( " [" + grade + "/" + tests + " tests passed] [" + (1.0*grade/tests*outof) + "/" + outof + " marks]");
        return 1.0*grade/tests*outof;
    }
    public static double testContains2(double outof){
        int grade = 0;
        int tests = 0;


        System.out.print("contains(size 02 tree) : ");
        for(String s : new String[]{"a", "b", "c", "ab"}){ tests += 1;
            try{
                BST t = new TestBST();
                t.add(new String("a"));
                t.add("b");
                if( t.contains(s) == ("a".equals(s) || "b".equals(s) ) ){
                    grade += 1; if(verb) System.out.print(check);
                }else{
                    System.out.println("\n");
                    System.out.println("failed with " + s);
                }
            }catch(Exception e){ if(verb){ System.out.print("x"); } System.out.println("failed with " + s);
        System.out.println(e);}
        }  System.out.println( " [" + grade + "/" + tests + " tests passed] [" + (1.0*grade/tests*outof) + "/" + outof + " marks]");
        return 1.0*grade/tests*outof;
    }

    public static BST makeMediumBST(String base){
        Node aoh = makeSimpleBSTNodes("AO");
        Node ah = makeSimpleBSTNodes("A");
        Node bmh = makeSimpleBSTNodes("BM");
        Node bh = makeSimpleBSTNodes("B");
        Node tmp = ah;
        tmp = tmp.getRight();tmp = tmp.getRight();tmp = tmp.getRight();
        tmp.setRight(aoh);
        tmp = bh;
        tmp = tmp.getLeft();tmp = tmp.getLeft();tmp = tmp.getLeft();
        tmp.setLeft(ah);
        tmp = bh;
        tmp = tmp.getRight();tmp = tmp.getRight();tmp = tmp.getLeft();
        tmp.setRight(bmh);
        tmp = bh;
        tmp = tmp.getLeft();
        tmp.setRight(null);        
        
        BST t = new TestBST();
        t.root = bh;
        t.size = 57;
        return t; 
    }
    public static Node makeSimpleBSTNodes(String base){
        Node b = new Node(base+"B", new Node(base+"A"), new Node(base+"C"));
        Node f = new Node(base+"F", new Node(base+"E"), new Node(base+"G"));
        Node j = new Node(base+"J", new Node(base+"I"), new Node(base+"K"));
        Node n = new Node(base+"N", new Node(base+"M"), new Node(base+"O"));
        Node d = new Node(base+"D", b, f);
        Node l = new Node(base+"L", j, n);
        Node h = new Node(base+"H", d, l);
        return h;
    }
    public static BST makeSimpleBST(String base){
        BST t = new TestBST();
        /*
        Node b = new Node(base+"B", new Node(base+"A"), new Node(base+"C"));
        Node f = new Node(base+"F", new Node(base+"E"), new Node(base+"G"));
        Node j = new Node(base+"J", new Node(base+"I"), new Node(base+"K"));
        Node n = new Node(base+"N", new Node(base+"M"), new Node(base+"O"));
        Node d = new Node(base+"D", b, f);
        Node l = new Node(base+"L", j, n);
        Node h = new Node(base+"H", d, l);
        */
        t.root = makeSimpleBSTNodes(base);
        t.size = 15;
        return t; 
    } // {"H", "D", "L", "B", "A", "F", "C", "E", "J", "N", "M", "O", "K", "I", "G"}; 
    public static BST makeBST15(String base){
        BST t = new TestBST();

        Node b = new Node(base+"B", new Node(base+"A"), null);
        Node f = new Node(base+"F", new Node(base+"E"), new Node(base+"G"));
        Node j = null; //new Node(base+"J");
        Node n = new Node(base+"N", new Node(base+"M"), 
                          new Node(base+"P", new Node(base+"O"), new Node(base+"Q", null, new Node(base+"R", null, new Node(base+"S"))) ) ) ;
        Node d = new Node(base+"D", b, f);
        Node l = new Node(base+"L", j, n);
        Node h = new Node(base+"H", d, l);

        t.root = h;
        t.size = 15;
        return t; 
    }

    public static BST makeSimpleBSTAdd(String base){
        BST t = new TestBST();
        
        Node b = new Node(base+"B", new Node(base+"A"), new Node(base+"C", new Node(base+"BB"), null));
        Node f = new Node(base+"F", new Node(base+"E"), new Node(base+"G"));
        Node j = new Node(base+"J", new Node(base+"I"), new Node(base+"K"));
        Node n = new Node(base+"N", new Node(base+"M"), new Node(base+"O", null, new Node(base+"P")));
        Node d = new Node(base+"D", b, f);
        Node l = new Node(base+"L", j, n);
        Node h = new Node(base+"H", d, l);
        
        t.root = h;
        t.size = 17;
        return t; 
    }


    public static double testContainsNoRec(double outof){
        double grade = 0;
        int tests = 0;

        System.out.print("contains(no recursion) : ");
        tests += 1;
        BST t = null;
        try{
            t = new TestBST(20);
        }catch(Exception e){
            System.out.println("couldn't make the tree... try changinh the 80 to something smaller here");
            return 0;
        }

        try{
            t.contains("?A");
            grade += 1;
            if(verb){System.out.print(check);}
            System.out.println( " [Seems like you used iteration. Can proceed for marks now.]");
        }catch(StackOverflowError e){
            grade = -10;
            if(verb) {System.out.print("x");}
            System.out.println( " [Seems like you used recursion. All contains marks will be lost for this part.]");
        }catch(Exception e){
            {System.out.println(" [Something bad happened.");}
            grade= 0;
        }  
        return grade;
    }
    public static double testContainsLarger(double outof){
        int grade = 0;
        int tests = 0;
        int size = 128*16;
        //String[] inS = {"BH", "BI", "AN", "AOC", "BML", "BMG"};
        String[] inS = {"AA","AB","AC","AD","AE","AF","AG","AH","AI","AJ","AK","AL","AM","AN","AO",
          "AOA","AOB","AOC","AOD","AOE","AOF","AOG","AOH","AOI","AOJ","AOK","AOL","AOM","AON","AOO",
          "BA","BB","BC","BD","BH","BI","BJ","BK","BL","BM","BMA","BMB","BMC","BMD","BME","BMF","BMG",
          "BMH","BMI","BMJ","BMK","BML","BMM","BMN","BMO","BN","BO"};
        String[] outS = {"A", "X", "BE", "BF", "BG",  "BMP", "AQ", "AAX", "AOH?", "AOFF", 
            "AOII", "BIL", "AGE", "BNN", "BMLA", "C", "B", ""};
        System.out.print("contains(size 57 tree) : ");
        try{
            BinaryTree t = makeMediumBST("A");
            for(String s : inS){
                tests += 1;
                try{
                    if(t.contains(s)){
                        grade += 1; if(verb) {System.out.print(check);}
                        if(verb)System.out.print(s +",");
                    }else{System.out.print("[\""+s+"\" is in]");}
                }catch(Exception e){ if(verb){ System.out.print("x"); }  }
            }
            for(String s : outS){
                tests += 1;
                try{
                    if(!t.contains(s)){
                        grade += 1; if(verb){ System.out.print(check);}
                        if(verb)System.out.print(s +"_");
                    
                    }else{System.out.print("[\""+s+"\" is not in]");}
                }catch(Exception e){ if(verb){ System.out.print("x"); } }
            }

        }catch(Exception e){
            if(verb){ System.out.print("X"); }
        }  System.out.println( " [" + grade + "/" + tests + " tests passed] [" + (1.0*grade/tests*outof) + "/" + outof + " marks]");
        return 1.0*grade/tests*outof;
    }
    public static double testContainsBig(double outof){
        System.out.print("contains(size " + (big_tree_size*1000) + " tree) : ");
        int grade = 0;
        int tests = 0;
        int size = 128*16;
        String[] inS = {"AAAAA", "AAABA", "AAACB" };
        String[] outS = {"A", "AAAAAA", "AAAaA"};
        //System.out.print("contains(size 57 tree) : ");
        try{
            BinaryTree t = new TestBST(big_tree_size);
            for(String s : inS){
                tests += 1;
                try{
                    if(t.contains(s)){
                        grade += 1; if(verb) {System.out.print(check);}
                        if(verb)System.out.print(s +",");
                    }
                }catch(Exception e){ if(verb){ System.out.print("x"); } }
            }
            for(String s : outS){
                tests += 1;
                try{
                    if(!t.contains(s)){
                        grade += 1; if(verb){ System.out.print(check);}
                        if(verb)System.out.print(s +"_");
                    
                    }
                }catch(Exception e){ if(verb){ System.out.print("x"); } }
            }

        }catch(Exception e){
            if(verb){ System.out.print("X"); }
        }  System.out.println( " [" + grade + "/" + tests + " tests passed] [" + (1.0*grade/tests*outof) + "/" + outof + " marks]");
        return 1.0*grade/tests*outof;
    }

    public static double testAddSmall(double outof){
        int grade = 0;
        int tests = 0;

        try{ tests +=1 ;
            System.out.print("add(size 1) : ");
            BinaryTree t1 = new BST();
            t1.add("cat");
            BinaryTree t2 = new TestBST();
            t2.root = new Node("cat");
            t2.size = 1;
            if( PrintBinaryTree.toString(t1).equals(PrintBinaryTree.toString(t2))){
                grade += 1;
                System.out.print(" [pass]");
            }else{System.out.print(" [fail]");
                System.out.println("\nExcpected");
                PrintBinaryTree.print(t2);
                System.out.println("\nGot");
                PrintBinaryTree.print(t1);
            }
        }catch(Exception e){
            if(verb){ System.out.print("X"); }
        } System.out.println();

        try{ tests +=1 ;
            System.out.print("add(size 2) : ");
            BinaryTree t1 = new BST();
            t1.add("cat");t1.add("dog");
            BinaryTree t2 = new TestBST();
            t2.root = new Node("cat", null, new Node("dog"));
            t2.size = 2;
            if( PrintBinaryTree.toString(t1).strip().equals(PrintBinaryTree.toString(t2).strip())){
                grade += 1;System.out.print(" [pass]");
            }else{System.out.print(" [fail]");
                System.out.println("\nExcpected");
                PrintBinaryTree.print(t2);
                System.out.println("\nGot");
                PrintBinaryTree.print(t1);
            }
        }catch(Exception e){
            if(verb){ System.out.print("X"); }
        }  System.out.println();
        
        try{ tests +=1 ;
            System.out.print("add(size 2) : ");
            BinaryTree t1 = new BST();
            t1.add("dog");t1.add("cat");
            BinaryTree t2 = new TestBST();
            t2.root = new Node("dog", new Node("cat"), null);
            t2.size = 2;
            if( PrintBinaryTree.toString(t1).strip().equals(PrintBinaryTree.toString(t2).strip())){
                grade += 1;System.out.print(" [pass]");
            }else{System.out.print(" [fail]");
                System.out.println("\nExcpected");
                PrintBinaryTree.print(t2);
                System.out.println("\nGot");
                PrintBinaryTree.print(t1);
            }
        }catch(Exception e){
            if(verb){ System.out.print("X"); }
        }  System.out.println();
        
        try{ tests +=1 ;
            System.out.print("add(size 4) : ");
            BinaryTree t1 = new BST();
            t1.add("dog");t1.add("cat");t1.add("elk");t1.add("eel");
            BinaryTree t2 = new TestBST();
            t2.root = new Node("dog", new Node("cat"), new Node("elk", new Node("eel"), null));
            t2.size = 4;
            if( PrintBinaryTree.toString(t1).strip().equals(PrintBinaryTree.toString(t2).strip())){
                grade += 1;System.out.print(" [pass]");
            }else{System.out.print(" [fail]");
                System.out.println("\nExcpected");
                PrintBinaryTree.print(t2);
                System.out.println("\nGot");
                PrintBinaryTree.print(t1);
            }
        }catch(Exception e){
            if(verb){ System.out.print("X"); }
        }  System.out.println();

        try{ tests +=1 ;
            System.out.print("add(size 5) : ");
            BinaryTree t1 = new BST();
            t1.add("cat");t1.add("dog");t1.add("eel");t1.add("elk");t1.add("pig");
            BinaryTree t2 = new TestBST();
            t2.root = new Node("cat", null, new Node("dog", null, new Node("eel", null, new Node("elk", null, new Node("pig")))));
            t2.size = 4;
            if( PrintBinaryTree.toString(t1).strip().equals(PrintBinaryTree.toString(t2).strip())){
                grade += 1;System.out.print(" [pass]");
            }else{System.out.print(" [fail]");
                System.out.println("\nExcpected");
                PrintBinaryTree.print(t2);
                System.out.println("\nGot");
                PrintBinaryTree.print(t1);
            }
        }catch(Exception e){
            if(verb){ System.out.print("X"); }
        }  System.out.println();
        
        
        System.out.println( "[" + grade + "/" + tests + " tests passed] [" + (1.0*grade/tests*outof) + "/" + outof + " marks]");
        return 1.0*grade/tests*outof;



    }


    public static double testAddMed(double outof){
        int grade = 0;
        int tests = 0;

      
        try{ tests +=1 ;
            System.out.print("add(size 17) : ");
            BinaryTree t1 = makeSimpleBST("x");
            t1.add("xBB");t1.add("xP");
            BinaryTree t2 = makeSimpleBSTAdd("x");
            if( same(t1,t2) ){
                grade += 1;System.out.print(" [pass]");
            }else{System.out.print(" [fail]");
                System.out.println("\nExcpected");
                PrintBinaryTree.print(t2);
                System.out.println("\nGot");
                PrintBinaryTree.print(t1);
            }
        }catch(Exception e){
            if(verb){ System.out.print("X"); }
        }  System.out.println();
        

        try{ tests +=1 ;
            System.out.print("add(size 15) : ");
            BinaryTree t1 = new TestBST();
            BinaryTree t2 = makeSimpleBST("");
            for(String s: new String[]{"H", "D", "L", "B", "A", "F", "C", "E", "J", "N", "M", "O", "K", "I", "G"} ){
                t1.add(s);
            }
            if( same(t1,t2) ){
                grade += 1;System.out.print(" [pass]");
            }else{System.out.print(" [fail]");
                System.out.println("\nExcpected");
                PrintBinaryTree.print(t2);
                System.out.println("\nGot");
                PrintBinaryTree.print(t1);
            }
        }catch(Exception e){
            if(verb){ System.out.print("X"); }
        }  System.out.println();
        


        System.out.println( "[" + grade + "/" + tests + " tests passed] [" + (1.0*grade/tests*outof) + "/" + outof + " marks]");
        return 1.0*grade/tests*outof;



    }





    public static double testMakeBalancedSmall(double outof){
        double grade = 0;
        int tests = 0;
        int num = 10;
        System.out.print("makeBalanced(height 2 -> 1) : ");
        int g = 0; tests += 1;
        for(int i=0; i<num; i+=1){
            try{ //tests +=1 ;
                BST t = new TestBST();
                t.root = new Node("cat", null, new Node("rat", new Node("eel"), null));
                t.size = 3;
                BST t2 = new TestBST();
                t2.root = new Node("cat", null, new Node("rat", new Node("eel"), null));
                t2.size = 3;
                BinaryTree b = t.makeBalanced();
                //System.out.println("h(t)=" + t.height());
                //System.out.println("h(b)="+b.height());
                //System.out.println(b);
                //if( !b.isBST()){
                if( !validBST(b) ){             
                    System.out.print(" [fail: result is not a valid bst]");
                    System.out.println("\nOriginal Tree\n"+t2);
                    System.out.println("Output Tree\n"+b);
                    break;
                }else if( !similar(b,t2)){
                    System.out.print(" [fail: result has different values then original]");
                    System.out.println("\nOriginal Tree\n"+t2);
                    System.out.println("Output Tree\n"+b);
                }else{
                    if( b.height() == 1){
                        g += 1;System.out.print(".");
                    }else{
                        System.out.print(" [fail : height is not minimal]");
                        System.out.println("\nOriginal Tree\n"+t2);
                        System.out.println("Output Tree\n"+b);
                        break;
                    }
                }
            }catch(Exception e){
                if(verb){ System.out.print("X"); }
            }  //System.out.println();
        }  
        if(g == num){ 
            grade += 1; System.out.print("[pass]");
        }System.out.println();
      
        System.out.print("makeBalanced(height 5 -> 2) : ");
        try{ tests +=1 ;
            BST t = new TestBST();
            t.root = new Node("fox",new Node("eel",new Node("dog",new Node("cat",new Node("bat", new Node("ape"),null), null),null),null),new Node("rat"));
            t.size = 7;
            BST t2 = new TestBST();
            t2.root = new Node("fox",new Node("eel",new Node("dog",new Node("cat",new Node("bat", new Node("ape"),null), null),null),null),new Node("rat"));
            t2.size = 7;
            BinaryTree b = t.makeBalanced();
            //System.out.println("h(t)=" + t.height());
            //System.out.println("h(b)="+b.height());
            if( !validBST(b)){
                System.out.print(" [fail: result is not a valid bst]");
                System.out.println("\nOriginal Tree\n"+t2);
                System.out.println("Output Tree\n"+b);
            }else if( !similar(b,t2)){
                System.out.print(" [fail: result has different values then original]");
                System.out.println("\nOriginal Tree\n"+t2);
                System.out.println("Output Tree\n"+b);
            }else{
                if( b.height() == 2 ){
                    grade += 1;System.out.print(" [pass]");
                }else{
                    System.out.print(" [fail : height is not minimal]");
                    System.out.println("\nOriginal Tree\n"+t2);
                    System.out.println("Output Tree\n"+b);
                }
            }
        }catch(Exception e){
            if(verb){ System.out.print("X"); }
        }  System.out.println();


        System.out.print("makeBalanced(height 6 -> 3) : ");
        try{ tests +=2 ;
            BST t = makeBST15("#");
            BST t2 = makeBST15("#");
            BinaryTree b = t.makeBalanced();
            System.out.print(" height(original)=" + t2.height());
            System.out.print(" height(output)="+b.height());
            if( !validBST(b)){
                System.out.print(" [fail: result is not a valid bst]");
                if(verb)System.out.println("\nOriginal Tree\n"+t2);
                if(verb)System.out.println("Output Tree\n"+b);
            }else if( !similar(b,t2)){
                System.out.print(" [fail: result has different values then original]");
                if(verb)System.out.println("\nOriginal Tree\n"+t2);
                if(verb)System.out.println("Output Tree\n"+b);
            }else{
                if( b.height() == 3 ){
                    grade += 2;System.out.print(" [pass]");
                }else{
                    System.out.print(" [fail : height is not minimal]");
                    if(verb)System.out.println("\nOriginal Tree\n"+t2);
                    if(verb)System.out.println("Output Tree\n"+b);
                }
            }
        }catch(Exception e){
            if(verb){ System.out.print("X"); }
        }  System.out.println();

      

        System.out.print("makeBalanced(height 11 -> 5) : ");
        try{ tests +=3 ;
            BST t = makeMediumBST("A");
            BST t2 = makeMediumBST("A");
            BinaryTree b = t.makeBalanced();
            System.out.print(" height(original)=" + t2.height());
            System.out.print(" height(output)="+b.height());
            if( !validBST(b)){
                System.out.print(" [fail: result is not a valid bst]");
                if(verb)System.out.println("\nOriginal Tree\n"+t2);
                if(verb)System.out.println("Output Tree\n"+b);
            }else if( !similar(b,t2)){
                System.out.print(" [fail: result has different values then original]");
                if(verb)System.out.println("\nOriginal Tree\n"+t2);
                if(verb)System.out.println("Output Tree\n"+b);
            }else{
                if( b.height() == 5 ){
                    grade += 3;System.out.print(" [pass]");
                }else{
                    System.out.print(" [fail : height is not minimal]");
                    if(verb)System.out.println("\nOriginal Tree\n"+t2);
                    if(verb)System.out.println("Output Tree\n"+b);
                }
            }
        }catch(Exception e){
            if(verb){ System.out.print("X"); }
        }  System.out.println();
  

        
        System.out.println( "[" + grade + "/" + tests + " tests passed] [" + (1.0*grade/tests*outof) + "/" + outof + " marks]");
        return 1.0*grade/tests*outof;



    }

    
    public static double testSave(double outof){
        double grade = 0;
        int tests = 0;
        Random rnd = new Random();
        int num = 0;
        try{ tests +=1 ;
            System.out.print("saveToFile(tiny) : ");
            BST t = new TestBST();
            t.root = new Node("cat", null, new Node("rat", new Node("eel"), null));
            t.size = 3;
            //int num = rnd.nextInt(99999);
            String fname = "save-" + num + ".bt";
            t.saveToFile(fname);
            BST b = new TestBST();
            b.loadFromFile(fname);
            
            if( same(t,b) ){
                grade +=1 ;System.out.print(" [pass]");
            }else{
                System.out.print(" [fail]");
                System.out.println("\nTree to be saved:\n"+t);
                System.out.println("Loaded tree:\n"+b);
            }
        }catch(Exception e){
            System.out.println("Something went wrong...");
            System.out.println(e);
            if(verb){ System.out.print("X"); }
        }  System.out.println();


        try{ tests +=2 ;
            System.out.print("saveToFile(small) : ");
            BST t = makeSimpleBST(alph[rnd.nextInt(26)%alph.length]);
            //int num = rnd.nextInt(99999);
            String fname = "save-" + (num+1) + ".bt";
            t.saveToFile(fname);
            BST b = new TestBST();
            b.loadFromFile(fname);
            
            if( same(t,b) ){
                grade +=2 ;System.out.print(" [pass]");
            }else{
                System.out.print(" [fail]");
                System.out.println("\nTree to be saved:\n"+t);
                System.out.println("Loaded tree:\n"+b);
            }
        }catch(Exception e){
            System.out.println("Something went wrong...");
            System.out.println(e);
            if(verb){ System.out.print("X"); }
        }  System.out.println();

        try{ tests +=3 ;
            System.out.print("saveToFile(larger) : ");
            BST t = makeMediumBST(alph[rnd.nextInt(26)%alph.length]);
            //int num = rnd.nextInt(99999);
            String fname = "save-" + (num+2) + ".bt";
            t.saveToFile(fname);
            BST b = new TestBST();
            b.loadFromFile(fname);
            
            if( same(t,b) ){
                grade +=3 ;System.out.print(" [pass]");
            }else{
                System.out.print(" [fail]");
                System.out.println("\nTree to be saved:\n"+t);
                System.out.println("Loaded tree:\n"+b);
            }
        }catch(Exception e){
            System.out.println("Something went wrong...");
            System.out.println(e);
            if(verb){ System.out.print("X"); }
        }  System.out.println();


        System.out.println( "[" + grade + "/" + tests + " tests passed] [" + (1.0*grade/tests*outof) + "/" + outof + " marks]");
        return 1.0*grade/tests*outof;



    }

 
    public static boolean validBST(BinaryTree t){
        ArrayList<String> vals1 = new ArrayList<String>();
        ArrayList<String> vals2 = new ArrayList<String>();
        
        inorder(t.root, vals1);
        inorder(t.root, vals2);

        Collections.sort(vals1);
        return vals1.equals(vals2);
    }


    public static void main(String[] args){
        int size = 10; try{size = Integer.parseInt(args[0]);}catch(Exception e){}
        double grade = 0;
        System.out.println("==================================");
        double ok_recursion = testContainsNoRec(1);
        grade += testContains0(0.5);
        grade += testContains1(1);
        grade += testContains2(2);
        grade += testContainsLarger(5);
        grade += testContainsBig(1.5);
        System.out.println("---------------------------------");
        if( ok_recursion < 0 ){
            System.out.println("BinaryTree.contains() --> 0/10   [This prolbem must NOT use recursion]");
        }else{
            System.out.println("BinaryTree.contains() --> " + grade + "/10");
        }


        System.out.println();
        double grade2 = 0;
        System.out.println("==================================");
        grade2 += testAddSmall(5);
        grade2 += testAddMed(5);
        System.out.println("---------------------------------");
        System.out.println("BinaryTree.add() --> " + grade2 + "/10");
        

        System.out.println();
        double grade3 = 0;
        System.out.println("==================================");
        grade3 += testMakeBalancedSmall(10);
        System.out.println("---------------------------------");
        System.out.println("BinaryTree.makeBalanced() --> " + grade3 + "/10");


        System.out.println();
        double grade4 = 0;
        System.out.println("==================================");
        grade4 += testSave(10);
        System.out.println("---------------------------------");
        System.out.println("BinaryTree.saveToFile() --> " + grade4 + "/10");


        System.err.println("\n\n=======================================");
        System.err.println(    "==  Summary of TestBST (BST Tester)  ==");
        System.err.println(    "=======================================");
        grade = Math.round(grade*100.0)/100.0;
        grade2 = Math.round(grade2*100.0)/100.0;
        grade3 = Math.round(grade3*100.0)/100.0;
        grade4 = Math.round(grade4*100.0)/100.0;
        
        if( ok_recursion < 0 ){
            System.err.println("BST.contains()     --> 0.0/10   [This prolbem must NOT use recursion]");
        }else{
            System.err.println("BST.contains()     --> " + grade + "/10");
        }
            System.err.println("BST.add()          --> " + grade2 + "/10");
            System.err.println("BST.makeBalanced() --> " + grade3 + "/10");
            System.err.println("BST.saveToFile()   --> " + grade4 + "/10");
            System.err.println("======================================");
  
        
        //System.out.println( makeSimpleBST("#") );

    }



}
