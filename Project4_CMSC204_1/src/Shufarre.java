import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Shufarre {
	public static void main(String[] args) throws FileNotFoundException {
//		CourseDBStructure cds, testStructure;
//		cds = new CourseDBStructure(20);
//		testStructure = new CourseDBStructure("Testing", 20);
//		//Create a course 
//			CourseDBElement cde1 = new CourseDBElement("CMSC500", 39999, 4, "SC100", "Nobody InParticular");
//				
//			cds.add(cde1);  //add to data structure
//			cds.add(cde1);  // add it again. add method  should  ignore it
//			CourseDBElement cde1Update = new CourseDBElement("CMSC500-updated", 39999, 4, "SC100", "updated");
//			cds.add(cde1Update);  //Same CRN updated information
//			
//			ArrayList<String> courseList = cds.showAll(); 
//			
//			System.out.println(courseList.toString());		
		
		CourseDBManagerInterface dataMgr = new CourseDBManager();
		dataMgr.add("CMSC203",30504,4,"SC450","Joey Bag-O-Donuts");
		dataMgr.add("CMSC203",30503,4,"SC450","Jill B. Who-Dunit");
		dataMgr.add("CMSC204",30559,4,"SC450","BillyBob Jones");
	
		File file = new File("courses.txt");
		dataMgr.readFile(file);
		
		ArrayList<String> list = dataMgr.showAll();
		System.out.println(list.toString());
//		System.out.println(list.get(1));
//		System.out.println(list.get(2));
//		System.out.println(list.get(3));
	}

	
	
	
	
	
	
	
	
	
	
}
