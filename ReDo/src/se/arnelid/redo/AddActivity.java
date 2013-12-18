package se.arnelid.redo;

import se.arnelid.redo.model.TaskDataSource;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class AddActivity extends Activity {

	private TaskDataSource datasource;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add);
		
		datasource = new TaskDataSource(this);
		datasource.open();
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
		EditText edit = (EditText) findViewById(R.id.task_text);
		CharSequence text = edit.getText();
		datasource.createTask(text.toString());

		Intent intent = new Intent(AddActivity.this, MainActivity.class);
		AddActivity.this.startActivity(intent);
	}

}
