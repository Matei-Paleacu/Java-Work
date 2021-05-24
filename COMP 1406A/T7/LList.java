    /** A linked list implementation for the list ADT that stores _strings
 *
 * Represents a list X0, X1, X2, ..., Xn-1 of Strings
 */
public class LList extends LinkedList{

	/** Creates an empty linked list */
	public LList(){super();}

	/** Creates a linked list with a single item (X0)
	  *
		* @param s is string X0 in the created list of size 1.
		*/
	public LList(String s ){
		super(s);
	}

	@Override
	public int find(String s){
		for(int i = 0; i< this.size;i++){
			if(this.get(i) == s){						// this gets the current data store at the current node
				return i;
			}
		}
		return -1;
	}

	@Override
	public boolean set(int k, String s){
		this.add(k,s);
		return k!= 0;
	}

	@Override
	public String removeFront(){
		this.size -= 1;
		String data = head.getData();
		this.head = head.getNext();
		return data;
	}

	@Override
	public String remove(int position){
		if(position > this.getSize() || position < 0){
			return "";
		}
		else if(position == 0){
			removeFront();
		}
		else{
			int count = 0;
			Node current = head;
			while(count < position-1){
				current = current.getNext();					//gets the next head
				count+= 1;
			}
			current.setNext(current.getNext().getNext());		//sets the head that comes before the one looking to remove to the next node 
			return current.getData();							// returns the nodes data
		}
	}


}

