package se.arnelid.redo;

import se.arnelid.redo.model.TaskDataSource;
import android.app.Activity;
import android.database.Cursor;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.SimpleCursorAdapter;

public class DeleteListener implements OnItemLongClickListener {

	private TaskDataSource dataSource;
	
	public DeleteListener(Activity parent) {
		dataSource = new TaskDataSource(parent);
		dataSource.open();
	}
	
	@Override
	public boolean onItemLongClick(AdapterView<?> listView, View view,
			int index, long id) {
		// Ask for permission
		boolean result = dataSource.removeTask(id);
		SimpleCursorAdapter adapter = (SimpleCursorAdapter)listView.getAdapter();
		Cursor cursor = dataSource.getCursor();
		adapter.changeCursor(cursor);
		return result;
	}

}
