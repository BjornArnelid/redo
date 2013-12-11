package se.arnelid.redo.test;

import se.arnelid.redo.MainActivity;
import android.content.Intent;
import android.test.ActivityUnitTestCase;

public class MainActivityUnitTest extends ActivityUnitTestCase<MainActivity> {
	
	private MainActivity activity;

	public MainActivityUnitTest() {
	    super(MainActivity.class);
	  }
	
	  @Override
	  protected void setUp() throws Exception {
	    super.setUp();
	    Intent intent = new Intent(getInstrumentation().getTargetContext(),
	        MainActivity.class);
	    startActivity(intent, null, null);
	    activity = getActivity();
	  }
	
	public void testPressAdd() {
		fail(); 
	}
}
