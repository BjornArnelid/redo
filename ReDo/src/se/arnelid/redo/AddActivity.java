package se.arnelid.redo;

import se.arnelid.redo.logic.Task;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.support.v4.app.NavUtils;
import android.widget.EditText;

public class AddActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void createTask(View view) {
		Intent intent = new Intent(AddActivity.this, MainActivity.class);
		EditText edit = (EditText) findViewById(R.id.task_text);
		CharSequence text = edit.getText();
		Task task = new Task(text.toString());
		intent.putExtra("Task", task);
		AddActivity.this.startActivity(intent);
	}

}
