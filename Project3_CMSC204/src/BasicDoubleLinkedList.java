import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class BasicDoubleLinkedList <T> implements Iterable<T>
{
	protected Node head;
    protected Node tail;
    protected int size;
    
    //Constructor
	public BasicDoubleLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}
	/**
	 * This is an inner class that will be used as a node by the main class.
	 */
	protected class Node{
		//These are the fields for the inner class Node.
		T data; 
		Node prev, next;
		
		//Constructor
		public Node(T dataNode) {
			this.data = dataNode;
		}
	}
	//Methods
	public int getSize() {
		return this.size;
	}
	public void addToEnd​(T data) {
		Node newNode = new Node(data);
		if(tail == null) {
			tail = newNode;
			head = newNode;
		}else {
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
		}
		size++;
	}
	public void addToFront​(T data) {
		Node newNode = new Node(data);
		if(head == null) {
			head = newNode;
			tail = newNode;
		}else {
			head.prev = newNode;
			newNode.next = head;
			head = newNode;
		}
		size++;
	}
	public T getFirst() {
		if(head == null)
			return null;
		return head.data;
	}
	public T getLast() {
		if(tail == null)
			return null;
		return tail.data;
	}
	@Override
	public ListIterator<T> iterator() {
		return new DoubleLinkedListIterator();
	}
	public Node remove(T targetData, Comparator<T> comparator) {
		Node current = head;
		while(current != null)
		{
			if(current.data.equals(targetData)) {
				//The if-else block below checks if the targetData is at the head or not and removes the data
				if(current.prev != null) {
					current.prev.next = current.next;
				}else {
					head = current.next;
				}
				//The if-else block below checks if the targetData is at the tail or not and removes the data
				if(current.next != null) {
					current.next.prev = current.prev;
				}else {
					tail = current.prev;
				}
				size--;
				return current;
			}
			current = current.next;
		}
		return null;
	}
	public T retrieveFirstElement() {
		if(head == null) {
			return null;
		}
		T returnData = head.data;
		if(head.next != null){
			head.next.prev = null;
		}else {
			tail = null;
		}
		head = head.next;
		size--;
		return returnData;
	}
	public T retrieveLastElement() {
		if(tail == null)
			return null;
		T returnData = tail.data;
		if(tail.prev != null) {
			tail.prev.next = null;
		}else {
			head = null;
		}
		tail = tail.prev;
		size--;
		return returnData;
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

	/**
	 * This is an inner class and we will be used as an iterator for the main class.
	 */
	protected class DoubleLinkedListIterator implements ListIterator<T>
	{
		Node currentNxt = head;
		Node currentPrev;
		@Override
		public boolean hasNext() {
			return currentNxt != null;
		}
		@Override
		public boolean hasPrevious() {
			return currentPrev != null;
		}
		@Override
		public T next() {
			if(!hasNext()) {
				throw new NoSuchElementException();
			}
			T data = currentNxt.data;
			currentPrev = currentNxt;
			currentNxt = currentNxt.next;
			return data;
		}
		@Override
		public T previous() {
			if(!hasPrevious()) {
				throw new NoSuchElementException(); 
			}
			T data = currentPrev.data;
			currentPrev = currentPrev.prev;
			return data;
		}
		@Override
		public void add(T e)throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}
		@Override
		public int previousIndex()throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}
		@Override
		public int nextIndex()throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}
		@Override
		public void remove()throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}
		@Override
		public void set(T e)throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}
	}
}
