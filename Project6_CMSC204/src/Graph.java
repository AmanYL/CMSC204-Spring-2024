import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;

public class Graph implements GraphInterface<Town, Road> {
	private Map<Town, Set<Road>> adjacencyMap;
	//Constructor
	public Graph() {
		adjacencyMap = new TreeMap<>();
	}
	
	@Override
	public Road getEdge(Town sourceVertex, Town destinationVertex) {
		Set<Road> roads = adjacencyMap.get(sourceVertex);
		if(roads != null) 
		{
			for(Road road : roads) 
			{
				if((road.getSource().equals(sourceVertex) && road.getDestination().equals(destinationVertex))
				 ||(road.getSource().equals(destinationVertex) && road.getDestination().equals(sourceVertex)))
					return road;
			}	
		}
		return null;
	}

	@Override
	public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		if(!adjacencyMap.containsKey(sourceVertex) || !adjacencyMap.containsKey(destinationVertex))
			throw new IllegalArgumentException("Source or destination vertices not found in the graph.");
		
		Road road = new Road(sourceVertex, destinationVertex, weight, description);
		adjacencyMap.get(sourceVertex).add(road);
		adjacencyMap.get(destinationVertex).add(road);
		return road;
	}

	@Override
	public boolean addVertex(Town v) {
		if(v == null)
			throw new NullPointerException();
		if(!adjacencyMap.containsKey(v))
		{
			adjacencyMap.put(v, new HashSet<>());
			return true;
		}
		return false;	
	}

	@Override
	public boolean containsEdge(Town sourceVertex, Town destinationVertex) {
		return getEdge(sourceVertex, destinationVertex) != null;
	}

	@Override
	public boolean containsVertex(Town v) {
		return adjacencyMap.containsKey(v);
	}

	@Override
	public Set<Road> edgeSet() {
		Set<Road> edges = new HashSet<>();
		for(Set<Road> roadSet : adjacencyMap.values())
			edges.addAll(roadSet);
		
		return edges;
	}

	@Override
	public Set<Road> edgesOf(Town vertex) {
		return adjacencyMap.get(vertex);
	}

	@Override
	public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		Road roadToRemove = getEdge(sourceVertex, destinationVertex);
		if(roadToRemove != null && roadToRemove.distance == weight && roadToRemove.getName().equals(description)) 
		{
			adjacencyMap.get(sourceVertex).remove(roadToRemove);
			adjacencyMap.get(destinationVertex).remove(roadToRemove);
			return roadToRemove;
		}
		return null;
	}

	@Override
	public boolean removeVertex(Town v) {
		if(adjacencyMap.containsKey(v) && v != null)
		{
			Set<Road> roadsToRemove = adjacencyMap.get(v);
			for(Road road : roadsToRemove) 
			{
				Town adjacentTown = (road.getSource().equals(v) ? road.getDestination() : road.getSource());
				adjacencyMap.get(adjacentTown).remove(road);
			}
			adjacencyMap.remove(v);
			return true;
		}
		return false;
	}

	@Override
	public Set<Town> vertexSet() {
		return adjacencyMap.keySet();
	}

	@Override
    public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) {
        // Run Dijkstra's algorithm to find the shortest path
        dijkstraShortestPath(sourceVertex);

        // Initialize ArrayList to store the shortest path
        ArrayList<String> shortestPath = new ArrayList<>();

        // Start from the destination vertex and backtrack through the predecessors
        Town currentVertex = destinationVertex;
        while (currentVertex != null) {
            // Get the predecessor road of the current vertex
            Road predecessorRoad = currentVertex.getPredecessorRoad();
            if (predecessorRoad != null) {
                // Append the path information to the result ArrayList
                shortestPath.add(0, predecessorRoad.getOtherTown(currentVertex).getName() + " via " + 
                predecessorRoad.getName() + " to " + currentVertex.getName() + " " + predecessorRoad.getWeight()+" mi");
                // Move to the predecessor vertex
                currentVertex = predecessorRoad.getOtherTown(currentVertex);
            } else {
                // If there's no predecessor, it means we've reached the source vertex
                currentVertex = null;
            }
        }

        return shortestPath;
    }
	
	@Override
	public void dijkstraShortestPath(Town sourceVertex) {
	    // Initialize distances and predecessors
	    Map<Town, Integer> distances = new TreeMap<>();
	    Map<Town, Road> predecessors = new TreeMap<>();

	    // Initialize priority queue for vertices
	    PriorityQueue<Town> queue = new PriorityQueue<>((t1, t2) -> distances.get(t1) - distances.get(t2));

	    // Initialize all distances to infinity and predecessors to null
	    for (Town vertex : adjacencyMap.keySet()) {
	        distances.put(vertex, Integer.MAX_VALUE);
	        predecessors.put(vertex, null);
	    }

	    // Set distance of source vertex to 0 and add it to the queue
	    distances.put(sourceVertex, 0);
	    queue.add(sourceVertex);

	    // Dijkstra's algorithm
	    while (!queue.isEmpty()) {
	        Town u = queue.poll();

	        // Iterate through u's neighbors
	        for (Road edge : adjacencyMap.get(u)) {
	            Town v = edge.getOtherTown(u);
	            int weightUV = edge.getWeight();
	            int alt = distances.get(u) + weightUV;
	            if (alt < distances.get(v)) {
	                distances.put(v, alt);
	                predecessors.put(v, edge);
	                // Update the queue with the new distance
	                queue.remove(v); // Remove the old entry
	                queue.add(v);    // Add the updated entry with the new distance
	            }
	        }
	    }

	    // Update predecessor roads for each vertex
	    for (Town vertex : adjacencyMap.keySet()) {
	        vertex.setPredecessorRoad(predecessors.get(vertex));
	    }
	}
}
