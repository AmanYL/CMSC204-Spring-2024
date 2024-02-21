
public class QueueUnderflowException extends Exception {
	public QueueUnderflowException()
	{
		super("Queue is empty");
	}
	public QueueUnderflowException(String message)
	{
		super(message);
	}
}
