package phurua.student.c3_qlsach;

import android.content.Context;
import android.content.DialogInterface;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import androidx.appcompat.app.AlertDialog;

import java.io.File;

public class LopChucNang {
    public static boolean checkDatabase()
    {
        SQLiteDatabase checkDB = null;
        try {
            checkDB = SQLiteDatabase.openDatabase("quanlysach.db",null, SQLiteDatabase.OPEN_READONLY);
            checkDB.close();
        }
        catch (SQLException e)
        {

        }
        return checkDB != null;
    }
    public static boolean checkDatabase(Context context, String dbName)
    {
        File dbFile = context.getDatabasePath(dbName);
        return dbFile.exists();
    }
    public static void showMessage(Context c , String mes, String title)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(c,android.R.style.Theme_DeviceDefault_Dialog_NoActionBar);
        builder.setMessage(mes);
        builder.setTitle(title);
        builder.setNegativeButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
