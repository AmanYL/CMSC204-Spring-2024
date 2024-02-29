import java.util.ArrayList;
import java.util.regex.*;

public class PasswordCheckerUtility {
	
	//Constructor
	public PasswordCheckerUtility() {}
	
	/**
	 * Compare equality of two passwords.
	 *
	 * @param password        The first password string to be checked.
	 * @param passwordConfirm The second password string to be checked against the first.
	 * @throws UnmatchedException Thrown if the passwords are not the same (case-sensitive).
	 */
	public static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException
	{
		if(!passwordConfirm.equals(password))
				throw new UnmatchedException();				
	}	
	/**
	 * Compare equality of two passwords.
	 *
	 * @param password        The first password string to be checked.
	 * @param passwordConfirm The second password string to be checked against the first.
	 * @return True if both passwords are the same (case-sensitive), false otherwise.
	 */
	public static boolean comparePasswordsWithReturn(String password, String passwordConfirm) 
	{
		if(passwordConfirm.equals(password))
			return true;
		else
			return false;
	}
	/**
	 * Checks if the password meets the length requirement.
	 *
	 * @param password The password string to be checked for length.
	 * @return True if the password meets the minimum length requirement.
	 * @throws LengthException Thrown if the password does not meet the minimum length requirement.
	 */
	public static boolean isValidLength(String password) throws LengthException
	{
		if(password.length() >= 6)
			return true;
		else
			throw new LengthException();
	}
	/**
	 * Checks if the password contains at least one uppercase alphabetic character.
	 *
	 * @param password The password string to be checked for uppercase requirement.
	 * @return True if the password meets the uppercase character requirement.
	 * @throws NoUpperAlphaException Thrown if the password does not meet the uppercase character requirement.
	 */
	public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException
	{
		for(int i=0; i < password.length(); i++) {
			if(Character.isUpperCase(password.charAt(i)))
				return true;
		}
		throw new NoUpperAlphaException();
	}
	/**
	 * Checks if the password contains at least one lowercase alphabetic character.
	 *
	 * @param password The password string to be checked for lowercase requirement.
	 * @return True if the password meets the lowercase character requirement.
	 * @throws NoLowerAlphaException Thrown if the password does not meet the lowercase character requirement.
	 */
	public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException
	{
		for(int i=0; i < password.length(); i++) {
			if(Character.isLowerCase(password.charAt(i)))
				return true;
		}
		throw new NoLowerAlphaException();
	}
	/**
	 * Checks if the password contains at least one numeric character.
	 *
	 * @param password The password string to be checked for digit requirement.
	 * @return True if the password meets the digit requirement.
	 * @throws NoDigitException Thrown if the password does not meet the digit requirement.
	 */
	public static boolean hasDigit(String password) throws NoDigitException
	{
		for(int i=0; i < password.length(); i++) {
			if(Character.isDigit(password.charAt(i)))
				return true;
		}
		throw new NoDigitException();
	}
	/**
	 * Checks if the password contains at least one special character.
	 *
	 * @param password The password string to be checked for special character requirement.
	 * @return True if the password meets the special character requirement.
	 * @throws NoSpecialCharacterException Thrown if the password does not meet the special character requirement.
	 */
	public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException
	{
		String regex = ".*[^a-zA-Z0-9].*";
		if(Pattern.matches(regex, password))
			return true;
		else
			throw new NoSpecialCharacterException();
	}
	/**
	 * Checks if the password has more than two of the same character in sequence.
	 *
	 * @param password The password string to be checked for sequence requirement.
	 * @return False if the password meets the sequence requirement.
	 * @throws InvalidSequenceException Thrown if the password meets the sequence requirement.
	 */
	public static boolean NoSameCharInSequence(String password) throws InvalidSequenceException{
		for(int i=0; i < password.length()-2; i++) {
			int j = i+1, k = i+2;
			if(password.charAt(i) == password.charAt(j) && 
			   password.charAt(j) == password.charAt(k))
				throw new InvalidSequenceException();		
		}
		return false;
	}
	/**
	 * Checks if the password is valid based on various requirements.
	 *
	 * @param password The password string to be checked for validity.
	 * @return True if the password is valid.
	 */
	public static boolean isValidPassword(String password) throws LengthException, NoUpperAlphaException, 
	NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException
	{
		if(isValidLength(password) && hasUpperAlpha(password) && hasLowerAlpha(password) && hasDigit(password)
				&& hasSpecialChar(password) && !NoSameCharInSequence(password))
			return true;
		else
			return false;
	}
	/**
	 * Checks if the password contains between 6 and 9 characters (inclusive).
	 *
	 * @param password The password string to be checked for length.
	 * @return True if the password contains between 6 and 9 characters (inclusive), false otherwise.
	 */
	public static boolean hasBetweenSixAndNineChars(String password)
	{
		if(password.length() >= 6 && password.length() <= 9)
			return true;
		return false;
	}
	/**
	 * Checks if the password is considered weak, based on length and other validity requirements.
	 *
	 * @param password The password string to be checked for weakness.
	 * @return False if the password is valid and has a length between 6 and 9 characters (inclusive).
	 */
	public static boolean isWeakPassword(String password) throws WeakPasswordException, LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException
	{
		if(isValidPassword(password))
		{
			if(hasBetweenSixAndNineChars(password)) 
				throw new WeakPasswordException();
		}
		return false;
	}
	/**
	 * Retrieves a list of invalid passwords from an ArrayList, along with corresponding exception messages.
	 *
	 * @param passwords The ArrayList of passwords to be checked for validity.
	 * @return An ArrayList containing invalid passwords in the format "password exceptionMessage".
	 */
	public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords)
	{
		ArrayList<String> finalArr = new ArrayList<String>();
		
		for(String password : passwords)
		{
			try {
				isValidPassword(password);
			}
			catch(Exception e) {
				finalArr.add(password+" "+e.getMessage());
			}
		}
		return finalArr;
	}
}
