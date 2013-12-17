package se.arnelid.redo.test.robotium;

import com.jayway.android.robotium.solo.Solo;

import se.arnelid.redo.MainActivity;
import android.test.ActivityInstrumentationTestCase2;

public class MainActivityTest extends
		ActivityInstrumentationTestCase2<MainActivity> {

	public MainActivityTest() {
		super(MainActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testAddActivity() {
		Solo solo = new Solo(getInstrumentation(), getActivity());
		solo.clickOnButton("Add");
		solo.enterText(0, "A Task");
		solo.clickOnButton("OK");
		assertTrue(solo.searchText("A Task"));
	}

}
