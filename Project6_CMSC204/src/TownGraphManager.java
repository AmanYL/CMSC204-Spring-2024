import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;

public class TownGraphManager implements TownGraphManagerInterface {
	Graph megaMap = new Graph();
	@Override
	public boolean addRoad(String town1, String town2, int weight, String roadName) {
		addTown(town1);
		addTown(town2);
		Town town_1 = getTown(town1);
		Town town_2 = getTown(town2);
		try {
			megaMap.addEdge(town_1, town_2, weight, roadName);
		}
		catch(Exception e)	{
			return false;
		}
		return true;
	}

	@Override
	public String getRoad(String town1, String town2) {
		Town town_1 = getTown(town1);
		Town town_2 = getTown(town2);
		
		Road roadFromT1toT2 = megaMap.getEdge(town_1, town_2);
		if(roadFromT1toT2 != null)
			return roadFromT1toT2.getName();
				
		return null;
	}

	@Override
	public boolean addTown(String v) {
		Town town = new Town(v);
		return megaMap.addVertex(town);
	}

	@Override
	public Town getTown(String name) {
		Town town = new Town(name);
		if(megaMap.containsVertex(town))
			return town;
		return null;
	}

	@Override
	public boolean containsTown(String v) {
		Town town = new Town(v); 
		return megaMap.containsVertex(town);
	}

	@Override
	public boolean containsRoadConnection(String town1, String town2) {
		Town town_1 = getTown(town1);
		Town town_2 = getTown(town2);
		
		return megaMap.containsEdge(town_1, town_2) ;
	}

	@Override
	public ArrayList<String> allRoads() {
		Set<Road> theRoads = megaMap.edgeSet();
		ArrayList<String> roadNames = new ArrayList<>();
		for(Road aRoad : theRoads) {
			roadNames.add(aRoad.getName());
		}
		Collections.sort(roadNames);
		return roadNames;
	}

	@Override
	public boolean deleteRoadConnection(String town1, String town2, String road) {
		Town town_1 = getTown(town1);
		Town town_2 = getTown(town2);
		if(containsRoadConnection(town1, town2)) {
			Road theRoad = megaMap.getEdge(town_1, town_2);
			int weight = theRoad.distance;
			return (megaMap.removeEdge(town_1, town_2, weight, road) != null);
		}
		return false;
	}

	@Override
	public boolean deleteTown(String v) {
		Town town = getTown(v);
		return megaMap.removeVertex(town);
	}

	@Override
	public ArrayList<String> allTowns() {
		Set<Town> theTowns = megaMap.vertexSet();
		ArrayList<String> townNames = new ArrayList<>();
		for(Town town : theTowns) {
			townNames.add(town.getName());
		}
		return townNames;
	}
	
	public ArrayList<String> getPath(String town1, String town2) {
        Town source = getTown(town1);
        Town destination = getTown(town2);

        // If either town is not in the graph, return null
        if (source == null || destination == null)
            return null;

        // Map to store the previous town in the shortest path
        Map<Town, Town> previousTowns = new HashMap<>();
        
        // Map to store the shortest distances from the source town
        Map<Town, Integer> distances = new HashMap<>();
        
        // Priority queue for Dijkstra's algorithm
        PriorityQueue<Town> pq = new PriorityQueue<>((t1, t2) -> distances.get(t1) - distances.get(t2));
        
        // Initialize distances, source has distance 0
        for (Town town : megaMap.vertexSet()) {
            if (town.equals(source))
                distances.put(town, 0);
            else
                distances.put(town, Integer.MAX_VALUE);
            pq.add(town);
        }

        while (!pq.isEmpty()) {
            Town current = pq.poll();
            if (current.equals(destination))
                break; // We have reached the destination
            
            // Visit neighbors of the current town
            Set<Road> roads = megaMap.edgesOf(current);
            for (Road road : roads) {
                Town neighbor = road.getSource().equals(current) ? road.getDestination() : road.getSource();
                int newDistance = distances.get(current) + road.distance;
                if (newDistance < distances.get(neighbor)) {
                    distances.put(neighbor, newDistance);
                    previousTowns.put(neighbor, current);
                    // Update priority queue
                    pq.remove(neighbor);
                    pq.add(neighbor);
                }
            }
        }

        // If destination is not reachable from source, return an empty ArrayList
        if (!previousTowns.containsKey(destination))
            return new ArrayList<>();

        // Reconstruct the path from destination to source
        LinkedList<String> path = new LinkedList<>();
        Town current = destination;
        while (current != null) {
            Town previous = previousTowns.get(current);
            if (previous != null) {
            	Road road = megaMap.getEdge(previous, current);
                path.addFirst(previous.getName() + " via " + road.getName() + " to " + current.getName() + " " + road.distance + " mi");
            }
            current = previous;
        }

        // Convert LinkedList to ArrayList and return
        return new ArrayList<>(path);
    }
}
