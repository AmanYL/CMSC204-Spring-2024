import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

public class DriverBalaeMekina {

	public static void main(String[] args) {
		ArrayList<String> passwords;
		String password1, password2;
		
		String[] p = {"334455BB#", "george2ZZZ#", "4Sal#", "bertha22", "august30", "a2cDe", 
				"ApplesxxxYYzz#", "aa11Bb", "pilotProject", "AAAbb@123"};
		passwords = new ArrayList<String>();
		passwords.addAll(Arrays.asList(p)); // puts strings into the ArrayList
		
			try{
				 
				boolean weakPwd = PasswordCheckerUtility.isWeakPassword("1234@aA");
				assertTrue("Did not throw WeakPassword Exception",false);
			}
			catch(WeakPasswordException e)
			{
				System.out.println(e.getMessage());
				assertTrue("Successfully threw a NoLowerAlphaExcepetion",true);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			
			ArrayList<String> results;
			results = PasswordCheckerUtility.getInvalidPasswords(passwords);
		}

	}

 
