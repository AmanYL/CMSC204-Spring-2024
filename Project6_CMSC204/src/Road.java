public class Road implements Comparable<Road> {
	private Town origin, destination;
	int distance;
	private String name;
	
	//Constructors 
	public Road(Town source, Town destination, int degrees, String name) {
		origin = source;
		this.destination = destination;
		this.distance = degrees;
		this.name = name;
	}
	public Road(Town source, Town destination, String name) {
		origin = source;
		this.destination = destination;
		this.name = name;
	}
	//Methods
	public boolean contains(Town town) {
		if (town.equals(origin) || town.equals(destination))
			return true;
		return false;
	}
	public String toString() {
		return "Road name: "+name+ '\n'
			 + "Origin: "+ origin.getName()+ '\n'
			 + "Destination: "+destination.getName();
	}
	public String getName() {
		return this.name;
	}
	public Town getDestination() {
		return this.destination;
	}
	public Town getSource() {
		return this.origin;
	}
	@Override
	public int compareTo(Road otherRoad) {
		return (this.name.compareTo(otherRoad.name));
	}
	public int getWeight() {
		return this.distance;
	}
	@Override
	public boolean equals(Object otherObj) {
		Road otherRoad = (Road)otherObj;
		if(this.origin.equals(otherRoad.origin) || this.origin.equals(otherRoad.destination)) {
			if(this.destination.equals(otherRoad.destination) || this.destination.equals(otherRoad.origin))
				return true;
		}
		return false;
	}
	//Additional methods
	/**
	 * This method returns the town that is connected to the town that is passed as a 
	 * parameter, by the road that calls this method.
	 * @param town1
	 * @return adjacent town that is connected to town1 by road that calls the method.
	 */
	public Town getOtherTown(Town town1) {
		if(town1.equals(origin)) {
			return destination;
		}
		else if(town1.equals(destination)) {
			return origin;
		}
		else
			return null;	
	}
}

