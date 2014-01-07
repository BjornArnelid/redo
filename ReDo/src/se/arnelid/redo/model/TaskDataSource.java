package se.arnelid.redo.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class TaskDataSource {

	private RedoSQLiteHelper helper;
	private SQLiteDatabase database;
	
	public TaskDataSource(Context context) {
		helper = new RedoSQLiteHelper(context);
	}

	public void open() {
		database = helper.getWritableDatabase();
	}
	
	public void close() {
		helper.close();
	}
	
	public void createTask(String task) {
		ContentValues values = new ContentValues();
		values.put(RedoSQLiteHelper.NAME_COLUMN, task);
		database.insert(RedoSQLiteHelper.TASKS_TABLE, null, values);
	}

	public Cursor getCursor() {
		String[] allColumns = {RedoSQLiteHelper.ID_COLUMN, RedoSQLiteHelper.NAME_COLUMN };
		Cursor cursor = database.query(RedoSQLiteHelper.TASKS_TABLE, allColumns, null, null, null, null, null);
		return cursor;
	}

	public boolean removeTask(long id) {
		String clause = "_id = " + id;
		int result = database.delete(RedoSQLiteHelper.TASKS_TABLE, clause, null);
		if (result > 0) {
			return true;
		}
		return false;
	}
}
