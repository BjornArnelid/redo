package se.arnelid.redo;

import se.arnelid.redo.model.RedoSQLiteHelper;
import se.arnelid.redo.model.TaskDataSource;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends Activity {

	private TaskDataSource datasource;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		datasource = new TaskDataSource(this);
		datasource.open();
		
		String[] from = {RedoSQLiteHelper.NAME_COLUMN};
		int[] to = {android.R.id.text1};
		Cursor cursor = datasource.getCursor();
		
		ListAdapter adapter = new SimpleCursorAdapter(this,
				android.R.layout.simple_list_item_1, cursor, from, to, 0);
		
		ListView listView = (ListView) findViewById(R.id.task_list);
		listView.setOnItemLongClickListener(new DeleteListener(this));
		listView.setAdapter(adapter);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void clickAdd(View view) {
		Intent intent = new Intent(MainActivity.this, AddActivity.class);
		MainActivity.this.startActivity(intent);
	}
}
