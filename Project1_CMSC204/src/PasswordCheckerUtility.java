import java.util.ArrayList;
import java.util.regex.*;

public class PasswordCheckerUtility {
	
	//Constructor
	public PasswordCheckerUtility() {}
	
	//Methods
	public static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException{
		if(!passwordConfirm.equals(password))
				throw new UnmatchedException();				
	}	
	public static boolean comparePasswordsWithReturn(String password, String passwordConfirm) {
		if(passwordConfirm.equals(password))
			return true;
		else
			return false;
	}
	public static boolean isValidLength(String password) throws LengthException{
		if(password.length() >= 6)
			return true;
		else
			throw new LengthException();
	}
	public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException{
		for(int i=0; i < password.length(); i++) {
			if(Character.isUpperCase(password.charAt(i)))
				return true;
		}
		throw new NoUpperAlphaException();
	}
	public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException{
		for(int i=0; i < password.length(); i++) {
			if(Character.isLowerCase(password.charAt(i)))
				return true;
		}
		throw new NoLowerAlphaException();
	}
	public static boolean hasDigit(String password) throws NoDigitException{
		for(int i=0; i < password.length(); i++) {
			if(Character.isDigit(password.charAt(i)))
				return true;
		}
		throw new NoDigitException();
	}
	public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException{
		String regex = ".*[^a-zA-Z0-9].*";
		if(Pattern.matches(regex, password))
			return true;
		else
			throw new NoSpecialCharacterException();
	}
	public static boolean NoSameCharInSequence(String password) throws InvalidSequenceException{
		for(int i=0; i < password.length()-2; i++) {
			int j = i+1, k = i+2;
			if(password.charAt(i) == password.charAt(j) && 
			   password.charAt(j) == password.charAt(k))
				throw new InvalidSequenceException();		
		}
		return false;
	}
	public static boolean isValidPassword(String password) throws LengthException, NoUpperAlphaException, 
	NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException
	{
		if(isValidLength(password) && hasUpperAlpha(password) && hasLowerAlpha(password) && hasDigit(password)
				&& hasSpecialChar(password) && !NoSameCharInSequence(password))
			return true;
		else
			return false;
	}
	public static boolean hasBetweenSixAndNineChars(String password) {
		if(password.length() >= 6 && password.length() <= 9)
			return true;
		return false;
	}
	public static boolean isWeakPassword(String password) throws WeakPasswordException, LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException
	{
		if(isValidPassword(password))
		{
			if(hasBetweenSixAndNineChars(password)) 
				throw new WeakPasswordException();
		}
		return false;
	}
	public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords){
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
