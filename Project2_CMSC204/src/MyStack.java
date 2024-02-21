import java.util.ArrayList;

public class MyStack<T> implements StackInterface<T>{
	private ArrayList<T> stack;
	private int maxSize;

	//Constructors
	public MyStack() 
	{
		stack = new ArrayList<T>();
		this.maxSize = Integer.MAX_VALUE;
	}
	public MyStack(int num)
	{
		stack = new ArrayList<T>(num);
		this.maxSize = num;
	}
	
	@Override
	public boolean isEmpty() {
		return this.stack.isEmpty();
	}
	@Override
	public boolean isFull() {
		return this.stack.size() == maxSize;
	}
	@Override
	public T pop() throws StackUnderflowException {
		if(stack.isEmpty()) {
			throw new StackUnderflowException();
		}
		return stack.remove(stack.size()-1);
	}
	@Override
	public T top() throws StackUnderflowException {
		if(stack.isEmpty()) {
			throw new StackUnderflowException();
		}
		return stack.get(stack.size()-1);
	}
	@Override
	public int size() {
		return stack.size();
	}
	
	@Override
	public boolean push(T e) throws StackOverflowException {
		if(isFull()) {
			throw new StackOverflowException();
		}
		stack.add(e);
		return true;
	}
	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T element : stack) {
            sb.append(element);
        }
        return sb.toString();
    }
	@Override
	public String toString(String delimiter) {
		StringBuilder str = new StringBuilder();
		for(int i=0; i<stack.size(); i++) {
			if(i == stack.size()-1)
				str.append(stack.get(i));
			else	
			str.append(stack.get(i)+delimiter);
		}
		return str.toString();
	}
	@Override
	public void fill(ArrayList<T> list) throws StackOverflowException {
		if(!isEmpty()) {
			stack.clear();
		}
		T[] temp = (T[])new Object[maxSize];
		temp = (T[]) list.toArray();
		for(T item : temp) {
			T copy = (T) item;
			push(copy);					
		}
	}
}
