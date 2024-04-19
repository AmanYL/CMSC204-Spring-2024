import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MorseCodeConverter {
	static MorseCodeTree MCdTree = new MorseCodeTree();
	
	public static String printTree() 
	{
		String str = "";
		ArrayList<String> strMCdTree = MCdTree.toArrayList();
		for(String strTree : strMCdTree) {
			str = str + strTree + " ";
		}
		str = str.stripTrailing();
		return str;
	}
	public static String convertToEnglish(String code) 
	{
		String[] words = code.split("/");
		StringBuilder str = new StringBuilder();
		for(String word : words) 
		{
			String[] letters = word.split(" ");
			for(String letter : letters) 
			{
				String engLetter = MCdTree.fetch(letter);
				str.append(engLetter);
			}
			str.append(" ");
		}
		//The line of code below removes the last space character.
		str.deleteCharAt(str.length()-1); 
		return str.toString();
	}
	public static String convertToEnglish(File codeFile)throws FileNotFoundException 
	{
		Scanner scanner = new Scanner(codeFile);
		StringBuilder morseCode = new StringBuilder();
		
		while(scanner.hasNextLine()) {
			morseCode.append(scanner.nextLine());
		}
		//The convertToEnglish method that takes a String as a parameter is called.
		return (convertToEnglish(morseCode.toString()));
	}

}
