package se.arnelid.redo.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class RedoSQLiteHelper extends SQLiteOpenHelper {

	public static final String TASKS_TABLE = "tasks";
	public static final String NAME_COLUMN = "name";
	public static final String ID_COLUMN = "_id";
	
	public RedoSQLiteHelper(Context context) {
		super(context, "tasks.db", null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase database) {
		String createDB = "create table " + TASKS_TABLE + 
				" (" + ID_COLUMN + " integer primary key autoincrement, " + 
				NAME_COLUMN + " text not null);";
		database.execSQL(createDB);
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}

}
