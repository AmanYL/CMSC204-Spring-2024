import java.util.ArrayList;
import java.util.Comparator;



public class Main {
	public static void main(String[] args) {
		BasicDoubleLinkedList<String> linkedString;
		BasicDoubleLinkedList<Double> linkedDouble;
		BasicDoubleLinkedList<Car> linkedCar;
		StringComparator comparator;
		DoubleComparator comparatorD;
		CarComparator comparatorCar;
		
		Car a=new Car("Ford", "F150", 2005);
		Car b=new Car("Jeep", "Renegade", 2005);
		Car c=new Car("Honda", "Civic", 2005);
		Car d=new Car("Subaru", "Outback", 2005);
		Car e=new Car("Chevrolet", "Silverado", 2005);
		Car f=new Car("Chrysler", "PTCruiser", 2005);

		ArrayList<Car> fill = new ArrayList<Car>();
		
		linkedString = new BasicDoubleLinkedList<String>();
		linkedString.addToEnd​("Hello");
		linkedString.addToEnd​("World");
		comparator = new StringComparator();
		
		linkedDouble = new BasicDoubleLinkedList<Double>();
		linkedDouble.addToEnd​(15.0);
		linkedDouble.addToEnd​(100.0);
		comparatorD = new DoubleComparator();
		
		linkedCar= new BasicDoubleLinkedList<Car>();
		linkedCar.addToEnd​(b);
		linkedCar.addToEnd​(c);
		comparatorCar = new CarComparator();
		
		System.out.println(linkedCar.getFirst().toString());
		linkedCar.addToFront​(a);
		System.out.println(linkedCar.getFirst().toString());
		System.out.println(linkedCar.retrieveFirstElement().toString());
		System.out.println(linkedCar.getFirst().toString());
		System.out.println(linkedCar.retrieveFirstElement().toString());
		System.out.println(linkedCar.getFirst().toString());
	}

	
	
	static class DoubleComparator implements Comparator<Double>
	{

		@Override
		public int compare(Double arg0, Double arg1) {
			// TODO Auto-generated method stub
			return arg0.compareTo(arg1);
		}
		
	}
	
	}
