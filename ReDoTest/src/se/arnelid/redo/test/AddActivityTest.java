package se.arnelid.redo.test;

import se.arnelid.redo.AddActivity;
import se.arnelid.redo.logic.Task;
import android.content.Intent;
import android.test.ActivityUnitTestCase;
import android.widget.Button;
import android.widget.EditText;

public class AddActivityTest extends ActivityUnitTestCase<AddActivity> {
	private Button ok;
	AddActivity activity;
	
	public AddActivityTest() {
		super(AddActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		Intent intent = new Intent(getInstrumentation().getTargetContext(),
				AddActivity.class);
		startActivity(intent, null, null);
		activity = getActivity();
		activity.setContentView(se.arnelid.redo.R.layout.activity_add);
		int buttonid = se.arnelid.redo.R.id.ok_button;
		ok = (Button) activity.findViewById(buttonid);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testOKButtonCaption() {
		assertEquals("Ok", ok.getText());
	}
	
	public void testPressOk() {
		int taskid = se.arnelid.redo.R.id.task_text;
		EditText task = (EditText) activity.findViewById(taskid);
		task.setText("A Task");
		ok.performClick();
		Task t = new Task("A Task");
		Intent triggered = getStartedActivityIntent();
		assertEquals(t, triggered.getExtras().get("Task"));
	}
}