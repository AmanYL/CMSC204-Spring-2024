
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author 
 *
 */
public class PasswordCheckerTest_STUDENT {
	ArrayList<String> thePasswords;
	
	@Before
	public void setUp() throws Exception {
		String[] thePass = {"wALLlle@1275", "shR2!", "lwer28c@se", "UPER!!13CSE", "noNum@!QxZ", "They92Shar",
				"Seeems90@GUD", "v@LId47"};
		thePasswords = new ArrayList<>();
		thePasswords.addAll(Arrays.asList(thePass));
	}

	@After
	public void tearDown() throws Exception {
		thePasswords = null;
	}

	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 * @throws LengthException 
	 */
	@Test
	public void testIsValidPasswordTooShort() throws LengthException
	{
		assertTrue(PasswordCheckerUtility.isValidLength("wALLlle@1275"));
		assertThrows(LengthException.class,()-> PasswordCheckerUtility.isValidLength("pqW4!"));
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 * @throws NoUpperAlphaException 
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha() throws NoUpperAlphaException
	{
		assertTrue(PasswordCheckerUtility.hasUpperAlpha("wALLlle@1275"));
		assertThrows(NoUpperAlphaException.class, ()-> PasswordCheckerUtility.hasUpperAlpha("lwer28c@se"));
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha() throws NoLowerAlphaException
	{
		assertTrue(PasswordCheckerUtility.hasLowerAlpha("wALLlle@1275"));
		assertThrows(NoLowerAlphaException.class, ()-> PasswordCheckerUtility.hasLowerAlpha("UPER!!13CSE"));
	}
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword()
	{
		try {
			assertTrue(PasswordCheckerUtility.isWeakPassword("nAp1@5"));
		} catch (WeakPasswordException e) {
			assertTrue("Successfully threw a WeakPasswordExcepetion", true);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			assertTrue("An incorrect exception was thrown", false);
		}
		
		try {
			assertFalse(PasswordCheckerUtility.isWeakPassword("wALLlle@1275"));
		} catch (WeakPasswordException | LengthException | NoUpperAlphaException | NoLowerAlphaException
				| NoDigitException | NoSpecialCharacterException | InvalidSequenceException e) {
			System.out.println(e.getMessage());
			assertTrue("An exception was not suppossed to be thrown", false);
		}
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 * @throws InvalidSequenceException 
	 */
	@Test
	public void testIsValidPasswordInvalidSequence() throws InvalidSequenceException
	{
		assertFalse(PasswordCheckerUtility.NoSameCharInSequence("wALLlle@1275"));
		assertThrows(InvalidSequenceException.class, ()-> PasswordCheckerUtility.NoSameCharInSequence("C@R245zzz"));
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 * @throws NoDigitException 
	 */
	@Test
	public void testIsValidPasswordNoDigit() throws NoDigitException
	{
		assertTrue(PasswordCheckerUtility.hasDigit("wALLlle@1275"));
		assertThrows(NoDigitException.class, ()-> PasswordCheckerUtility.hasDigit("noNum@!QxZ"));
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("wALLlle@1275"));
		} catch (LengthException | NoUpperAlphaException | NoLowerAlphaException | NoDigitException
				| NoSpecialCharacterException | InvalidSequenceException e) {
			System.out.println(e.getMessage());
			assertTrue("An exception was not supposed to be thrown", false);
		}	
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() {
		ArrayList<String> results;
		results = PasswordCheckerUtility.getInvalidPasswords(thePasswords);
		
		Scanner scan = new Scanner(results.get(0)); 
		assertEquals(scan.next(), "shR2!");
		String nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("long"));
		
		scan = new Scanner(results.get(1));  
		assertEquals(scan.next(), "lwer28c@se");
		nextResults = scan.nextLine().toLowerCase(); 
		assertTrue(nextResults.contains("uppercase"));
		 
		scan = new Scanner(results.get(2));  
		assertEquals(scan.next(), "UPER!!13CSE");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("lowercase"));
		
		scan = new Scanner(results.get(3));  
		assertEquals(scan.next(), "noNum@!QxZ");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("digit"));
		
		scan = new Scanner(results.get(4));  
		assertEquals(scan.next(), "They92Shar");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("special") );
		
		scan = new Scanner(results.get(5));  
		assertEquals(scan.next(), "Seeems90@GUD");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("sequence") );
		
	}
	
}
