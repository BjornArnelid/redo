package se.arnelid.redo;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

public class DeleteTaskDialog extends DialogFragment {
	DeleteTaskDialogInterface listener;
	
	private long taskID;
	
	public DeleteTaskDialog() {
		super();
	}
	
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		super.onCreateDialog(savedInstanceState);
		taskID = getArguments().getLong("taskID");
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		builder.setMessage("Delete Task?");
		builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
               listener.onDialogPositiveClick(DeleteTaskDialog.this, taskID);
            }
        });
		builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
            	listener.onDialogNegativeClick(DeleteTaskDialog.this);
            }
        });
		return builder.create();
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		
		listener = (DeleteTaskDialogInterface) activity;
	}
}
