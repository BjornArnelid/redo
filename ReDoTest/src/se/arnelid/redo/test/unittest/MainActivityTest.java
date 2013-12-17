package se.arnelid.redo.test.unittest;

import se.arnelid.redo.MainActivity;
import android.content.Intent;
import android.test.ActivityUnitTestCase;
import android.widget.Button;
import android.widget.ListView;

public class MainActivityTest extends ActivityUnitTestCase<MainActivity> {
	private Button add;
	private ListView list;

	public MainActivityTest() {
		super(MainActivity.class);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		Intent intent = new Intent(getInstrumentation().getTargetContext(),
				MainActivity.class);
		startActivity(intent, null, null);
		MainActivity activity = getActivity();
		activity.setContentView(se.arnelid.redo.R.layout.activity_main);
		
		int buttonid = se.arnelid.redo.R.id.add_button;
		add = (Button) activity.findViewById(buttonid);
		int listid = se.arnelid.redo.R.id.task_list;
		list = (ListView) activity.findViewById(listid);
	}

	public void testAddButtonCaption() {
		assertEquals("Add", add.getText());
	}

	public void testPressAdd() {
		add.performClick();
		Intent triggered = getStartedActivityIntent();
		assertNotNull(triggered);
	}
	
	// TODO Is this test really valid?
	public void testListisEmpty() {
		assertEquals(0, list.getCount());
	}
}
