package se.arnelid.redo.test.unittest;

import se.arnelid.redo.model.Task;
import junit.framework.TestCase;

public class TaskTest extends TestCase {
	Task t1;
	
	protected void setUp() {
		t1 = new Task("A Task");
	}
	
	public void testTaskEquals() {
		Task t2 = new Task("A Task");
		assertEquals(t1, t2);
	}

	public void testNotEqualsWrongClass() {
		String t2 = "A Task";
		assertFalse(t1.equals(t2));
	}
	
	public void testGetName() {
		assertEquals("A Task", t1.getName());
	}
	
	public void testSetName() {
		t1.setName("Another name");
		assertEquals("Another name", t1.getName());
	}
	
	public void testTaskNotEquals() {
		Task t2 = new Task("Another Task");
		assertFalse(t1.equals(t2));
	}
	
	public void testToString() {
		assertEquals("A Task", t1.toString());
	}
}
