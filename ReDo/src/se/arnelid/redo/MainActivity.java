package se.arnelid.redo;

import java.util.ArrayList;

import se.arnelid.redo.logic.Task;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ArrayList<Task> tasks = new ArrayList<Task>();
		
		ArrayAdapter<Task> adapter = new ArrayAdapter<Task>(this, android.R.layout.simple_list_item_1, tasks);
		
		ListView listView = (ListView) findViewById(R.id.task_list);
		listView.setAdapter(adapter);
		Intent i = getIntent();
		Task t = (Task) i.getSerializableExtra("Task");
		if(t != null) {
			tasks.add(t);
		}
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
