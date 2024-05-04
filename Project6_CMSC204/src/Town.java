import java.util.ArrayList;

public class Town implements Comparable<Town>{
	private String name;
	ArrayList<Town> adjacentTowns = new ArrayList<>(); 
	private Road predecessorRoad;
	
	//Constructor
	public Town(String name) {
		this.name = name;
	}
	public Town(Town templateTown) {
		this.name = templateTown.name;
		this.adjacentTowns = templateTown.adjacentTowns;
	}
	
	public String getName() {
		return this.name;
	}
	public String toString() {
		return this.name;
	}
	public int hashCode() {
		return name.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		Town otherTown = (Town)obj;
		return (this.name.equals(otherTown.name));
	}	
	@Override
	public int compareTo(Town otherTown) {
		return (this.name.compareTo(otherTown.name));
	}
	//Additional methods
	public void setPredecessorRoad(Road road) {
		this.predecessorRoad = road;
	}
	public Road getPredecessorRoad() {
		return this.predecessorRoad;
	}
}
