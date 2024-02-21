
public class StackUnderflowException extends Exception {
	public StackUnderflowException()
	{
		super("Stack is empty");
	}
	public StackUnderflowException(String message)
	{
		super(message);
	}
}
