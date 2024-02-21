
public class QueueOverflowException extends Exception {
	public QueueOverflowException()
	{
		super("Queue is full");
	}
	public QueueOverflowException(String message)
	{
		super(message);
	}

}
