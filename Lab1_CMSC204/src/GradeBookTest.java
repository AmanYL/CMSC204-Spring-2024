import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class GradeBookTest {
	private GradeBook g1;
    private GradeBook g2;
    private GradeBook g3;

    @BeforeEach
    public void setUp() {
        g1 = new GradeBook(5);
        g1.addScore(50);
        g1.addScore(75);

        g2 = new GradeBook(5);
        g2.addScore(80);
        g2.addScore(90);
        g2.addScore(73);
        
        g3 = new GradeBook(7);
        g3.addScore(g1.finalScore());
        g3.addScore(g2.sum());
    }

    @AfterEach
    public void tearDown() {
        g1 = null;
        g2 = null;
        g3 = null;
    }


	@Test
	void testAddScore() {
		assertTrue(g1.toString().equals("50.0 75.0 "));
        assertTrue(g2.toString().equals("80.0 90.0 73.0 "));
        assertEquals(2, g1.getScoreSize());
        assertEquals(3, g2.getScoreSize());   
	}
	
	@Test
	void testGetScoreSize() {
		assertEquals(2, g1.getScoreSize());
        assertEquals(3, g2.getScoreSize());	
	}

	@Test
	void testSum() {
		assertEquals(125.0, g1.sum(), 0.0001);
        assertEquals(243.0, g2.sum(), 0.0001);
	}

	@Test
	void testMinimum() {
		assertEquals(50.0, g1.minimum(), 0.001);
        assertEquals(73.0, g2.minimum(), 0.001);
	}

	@Test
	void testFinalScore() {
		assertEquals(75.0, g1.finalScore(), 0.001);
        assertEquals(170.0, g2.finalScore(), 0.001);
	}

	@Test
	void testToString() {
		assertTrue(g3.toString().equals("75.0 243.0 "));
	}

}
