import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class CourseDBStructure implements CourseDBStructureInterface{
	private LinkedList<CourseDBElement>[] hashTable;
	private int tableSize;
	private final double LOAD_SIZE = 1.5;

	//Constructors
	public CourseDBStructure(int n) {
		tableSize = next4kPrime((int)(n/LOAD_SIZE));
		hashTable = new LinkedList[tableSize];
		for(int i=0; i<tableSize; i++)
			hashTable[i] = new LinkedList<>();
	}
	public CourseDBStructure(String testing, int size) {
		tableSize = size;
		hashTable = new LinkedList[tableSize];
		for(int i=0; i<tableSize; i++)
			hashTable[i] = new LinkedList<>();
	}
	
	public void add(CourseDBElement element) {
		String CRN_String = String.valueOf(element.getCRN());
		int hashIndex = CRN_String.hashCode() % tableSize;
		
		if(hashTable[hashIndex].isEmpty())
			hashTable[hashIndex].add(element);
		else {
			for(int i=0; i<hashTable[hashIndex].size(); i++) {
				CourseDBElement elem = hashTable[hashIndex].get(i);
				if(elem.compareTo(element) == 0) 
				{
					if(elem.equals(element))
						return;
					else {
						hashTable[hashIndex].set(i, element);
						return;
					}	
				}
			}
			hashTable[hashIndex].add(element);
		}
	}
	
	public CourseDBElement get(int crn) throws IOException{
		String CRN_String = String.valueOf(crn);
		int hashIndex = CRN_String.hashCode() % tableSize;
		
		for(CourseDBElement elem : hashTable[hashIndex]) {
			if(elem.getCRN() == crn)
				return elem;
		}
		throw new IOException("CRN not found");
	}
	
	public ArrayList<String> showAll(){
		ArrayList<String> courses = new ArrayList<>();
		LinkedList<CourseDBElement>[] hashTableSort = Arrays.copyOf(hashTable, hashTable.length);

		for(LinkedList<CourseDBElement> bucket : hashTableSort) {
			for(CourseDBElement element :bucket)
				courses.add('\n'+element.toString());
		}
		return courses;
	}
	
	public int getTableSize() {
		return tableSize;
	}
	
	//Additional methods
	/**
	 * Finds the next (4k+3)prime number greater than the given number.
	 * 
	 * @param num The starting number from which to find the next 4k+3 prime.
	 * @return The next prime number which is a multiple of 4 plus 3 greater than the given number.
	 */
	public static int next4kPrime(int num) { 
		do{
			num++;
		}while((num-3)%4 != 0 || !isPrime(num));
		
		return num;	
	}
	/**
	 * Checks whether a given integer is a prime number.
	 * 
	 * @param num The number to be checked for primality.
	 * @return true if the given number is prime, false otherwise.
	 */
	public static boolean isPrime(int num) {
		if (num <= 1)
			return false;
		for(int i=2; i <= Math.sqrt(num); i++) {
			if(num % i == 0)
				return false;
		}
		return true;		
	}
}
