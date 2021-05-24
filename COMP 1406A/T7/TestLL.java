
public class TestLL{
	public static void main(String[] args){
		// create an empty linked list
		LinkedList list = new LList();
		System.out.print("empty list : ");
		System.out.println(list);

		// create a list with one element
		// list = [cat]
		list = new LList("cat");
		System.out.print("singleton  : ");
		System.out.println(list);

		// add some elements to the back and front
		list.addBack("dog");
		list.addFront("owl");
		list.addBack("bat");
		System.out.print("some adds  : ");
		System.out.println(list);

		// abritrary adds
		list.add(1, "crow");
		list.add(1, "goat");
		list.add(2, "eel");
		System.out.print("more adds  : ");
		System.out.println(list);

		// some gets
		System.out.println("x_0   = " + list.get(0));
		System.out.println("x_1   = " + list.get(1));
		System.out.println("x_5   = " + list.get(5));
		System.out.println("x_n-1 = " + list.get(list.getSize()-1));

		// removes
		list.removeFront();
		list.removeFront();
		System.out.println("removes  : " + list);

		// removes
		list.remove(3);
		list.remove(list.getSize()-1);
		System.out.println("removes  : " + list);

		// remove front add to back
		System.out.println("before  : " + list);
		System.out.println("move front to back ");
		list.addBack( list.removeFront() );
		System.out.println("after   : " + list);


	}

}
