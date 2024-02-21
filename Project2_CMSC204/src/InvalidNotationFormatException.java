public class InvalidNotationFormatException extends Exception {
	public InvalidNotationFormatException()
	{
		super("The format of the input is INVALID!");
	}
	public InvalidNotationFormatException(String message)
	{
		super(message);
	}
}
