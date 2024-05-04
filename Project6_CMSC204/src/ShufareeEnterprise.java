import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class ShufareeEnterprise {
	
	public static void main(String[] args) {
		TownGraphManager graph;
		String[] town;

		 graph = new TownGraphManager();
		  town = new String[12];
		  
		  for (int i = 1; i < 12; i++) {
			  town[i] = "Town_" + i;
			  graph.addTown(town[i]);
		  }
		  
		  graph.addRoad(town[1], town[2], 2, "Road_1");
		  graph.addRoad(town[1], town[3], 4, "Road_2");
		  graph.addRoad(town[1], town[5], 6, "Road_3");
		  graph.addRoad(town[3], town[7], 1, "Road_4");
		  graph.addRoad(town[3], town[8], 2, "Road_5");
		  graph.addRoad(town[4], town[8], 3, "Road_6");
		  graph.addRoad(town[6], town[9], 3, "Road_7");
		  graph.addRoad(town[9], town[10], 4, "Road_8");
		  graph.addRoad(town[8], town[10], 2, "Road_9");
		  graph.addRoad(town[5], town[10], 5, "Road_10");
		  graph.addRoad(town[10], town[11], 3, "Road_11");
		  graph.addRoad(town[2], town[11], 6, "Road_12");
		  graph.addTown("Town_12");
	
		  //ArrayList<String> path = graph.getPath(town[1],town[11]);
		  //System.out.println(graph.addRoad(town[1], town[2], 2, "Road_1"));
		  //System.out.println(graph.getPath(town[1],town[2]).toString());
		  //System.out.println(graph.allRoads());
		  System.out.println(graph.getPath(town[1], town[10]));
		  
		  ///skdfkdshf
		  Town t12 = new Town("Ana");
		  Town t13 = new Town("Nick");
		  graph.addTown("Ana");
		  graph.addTown("Nick");
		  graph.megaMap.addEdge(t12, t13, 2, "Bishoftu");
		  
		
		  
		  
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
