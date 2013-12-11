package se.arnelid.redo.test;

import se.arnelid.redo.MainActivity;
import android.content.Intent;
import android.test.ActivityUnitTestCase;
import android.widget.Button;

public class MainActivityUnitTest extends ActivityUnitTestCase<MainActivity> {
	private Button add;

	public MainActivityUnitTest() {
		super(MainActivity.class);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		Intent intent = new Intent(getInstrumentation().getTargetContext(),
				MainActivity.class);
		startActivity(intent, null, null);
		MainActivity activity = getActivity();
		activity.setContentView(se.arnelid.redo.R.layout.fragment_main_overview);
		int buttonid = se.arnelid.redo.R.id.add_button;
		add = (Button) activity.findViewById(buttonid);
	}

	public void testAddButtonCaption() {
		assertEquals("Add", add.getText());
	}

	public void testPressAdd() {
		add.performClick();
		Intent triggered = getStartedActivityIntent();
		assertNotNull(triggered);
	}
}
