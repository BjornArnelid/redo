package se.arnelid.redo.test.unittest;

import se.arnelid.redo.logic.RepeatingTask;
import android.text.format.Time;
import junit.framework.TestCase;

public class RepeatingTaskTest extends TestCase {
	
	public void testGetInterval() {
		RepeatingTask task = new RepeatingTask();
		task.setInterval(1, Time.WEEK_DAY);
		assertEquals(1,task.getIntervalValue());
		assertEquals(Time.WEEK_DAY, task.getIntervalType());
	}
}
