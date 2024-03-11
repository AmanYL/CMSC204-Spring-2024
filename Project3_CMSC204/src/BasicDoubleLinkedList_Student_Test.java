import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class BasicDoubleLinkedList_Student_Test {
	BasicDoubleLinkedList<String> linkedString;
	BasicDoubleLinkedList<Double> linkedDouble;
	BasicDoubleLinkedList<Car> linkedCar;
	StringComparator comparator;
	CarComparator comparatorCar;
	
	Car a=new Car("Toyota", "Land Crusier", 1999);
	Car b=new Car("Lexus", "LX500", 2022);
	Car c=new Car("Ferrari", "Roma", 2021);
	Car d=new Car("Mercedes", "AMG-One", 2021);
	Car e=new Car("Rimac", "Nevera", 2023);
	Car f=new Car("Koenisegg", "Jesko", 2022);
	
	public ArrayList<Car> fill = new ArrayList<Car>();
	
	@BeforeEach
	public void setUp() throws Exception {
		linkedString = new BasicDoubleLinkedList<String>();
		linkedString.addToEnd​("Selam");
		linkedString.addToEnd​("AdeyEndemnNeshe");
		comparator = new StringComparator();
		
		linkedDouble = new BasicDoubleLinkedList<Double>();
		linkedDouble.addToEnd​(15.0);
		linkedDouble.addToEnd​(100.0);
		
		linkedCar= new BasicDoubleLinkedList<Car>();
		linkedCar.addToEnd​(b);
		linkedCar.addToEnd​(c);
		comparatorCar = new CarComparator();
	}

	@AfterEach
	public void tearDown() throws Exception {
		linkedString = null;
		linkedDouble = null;
		linkedCar = null;
		comparator = null;
	}

	@Test
	public void testGetSize() {
		assertEquals(2,linkedString.getSize());
		assertEquals(2,linkedDouble.getSize());
		assertEquals(2,linkedCar.getSize());
	}
	
	@Test
	public void testAddToEnd() {
		assertEquals("AdeyEndemnNeshe", linkedString.getLast());
		linkedString.addToEnd​("End");
		assertEquals("End", linkedString.getLast());
		
		assertEquals(c,linkedCar.getLast());
		linkedCar.addToEnd​(d);
		assertEquals(d,linkedCar.getLast());
	}
	
	@Test
	public void testAddToFront() {
		
		assertEquals(b,linkedCar.getFirst());
		linkedCar.addToFront​(a);
		assertEquals(a,linkedCar.getFirst());
	}
	
	@Test
	public void testGetFirst() {
		assertEquals("Selam", linkedString.getFirst());
		linkedString.addToFront​("FreshFruits");
		assertEquals("FreshFruits", linkedString.getFirst());
		
	}

	@Test
	public void testGetLast() {	
		assertEquals(c,linkedCar.getLast());
		linkedCar.addToEnd​(d);
		assertEquals(d,linkedCar.getLast());
	}
	
	@Test
	public void testToArrayList()
	{
		ArrayList<Car> list;
		linkedCar.addToFront​(a);
		linkedCar.addToEnd​(d);
		list = linkedCar.toArrayList();
		assertEquals(a,list.get(0));
		assertEquals(b,list.get(1));
		assertEquals(c,list.get(2));
		assertEquals(d,list.get(3));
	}
	
	@Test
	public void testIteratorSuccessfulNext() {
		linkedString.addToFront​("Begin");
		linkedString.addToEnd​("End");
		ListIterator<String> iterator = linkedString.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals("Begin", iterator.next());
		assertEquals("Selam", iterator.next());
		assertEquals("AdeyEndemnNeshe", iterator.next());
		assertEquals(true, iterator.hasNext());
		assertEquals("End", iterator.next());
		
		linkedCar.addToFront​(a);
		linkedCar.addToEnd​(d);
		ListIterator<Car> iteratorCar = linkedCar.iterator();
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(a, iteratorCar.next());
		assertEquals(b, iteratorCar.next());
		assertEquals(c, iteratorCar.next());
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(d, iteratorCar.next());
	}
	
	@Test
	public void testIteratorSuccessfulPrevious() {
		linkedCar.addToFront​(a);
		linkedCar.addToEnd​(d);
		ListIterator<Car> iteratorCar = linkedCar.iterator();
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(a, iteratorCar.next());
		assertEquals(b, iteratorCar.next());
		assertEquals(c, iteratorCar.next());
		assertEquals(d, iteratorCar.next());
		assertEquals(true, iteratorCar.hasPrevious());
		assertEquals(d, iteratorCar.previous());
		assertEquals(c, iteratorCar.previous());
		assertEquals(b, iteratorCar.previous());
		assertEquals(a, iteratorCar.previous());
	}
	
	@Test
	public void testIteratorUnsupportedOperationException() {
		linkedCar.addToFront​(a);
		linkedCar.addToEnd​(d);
		ListIterator<Car> iteratorCar = linkedCar.iterator();		
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(a, iteratorCar.next());
		assertEquals(b, iteratorCar.next());
		assertEquals(c, iteratorCar.next());
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(d, iteratorCar.next());
		
		try{
			//remove is not supported for the iterator
			iteratorCar.remove();
			assertTrue("Did not throw a UnsupportedOperationException",false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw a UnsupportedOperationException",true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
		
	}
	
	@Test
	public void testRetrieveFirstElement() {
		assertEquals(b, linkedCar.getFirst());
		linkedCar.addToFront​(a);
		assertEquals(a, linkedCar.getFirst());
		assertEquals(a, linkedCar.retrieveFirstElement());
		assertEquals(b,linkedCar.getFirst());
		assertEquals(b, linkedCar.retrieveFirstElement());
		assertEquals(c,linkedCar.getFirst());
		
		assertEquals("Selam", linkedString.getFirst());
		linkedString.addToFront​("New");
		assertEquals("New", linkedString.getFirst());
		assertEquals("New", linkedString.retrieveFirstElement());
		assertEquals("Selam",linkedString.getFirst());
		assertEquals("Selam", linkedString.retrieveFirstElement());
		assertEquals("AdeyEndemnNeshe",linkedString.getFirst());
		
	}

	@Test
	public void testRetrieveLastElement() {
		assertEquals(c, linkedCar.getLast());
		linkedCar.addToEnd​(d);
		assertEquals(d, linkedCar.getLast());
		assertEquals(d, linkedCar.retrieveLastElement());
		assertEquals(c,linkedCar.getLast());

	}

	private class StringComparator implements Comparator<String>
	{
		@Override
		public int compare(String arg0, String arg1) {
			// TODO Auto-generated method stub
			return arg0.compareTo(arg1);
		}
		
	}
	
	
	private class CarComparator implements Comparator<Car>
	{
		@Override
		public int compare(Car arg0, Car arg1) {
			// Just put cars in alphabetic order by make
			return arg0.toString().compareTo(arg1.toString());
		}
		
	}

	private class Car{
		String make;
		String model;
		int year;
		
		public Car(String make, String model, int year){
			this.make = make;
			this.model = model;
			this.year = year;
		}
		
		public String getMake(){
			return make;
		}
		public String getModel(){
			return model;
		}
		public int getYear(){
			return year;
		}
		
		public String toString() {
			return (getMake()+" "+getModel()+" "+getYear());
		}
	}
}
