package se.arnelid.redo.test;

import se.arnelid.redo.logic.Task;
import junit.framework.TestCase;

public class TaskUnitTest extends TestCase {
	
	public void testTaskEquals() {
		Task t1 = new Task("A Task");
		Task t2 = new Task("A Task");
		assertEquals(t1, t2);
	}

}
