import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CourseDBManager implements CourseDBManagerInterface{
	private CourseDBStructure courseDB;
	//Constructor
	public CourseDBManager() {
		courseDB = new CourseDBStructure(500);
	}
	
	@Override
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
		courseDB.add(new CourseDBElement(id, crn, credits, roomNum, instructor));
	}
	@Override
	public CourseDBElement get(int crn) {
		try {
			return courseDB.get(crn);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public void readFile(File input) throws FileNotFoundException {
		Scanner scanner = new Scanner(input);
		while(scanner.hasNextLine()) {
			String line = scanner.nextLine();
			String[] parts = line.split("\\s+", 5);
			if(parts.length == 5) {
				int CRN = Integer.parseInt(parts[1]);
				int credits = Integer.parseInt(parts[2]);
				add(parts[0], CRN, credits, parts[3], parts[4]);
			}
		}
		scanner.close();
	}
	@Override
	public ArrayList<String> showAll() {
		return courseDB.showAll();
	}
	
}
