package se.arnelid.redo;

import android.app.DialogFragment;

public interface DeleteTaskDialogInterface {
    public void onDialogPositiveClick(DialogFragment dialog, long id);
    public void onDialogNegativeClick(DialogFragment dialog);

}
