import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NotationGFATests {
	public MyQueue<String> stringQ;
	public MyStack<String> stringS;
	
	@BeforeEach
	void setUp() throws Exception {
		stringQ = new MyQueue<String>(5);
		stringQ.enqueue("a");
		stringS = new MyStack<String>(2);
		stringS.push("a");
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	 
	@Test
	public void testIsEmptyQueue() throws QueueUnderflowException {
		assertEquals(false,stringQ.isEmpty());
		stringQ.dequeue();
		assertEquals(true, stringQ.isEmpty());
	}
	@Test
	public void testDequeue() {
		try {
			assertEquals("a", stringQ.dequeue());
			 
			//Queue is empty, next statement should cause QueueUnderFlowException
			stringQ.dequeue();
			assertTrue(false, "This should have caused an QueueUnderflowException");
		}
		catch (QueueUnderflowException e){
			assertTrue(true, "This should have caused an QueueUnderflowException");
		}
		catch (Exception e){
			assertTrue(false, "This should have caused an QueueUnderflowException");
		}
	}
	
	@Test
	public void testIsEmptyStack() throws StackUnderflowException {
		assertEquals(false,stringS.isEmpty());
		stringS.pop();
		assertEquals(true, stringS.isEmpty());
	}

	@Test
	public void testIsFull() throws StackOverflowException {
		assertEquals(false, stringS.isFull());
		stringS.push("b");
		assertEquals(true, stringS.isFull());
	}


}
