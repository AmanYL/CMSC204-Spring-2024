import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Town_STUDENT_Test {

	@Test
    public void testGetName() {
        Town town = new Town("TestTown");
        assertEquals("TestTown", town.getName());
    }

    @Test
    public void testToString() {
        Town town = new Town("TestTown");
        assertEquals("TestTown", town.toString());
    }

    @Test
    public void testEquals() {
        Town town1 = new Town("TestTown1");
        Town town2 = new Town("TestTown1");
        assertTrue(town1.equals(town2));
    }

    @Test
    public void testHashCode() {
        Town town1 = new Town("TestTown");
        Town town2 = new Town("TestTown");
        assertEquals(town1.hashCode(), town2.hashCode());
    }

    @Test
    public void testCompareTo() {
        Town town1 = new Town("Town1");
        Town town2 = new Town("Town2");
        assertTrue(town1.compareTo(town2) < 0);
    }

    @Test
    public void testSetAndGetPredecessorRoad() {
        Town town = new Town("TestTown");
        Road road = new Road(new Town("StartTown"), new Town("EndTown"), 10, "Road");
        town.setPredecessorRoad(road);
        assertEquals(road, town.getPredecessorRoad());
    }

}
