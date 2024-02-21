import java.util.ArrayList;

public class MyQueue<T> implements QueueInterface<T> {
	private ArrayList<T> queue;
	private int maxSize;
	
	//Constructors
	public MyQueue() 
	{
		queue = new ArrayList<T>();
		this.maxSize = Integer.MAX_VALUE;
	}
	public MyQueue(int num)
	{
		queue = new ArrayList<T>(num);
		this.maxSize = num;
	}
	
	@Override
	public boolean isEmpty()
	{
		return queue.isEmpty();
	}
	@Override
	public boolean isFull()
	{
		return queue.size() == maxSize;
	}
	@Override
	public T dequeue() throws QueueUnderflowException
	{
		if(isEmpty()) {
			throw new QueueUnderflowException();
		}
		return queue.remove(0);
	}
	@Override
	public int size()
	{
		return queue.size();
	}
	@Override
	public boolean enqueue(T e) throws QueueOverflowException{
		if(this.isFull()) {
			throw new QueueOverflowException();
		}
		this.queue.add(e);
		return true;
	}
	@Override
	public String toString()
	{
		StringBuilder str = new StringBuilder();
        for (T element : queue) {
            str.append(element);
        }
        return str.toString();	
	}
	@Override
	public String toString(String delimiter) {
		StringBuilder str = new StringBuilder();
		for(int i=0; i<queue.size(); i++) {
			if(i == queue.size()-1)
				str.append(queue.get(i));
			else	
			str.append(queue.get(i)+delimiter);
		}
		return str.toString();
	}
	@Override
	public void fill(ArrayList list) throws QueueOverflowException {
		if(!isEmpty()) {
			queue.clear();
		}
		T[] temp = (T[])new Object[maxSize];
		temp = (T[]) list.toArray();
		for(T item : temp) {
			T copy = (T) item;
			enqueue(copy);					
		}
	}	
}
