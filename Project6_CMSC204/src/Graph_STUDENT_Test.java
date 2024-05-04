import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Graph_STUDENT_Test {
    private Graph graph;

    @Before
    public void setUp() {
        graph = new Graph();
        Town townA = new Town("A");
        Town townB = new Town("B");
        Town townC = new Town("C");
        graph.addVertex(townA);
        graph.addVertex(townB);
        graph.addVertex(townC);
        graph.addEdge(townA, townB, 5, "AB");
        graph.addEdge(townB, townC, 10, "BC");
        graph.addEdge(townA, townC, 20, "AC");
    }

    @After
    public void tearDown() {
        graph = null;
    }

    @Test
    public void testGetEdge() {
        Town townA = new Town("A");
        Town townB = new Town("B");
        Town townC = new Town("C");
        assertEquals("AB", graph.getEdge(townA, townB).getName());
        assertEquals("BC", graph.getEdge(townB, townC).getName());
    }

    @Test
    public void testAddVertex() {
        assertFalse(graph.addVertex(new Town("A")));
        assertTrue(graph.addVertex(new Town("D")));
    }

    @Test
    public void testContainsEdge() {
        Town townA = new Town("A");
        Town townB = new Town("B");
        assertTrue(graph.containsEdge(townA, townB));
    }

    @Test
    public void testContainsVertex() {
        Town townA = new Town("A");
        Town townD = new Town("D");
        assertTrue(graph.containsVertex(townA));
        assertFalse(graph.containsVertex(townD));
    }

    @Test
    public void testEdgeSet() {
        assertEquals(3, graph.edgeSet().size());
    }

    @Test
    public void testEdgesOf() {
        Town townA = new Town("A");
        assertEquals(2, graph.edgesOf(townA).size());
    }

    @Test
    public void testRemoveEdge() {
        Town townA = new Town("A");
        Town townB = new Town("B");
        assertEquals("AB", graph.removeEdge(townA, townB, 5, "AB").getName());
        assertNull(graph.removeEdge(townA, townB, 5, "AB"));
    }

    @Test
    public void testRemoveVertex() {
        Town townA = new Town("A");
        assertTrue(graph.removeVertex(townA));
        assertFalse(graph.removeVertex(townA));
    }

    @Test
    public void testVertexSet() {
        assertEquals(3, graph.vertexSet().size());
    }

    
}
