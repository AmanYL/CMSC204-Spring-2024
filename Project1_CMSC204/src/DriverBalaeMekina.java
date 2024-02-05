import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;

public class DriverBalaeMekina {

	public static void main(String[] args) throws WeakPasswordException, LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException {
		ArrayList<String> passwords;
		String password1, password2;
		
		ArrayList<String> thePasswords;
		String[] thePass = {"wALLlle@1275", "shR2!", "lwer28c@se", "UPER!!13CSE", "noNum@!QxZ", "They92Shar",
						"Seeems90@GUD", "v@LId47"};
		thePasswords = new ArrayList<>();
		thePasswords.addAll(Arrays.asList(thePass));
		
		passwords = PasswordCheckerUtility.getInvalidPasswords(thePasswords);
		for(String paswz : passwords)
			System.out.println(paswz);

//		System.out.println(PasswordCheckerUtility.isWeakPassword(thePasswords.get(2)));
	}			
}



 
