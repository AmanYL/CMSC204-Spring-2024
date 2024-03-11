import java.util.*;

public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T>{
	private Comparator<T> comparator;
	
	//Constructor
	public SortedDoubleLinkedList(Comparator<T> compareableObject) {
		super();
		comparator = compareableObject;
	}
	//Methods
	public void add(T data) {
		Node newNode = new Node(data);
		Node current = head;
		if(this.getSize() == 0) {
			head = newNode;
			tail = newNode;
			size++;
			return;
		}
		while(current != null) {
			if(comparator.compare((T)newNode.data,(T)current.data) <= 0) {
				if(current == head) {
					newNode.next = head;
					head.prev = newNode;
					head = newNode;
				}else {
					newNode.prev = current.prev;
					newNode.next = current;
					current.prev.next = newNode;
					current.prev = newNode;
				}
				size++;
				return;
			}
				current = current.next;
		}
		//The line of code below will be executed if the node is going to be added to the end.
		super.addToEnd​(data);
	}
	public ArrayList<T> toArrayList(){
		ArrayList<T> arrLst = new ArrayList<>();
		Node currNode = head;
		while(currNode != null) {
			arrLst.add(currNode.data);
			currNode = currNode.next;
		}
		return arrLst;
	}
	@Override
	public void addToFront​(T data) {
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}
	public void addToEnd(T data) {
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}
	public ListIterator<T> iterator(){
		return super.iterator();
	}
	public Node remove(T data, Comparator<T> comparator) {
		return super.remove(data, comparator);		
	}
	
}
