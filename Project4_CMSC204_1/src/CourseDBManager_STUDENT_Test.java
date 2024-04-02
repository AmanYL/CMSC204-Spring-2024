import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CourseDBManager_STUDENT_Test {
	private CourseDBManagerInterface dataMgr;

    @BeforeEach
    public void setUp() throws Exception {
        dataMgr = new CourseDBManager();
    }

    @After
    public void tearDown() throws Exception {
        dataMgr = null;
    }

    @Test
    public void testAddAndRetrieveCourse() {
        dataMgr.add("MATH101", 12345, 3, "Room A", "Prof. Smith");
        CourseDBElement course = dataMgr.get(12345);
        assertNotNull(course);
        assertEquals("MATH101", course.getID());
        assertEquals(12345, course.getCRN());
        assertEquals(3, course.getCredits());
        assertEquals("Room A", course.getRoomNum());
        assertEquals("Prof. Smith", course.getInstructorName());
    }

    @Test
    public void testReadFile() {
        File inputFile = new File("the_courses.txt");
        assertThrows(FileNotFoundException.class, ()-> dataMgr.readFile(inputFile));
    }

    @Test
    public void testShowAll() {
        dataMgr.add("CHEM201", 54321, 4, "Room B", "Dr. Johnson");
        dataMgr.add("PHYS301", 67890, 4, "Room C", "Dr. Anderson");
        ArrayList<String> courses = dataMgr.showAll();
        assertTrue(courses.contains("\nCourse:CHEM201 CRN:54321 Credits:4 Instructor:Dr. Johnson Room:Room B"));
        assertTrue(courses.contains("\nCourse:PHYS301 CRN:67890 Credits:4 Instructor:Dr. Anderson Room:Room C"));
    }
}
