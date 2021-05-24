import java.util.Random;
import java.util.ArrayList;

public class TestBT extends BinaryTree{

    private static class NoRecursionException extends Exception{ public NoRecursionException(String s){super(s);}}

    static boolean verb = !true;
    static String check = "."; // "✓";
    
    public TestBT(){}
    public TestBT(int size){
        super();
        size = size * 1000;
        Node next = new Node("end");
        for(int i=0; i<size; i+=1){
            Node n = new Node("n" + i);
            if(Math.random() < 0.5){
                n.setRight(next);
            }else{
                n.setLeft(next);
            }
            next = n;
        }
        root = next;
        size = size + 1;
    }

    public static double testContainsBig(double outof){
        int grade = 0;
        int tests = 0;

        System.out.print("contains( big tree  ) : ");
        tests += 1;
        try{
            BinaryTree t = new BinaryTree();
            try{
                for(int i=1; i<=80*1000; i+=1){ t.add("n"+i);}
                System.out.print(" [tree size " + t.size + "]");
            }catch(Exception e){
                System.out.print(" [could not build tree]");
                throw new Exception("tree build fail");
            }    
            Random rnd = new Random();
            if(t.contains("n" + (rnd.nextInt(79*1000)+1)) && !t.contains("m1")   ){
                grade += 1; if(verb){System.out.print(check);}
            }else{
                if(verb) {System.out.print("x");}
            }            
        }catch(StackOverflowError e){
            if(verb){System.out.print("X");}
        }catch(Exception e){
            if(verb){System.out.print("X");}
        }  
        System.out.println( " [" + grade + "/" + tests + " tests passed] [" + (1.0*grade/tests*outof) + "/" + outof + " marks]");
        return (1.0*grade/tests*outof);
    }
    public static double testContainsNoRec(double outof){
        double grade = 0;
        int tests = 0;

        System.out.print("contains( recursion ) : ");
        tests += 1;
        try{
            BinaryTree t = new TestBT(80);
            Random rnd = new Random();
            t.contains("don't find me!");  // successfull match might happen too soon!
            //t.contains("n" + (rnd.nextInt(79*1000)+1));
            throw new NoRecursionException("looks like you are not using recursion");
        }catch(StackOverflowError e){
            grade = 0;
            if(verb) {System.out.print(check);}
            System.out.println( " [Seems like you used recursion. Can proceed for marks now.]");
        }catch(NoRecursionException e){ 
            grade = -10.0;
            { System.out.println(" [Looks like you are not using recursion. All contains marks will be lost for this part.]"); }   
        }catch(Exception e){
            {System.out.println(" [Something bad happened.");}
            grade= 0;
        }  
        return grade;
    }
    public static double testContains0(double outof){
        int grade = 0;
        int tests = 0;

        System.out.print("contains(size 0 tree) : ");
        for(String s : new String[]{"something", ""}){
            tests += 1;
            try{
                BinaryTree t = new BinaryTree();
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

       System.out.print("contains(size 1 tree) : ");
        for(String s : new String[]{"a", "b"}){ tests += 1;
            try{
                BinaryTree t = new BinaryTree();
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


        System.out.print("contains(size 2 tree) : ");
        for(String s : new String[]{"a", "b", "c", "ab"}){ tests += 1;
            try{
                BinaryTree t = new BinaryTree();
                t.add(new String("a"));
                t.add("b");
                if( t.contains(s) == ("a".equals(s) || "b".equals(s) ) ){
                    grade += 1; if(verb) System.out.print(check);
                }
            }catch(Exception e){ if(verb){ System.out.print("x"); } }
        }  System.out.println( " [" + grade + "/" + tests + " tests passed] [" + (1.0*grade/tests*outof) + "/" + outof + " marks]");
        return 1.0*grade/tests*outof;
    }

    public static double testContainsLarger(double outof){
        int grade = 0;
        int tests = 0;
        int size = 128*16;
        System.out.print("contains(larger tree) : ");
        try{
            BinaryTree t = new BinaryTree();
            for(int i=1; i<=size; i+=2){t.add("n"+i);}
            for(int i=1; i<=size; i+=1){ tests +=1;
                try{
                    boolean c = t.contains("n"+i);
                    if( (c && (i%2==1) ) || (!c && (i%2==0)) ) {
                        grade += 1; if(verb) System.out.print(check);
                    }
                }catch(Exception e){ if(verb){ System.out.print("x"); } }
            }
        }catch(Exception e){
            if(verb){ System.out.print("X"); }
        }  System.out.println( " [" + grade + "/" + tests + " tests passed] [" + (1.0*grade/tests*outof) + "/" + outof + " marks]");
        return 1.0*grade/tests*outof;
    }

    public static BinaryTree makeTree(int size){
        BinaryTree t = new TestBT();
        for(int i=1; i<= 2*size; i+=2){
            t.add("N" + i);
        }
        return t;
    }

/*    
    public static List<BinaryTree> makeLongTrees(int size){
        List<BinaryTree> trees = new ArrayList<BinaryTree>();
        BinaryTree t = new TestBT();
        Node end = new Node();
        for(int i=1; i<= 2*size; i+=2){
            t.add("N" + i);
        }
        return t;
    }

*/
    public static int bt(){
        BinaryTree t = new TestBT();
        t.root = null;
        t.size = 0;
        return 1;

    }

    public static double testIsBST(double outof){
        int grade = 0;
        int tests = 0;

        System.out.print("isBST(really small tree true) : ");
        try{ tests +=1;
            TestBT t = new TestBT();
            Node n = new Node("cat", new Node("ant"), null);
            t.root = n; t.size = 2;
            TestBT t2 = new TestBT();
            Node n2 = new Node("ant", new Node("cat"), null);
            t2.root = n2; t2.size = 2;

            if( t.isBST() ) {
                grade += 1; if(verb) {System.out.print(check);} {System.out.println("[pass]");}
            }else{ if(verb){ System.out.print("x");} {System.out.println("[fail] did not identity the following tree as a bst\n"+t);} }
        }catch(Exception e){ if(verb){ System.out.print("X"); } }

        
        System.out.print("isBST(really small tree false) : ");
        try{ tests +=1;
            TestBT t = new TestBT();
            Node n = new Node("cat", new Node("ant"), null);
            t.root = n; t.size = 2;
            TestBT t2 = new TestBT();
            Node n2 = new Node("ant", new Node("cat"), null);
            t2.root = n2; t2.size = 2;

            if( !t2.isBST()) {
                grade += 1; if(verb) {System.out.print(check);} {System.out.println("[pass]");}
            }else{ if(verb){ System.out.print("x");} {System.out.println("[fail] did not identify the following tree as NOT a bst\n"+t2);} }
        }catch(Exception e){ if(verb){ System.out.print("X"); } }


        System.out.print("isBST(small tree true) : ");
        try{ tests +=1;
            TestBT t = new TestBT();
            Node n = new Node("bat", new Node("ant"), new Node("dog", new Node("cat"), new Node("eel")));
            t.root = n; t.size = 5;
            TestBT t2 = new TestBT();
            Node n2 = new Node("cat", new Node("dog"), new Node("bat", new Node("cat"), new Node("eel")));
            t2.root = n2; t2.size = 5;

            if( t.isBST()) {
                grade += 1; if(verb) {System.out.print(check);}{System.out.println("[pass]");}
            }else{ if(verb){ System.out.print("x");} {System.out.println("[fail] did not identity the following tree as a bst\n"+t);} }
        }catch(Exception e){ if(verb){ System.out.print("X"); } }

        System.out.print("isBST(small tree false) : ");
        try{ tests +=1;
            TestBT t = new TestBT();
            Node n = new Node("bat", new Node("ant"), new Node("dog", new Node("cat"), new Node("eel")));
            t.root = n; t.size = 5;
            TestBT t2 = new TestBT();
            Node n2 = new Node("cat", new Node("dog"), new Node("bat", new Node("cat"), new Node("eel")));
            t2.root = n2; t2.size = 5;

            if( !t2.isBST()) {
                grade += 1; if(verb) {System.out.print(check);}{System.out.println("[pass]");}
            }else{ if(verb){ System.out.print("x");} {System.out.println("[fail] did not identify the following tree as NOT a bst\n"+t2);} }
        }catch(Exception e){ if(verb){ System.out.print("X"); } }




        System.out.print("isBST(less small tree true) : ");
        try{ tests +=1;
            TestBT t = new TestBT();
            Node abc = new Node("b", new Node("a"), new Node("c"));
            Node efg = new Node("f", new Node("e"), new Node("g"));
            Node d = new Node("d", abc, efg);
            Node ijk = new Node("j", new Node("i"), new Node("k"));
            Node mno = new Node("n", new Node("m"), new Node("o"));
            Node l = new Node("l", ijk, mno);
            Node h = new Node("h", d, l);
            t.root = h;
            t.size = 15;
            
            TestBT t2 = new TestBT();
            Node abc2 = new Node("b", new Node("a"), new Node("c"));
            Node efg2 = new Node("f", new Node("e"), new Node("g"));
            Node d2 = new Node("d", abc2, efg2);
            Node ijk2 = new Node("j", new Node("i", new Node("g2"), null), new Node("k"));
            Node mno2 = new Node("n", new Node("m"), new Node("o"));
            Node l2 = new Node("l", ijk2, mno2);
            Node h2 = new Node("h", d2, l2);
            t2.root = h2;
            t2.size = 15;

            if( t.isBST() ) {
                grade += 1; if(verb) {System.out.print(check);}{System.out.println("[pass]");}
            }else{ if(verb){ System.out.print("x");} {System.out.println("[fail] did not identity the following tree as a bst\n"+t);} }
        }catch(Exception e){ if(verb){ System.out.print("X"); } }

        System.out.print("isBST(less small tree false) : ");
        try{ tests +=1;
            TestBT t = new TestBT();
            Node abc = new Node("b", new Node("a"), new Node("c"));
            Node efg = new Node("f", new Node("e"), new Node("g"));
            Node d = new Node("d", abc, efg);
            Node ijk = new Node("j", new Node("i"), new Node("k"));
            Node mno = new Node("n", new Node("m"), new Node("o"));
            Node l = new Node("l", ijk, mno);
            Node h = new Node("h", d, l);
            t.root = h;
            t.size = 15;
            
            TestBT t2 = new TestBT();
            Node abc2 = new Node("b", new Node("a"), new Node("c"));
            Node efg2 = new Node("f", new Node("e"), new Node("g"));
            Node d2 = new Node("d", abc2, efg2);
            Node ijk2 = new Node("j", new Node("i", new Node("g2"), null), new Node("k"));
            Node mno2 = new Node("n", new Node("m"), new Node("o"));
            Node l2 = new Node("l", ijk2, mno2);
            Node h2 = new Node("h", d2, l2);
            t2.root = h2;
            t2.size = 16;

            if(  !t2.isBST()) {
                grade += 1; if(verb) {System.out.print(check);}{System.out.println("[pass]");}
            }else{ if(verb){ System.out.print("x");} {System.out.println("[fail] did not identify the following tree as NOT a bst\n"+t2);} }
        }catch(Exception e){ if(verb){ System.out.print("X"); } }



        System.out.println( " [" + grade + "/" + tests + " tests passed] [" + (1.0*grade/tests*outof) + "/" + outof + " marks]");
        return 1.0*grade/tests*outof;
    }

    public static double testIsBSTBoth(double outof){
        int grade = 0;
        int tests = 0;

        System.out.print("isBST(really small tree) : ");
        try{ tests +=1;
            TestBT t = new TestBT();
            Node n = new Node("cat", new Node("ant"), null);
            t.root = n; t.size = 2;
            TestBT t2 = new TestBT();
            Node n2 = new Node("ant", new Node("cat"), null);
            t2.root = n2; t2.size = 2;

            if( t.isBST() && !t2.isBST() ) {
                grade += 1; if(verb) {System.out.print(check);} {System.out.println("[pass]");}
            }else if( t.isBST() ){
                System.out.println("failed to identify the following tree as NOT being a bst\n"+t2);
            }else if( !t2.isBST() ){
                System.out.println("failed to identify the following tree as being a bst\n"+t);
            }else{ 
                if(verb){ System.out.print("x");} 
                System.out.println("[fail]"); 
                System.out.println("failed to identify the following tree as being a bst\n"+t);
                System.out.println("failed to identify the following tree as NOT being a bst\n"+t2);
            }
        }catch(Exception e){ if(verb){ System.out.print("X"); } }


        System.out.print("isBST(small tree) : ");
        try{ tests +=1;
            TestBT t = new TestBT();
            Node n = new Node("bat", new Node("ant"), new Node("dog", new Node("cat"), new Node("eel")));
            t.root = n; t.size = 5;
            TestBT t2 = new TestBT();
            Node n2 = new Node("cat", new Node("dog"), new Node("bat", new Node("cat"), new Node("eel")));
            t2.root = n2; t2.size = 5;

            if( t.isBST() && !t2.isBST() ) {
                grade += 1; if(verb) {System.out.print(check);} {System.out.println("[pass]");}
            }else if( t.isBST() ){
                System.out.println("failed to identify the following tree as NOT being a bst\n"+t2);
            }else if( !t2.isBST() ){
                System.out.println("failed to identify the following tree as being a bst\n"+t);
            }else{ 
                if(verb){ System.out.print("x");} 
                System.out.println("[fail]"); 
                System.out.println("failed to identify the following tree as being a bst\n"+t);
                System.out.println("failed to identify the following tree as NOT being a bst\n"+t2);
            }
        }catch(Exception e){ if(verb){ System.out.print("X"); } }

        System.out.print("isBST(less small tree) : ");
        try{ tests +=1;
            TestBT t = new TestBT();
            Node abc = new Node("b", new Node("a"), new Node("c"));
            Node efg = new Node("f", new Node("e"), new Node("g"));
            Node d = new Node("d", abc, efg);
            Node ijk = new Node("j", new Node("i"), new Node("k"));
            Node mno = new Node("n", new Node("m"), new Node("o"));
            Node l = new Node("l", ijk, mno);
            Node h = new Node("h", d, l);
            t.root = h;
            t.size = 15;
            
            TestBT t2 = new TestBT();
            Node abc2 = new Node("b", new Node("a"), new Node("c"));
            Node efg2 = new Node("f", new Node("e"), new Node("g"));
            Node d2 = new Node("d", abc2, efg2);
            Node ijk2 = new Node("j", new Node("i", new Node("g2"), null), new Node("k"));
            Node mno2 = new Node("n", new Node("m"), new Node("o"));
            Node l2 = new Node("l", ijk2, mno2);
            Node h2 = new Node("h", d2, l2);
            t2.root = h2;
            t2.size = 16;

            if( t.isBST() && !t2.isBST() ) {
                grade += 1; if(verb) {System.out.print(check);} {System.out.println("[pass]");}
            }else if( t.isBST() ){
                System.out.println("failed to identify the following tree as NOT being a bst\n"+t2);
            }else if( !t2.isBST() ){
                System.out.println("failed to identify the following tree as being a bst\n"+t);
            }else{ 
                if(verb){ System.out.print("x");} 
                System.out.println("[fail]"); 
                System.out.println("failed to identify the following tree as being a bst\n"+t);
                System.out.println("failed to identify the following tree as NOT being a bst\n"+t2);
            }
        }catch(Exception e){ if(verb){ System.out.print("X"); } }



        System.out.println( " [" + grade + "/" + tests + " tests passed] [" + (1.0*grade/tests*outof) + "/" + outof + " marks]");
        return 1.0*grade/tests*outof;
    }


    public static double testIsBSTBothBigger(double outof){
        int grade = 0;
        int tests = 0;

        System.out.print("isBST(size 57 tree) : ");
        try{ tests +=1;
            BinaryTree t = makeMediumBST("A");
            BinaryTree t2 = makeMediumBST2("A");
           
            if( t.isBST() && !t2.isBST() ) {
                grade += 1; if(verb) {System.out.print(check);} {System.out.println("[pass]");}
            }else if( t.isBST() ){
                System.out.println("failed to identify the following tree as NOT being a bst\n"+t2);
            }else if( !t2.isBST() ){
                System.out.println("failed to identify the following tree as being a bst\n"+t);
            }else{ 
                if(verb){ System.out.print("x");} 
                System.out.println("[fail]"); 
                System.out.println("failed to identify the following tree as being a bst\n"+t);
                System.out.println("failed to identify the following tree as NOT being a bst\n"+t2);
            }
        }catch(Exception e){ if(verb){ System.out.print("X"); } }



        System.out.println( " [" + grade + "/" + tests + " tests passed] [" + (1.0*grade/tests*outof) + "/" + outof + " marks]");
        return 1.0*grade/tests*outof;
    }


    public static void main(String[] args){
        int size = 10; try{size = Integer.parseInt(args[0]);}catch(Exception e){}
        int m = bt();
        double grade = 0;
        System.out.println("=================================");
        double ok_recursion = testContainsNoRec(1);
        grade += testContains0(0.5);
        grade += testContains1(1);
        grade += testContains2(2);
        grade += testContainsLarger(5);
        grade += testContainsBig(1.5);
        System.out.println("---------------------------------");
        if( ok_recursion < 0 ){
            System.out.println("BinaryTree.contains() --> 0/10   [This problem MUST use recursion]");
        }else{
            System.out.println("BinaryTree.contains() --> " + grade + "/10");
        }


        System.out.println("=================================");
        double grade2 = 0;
        grade2 += testIsBST(2);
        grade2 += testIsBSTBoth(3);
        grade2 += testIsBSTBothBigger(5);
        System.out.println("---------------------------------");
        System.out.println("BinaryTree.isBST() --> " + grade2 + "/10");
        /*
        BinaryTree t = makeTree(size);
        System.out.println(t);
        */
      


        System.err.println("\n\n=============================================");
        System.err.println(    "==  Summary of TestBT (BinaryTree Tester)  ==");
        System.err.println(    "=============================================");
        grade = Math.round(grade*100.0)/100.0;
        grade2 = Math.round(grade2*100.0)/100.0;
        
        if( ok_recursion < 0 ){
            System.err.println("BinaryTree.contains()     --> 0.0/10   [This problem MUST use recursion]");
        }else{
            System.err.println("BinaryTree.contains()     --> " + grade + "/10");
        }
            System.err.println("BinaryTree.isBST()        --> " + grade2 + "/10");
            System.err.println("======================================");
  

        /*
        BinaryTree bt = makeMediumBST2("base");
        ArrayList<String> btitems = new ArrayList<String>();
        inorder(bt.root, btitems);
        System.out.println(btitems);
        System.out.println(bt);
        */
    }






    public static BinaryTree makeMediumBST(String base){
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
        
        BinaryTree t = new TestBT();
        t.root = bh;
        t.size = 57;
        return t; 
    }
    public static BinaryTree makeMediumBST2(String base){
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
        Node n1 = bh.getLeft().getLeft().getLeft(); // BA
        Node n2 = bh.getLeft().getLeft().getLeft().getLeft().getRight().getRight().getRight().getRight().getRight().getRight().getRight(); //AOO
        // BA and AOO
        String swap = n1.getData();
        n1.setData(n2.getData());
        n2.setData(swap);
        BinaryTree t = new TestBT();
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
    public static BinaryTree makeSimpleBST(String base){
        BinaryTree t = new TestBT();
        t.root = makeSimpleBSTNodes(base);
        t.size = 15;
        return t; 
    }











}