
public class StackOverflowException extends Exception {
	public StackOverflowException()
	{
		super("Stack is full");
	}
	public StackOverflowException(String message)
	{
		super(message);
	}
}
