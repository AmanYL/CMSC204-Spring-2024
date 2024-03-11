import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;


import java.util.ListIterator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class SortedDoubleLinkedList_Student_Test {
	SortedDoubleLinkedList<String> sortedLinkedString;
	StringComparator comparator;
	

	@BeforeEach
	void setUp() throws Exception {
		comparator = new StringComparator();
		sortedLinkedString = new SortedDoubleLinkedList<String>(comparator);
	}

	@AfterEach
	void tearDown() throws Exception {
		comparator = null;
		sortedLinkedString = null;
	}

	@Test
	void testIteratorNext() {
		sortedLinkedString.add("EntotoArt");
		sortedLinkedString.add("BunaEnaTea");
		sortedLinkedString.add("Anbesa");
		sortedLinkedString.add("Samsung");
		ListIterator<String> iterator = sortedLinkedString.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals("Anbesa", iterator.next());
		assertEquals("BunaEnaTea", iterator.next());
		iterator.next();
		assertEquals(true, iterator.hasPrevious());
		assertEquals("EntotoArt", iterator.previous());
		assertEquals("BunaEnaTea", iterator.previous());
	}
	
	@Test
	public void testAddToEnd() {
		assertThrows(UnsupportedOperationException.class,()-> sortedLinkedString.addToEnd("Berkshire Hathaway"));
	}

	@Test
	public void testAddToFront() {
		assertThrows(UnsupportedOperationException.class,()-> sortedLinkedString.addToFront​("BridgewaterAssoiates"));
	}
	
	

}
