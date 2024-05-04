import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Road_STUDENT_Test {
    private Road road;

    @Before
    public void setUp() {
        Town origin = new Town("Origin");
        Town destination = new Town("Destination");
        road = new Road(origin, destination, 10, "TestRoad");
    }

    @After
    public void tearDown() {
        road = null;
    }

    @Test
    public void testContains() {
        Town origin = new Town("Origin");
        assertTrue(road.contains(origin));

        Town destination = new Town("Destination");
        assertTrue(road.contains(destination));

        Town otherTown = new Town("OtherTown");
        assertFalse(road.contains(otherTown));
    }

    @Test
    public void testToString() {
        String expected = "Road name: TestRoad\nOrigin: Origin\nDestination: Destination";
        assertEquals(expected, road.toString());
    }

    @Test
    public void testGetName() {
        assertEquals("TestRoad", road.getName());
    }

    @Test
    public void testGetDestination() {
        assertEquals("Destination", road.getDestination().getName());
    }

    @Test
    public void testGetSource() {
        assertEquals("Origin", road.getSource().getName());
    }

    @Test
    public void testCompareTo() {
        Road otherRoad = new Road(new Town("Origin"), new Town("Destination"), 10, "AnotherRoad");
        assertTrue(road.compareTo(otherRoad) > 0);
    }

    @Test
    public void testEquals() {
        Road equalRoad = new Road(new Town("Origin"), new Town("Destination"), 10, "TestRoad");
        assertTrue(road.equals(equalRoad));

        Road differentRoad = new Road(new Town("Origin"), new Town("OtherDestination"), 10, "TestRoad");
        assertFalse(road.equals(differentRoad));
    }

    @Test
    public void testGetOtherTown() {
        Town origin = new Town("Origin");
        Town destination = new Town("Destination");
        assertEquals(destination, road.getOtherTown(origin));
        assertEquals(origin, road.getOtherTown(destination));
        assertNull(road.getOtherTown(new Town("OtherTown")));
    }
}
