package se.arnelid.redo.test.robotium;

import com.jayway.android.robotium.solo.Solo;

import se.arnelid.redo.MainActivity;
import android.test.ActivityInstrumentationTestCase2;

public class MainActivityTest extends
		ActivityInstrumentationTestCase2<MainActivity> {

	private Solo solo;

	public MainActivityTest() {
		super(MainActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		solo = new Solo(getInstrumentation(), getActivity());
		solo.assertCurrentActivity("wrong activity", MainActivity.class);
		addActivity("A Task");
	}
	
	protected void tearDown() throws Exception {
		removeActivity("A Task");
		solo.finishOpenedActivities();
		super.tearDown();

	}

	private void addActivity(String taskName) {
		solo.clickOnButton("Add");
		solo.enterText(0, taskName);
		solo.clickOnButton("OK");
	}
	
	private void removeActivity(String string) {
		if(solo.searchText(string)) {
			solo.clickLongOnText(string);
			solo.clickOnButton("OK");
		}
	}

	public void testAddActivity() {
		assertTrue(solo.searchText("A Task"));
	}
	
	public void testAdd2Activities() {
		addActivity("Another Task");
		assertTrue(solo.searchText("A Task"));
		assertTrue(solo.searchText("Another Task"));
		removeActivity("Another Task");
	}
	
	public void testRemoveActivity() {
		removeActivity("A Task");
		assertFalse(solo.searchText("A Task"));
	}
}
