package se.arnelid.redo;

import se.arnelid.redo.model.TaskDataSource;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;

public class DeleteListener implements OnItemLongClickListener  {

	private TaskDataSource dataSource;
	private Activity activity;
	
	public DeleteListener(Activity parent) {
		activity = parent;
		dataSource = new TaskDataSource(activity);
		dataSource.open();
	}
	
	@Override
	public boolean onItemLongClick(AdapterView<?> listView, View view,
			int index, long id) {
		DeleteTaskDialog d = new DeleteTaskDialog();
		Bundle bundle = new Bundle();
		bundle.putLong("taskID", id);
		d.setArguments(bundle);
		d.show(activity.getFragmentManager(), "DeleteDialogFragment");
		return true;
	}

}
