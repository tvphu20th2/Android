package phurua.student.c3_qlsach;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class DSTacGiaActivity extends AppCompatActivity {

    public static final int EDIT_AUTHOR =113;
    public static final int SAVE_EDIT_AUTHOR =114;
    SQLiteDatabase database;
    int selectedPosition;
    ArrayList<TacGia> arr;
    TacGiaArrayAdapter arrayAdapter;
    ListView lvDSTG;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xemds_tacgia);

        try {
            database= openOrCreateDatabase("quanlysach.db",MODE_PRIVATE,null);
        }
        catch (Exception e)
        {

        }

        lvDSTG = findViewById(R.id.lvDSTG);
        arr = new ArrayList<TacGia>();
        napDanhSachTacGia();
        arrayAdapter = new TacGiaArrayAdapter(this,arr);
        lvDSTG.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Intent capnhatTG = new Intent(DSTacGiaActivity.this, CapNhatTacGiaActivity.class);
                Bundle b = new Bundle();
                selectedPosition = position;
                b.putSerializable("tacgia",arr.get(position));
                capnhatTG.putExtra("DATA",b);
                startActivityForResult(capnhatTG,EDIT_AUTHOR);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        }) ;


       lvDSTG.setLongClickable(true);
        lvDSTG.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
                selectedPosition = position;
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext(),android.R.style.Theme_DeviceDefault_Dialog_NoActionBar);
                builder.setMessage("Xóa["+arr.get(position).getMaTG()+"-"+ arr.get(position).getTenTG()+"]");
                builder.setTitle("Thông Báo");
                builder.setPositiveButton("có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String maTG = arr.get(selectedPosition).getMaTG();
                        database.delete("tacgia","matacgia=?",new String[]{maTG});
                        arr.remove(selectedPosition);

                        arrayAdapter.notifyDataSetChanged();
                        Toast.makeText(v.getContext(),"Xóa tác giả thành công",Toast.LENGTH_LONG).show();
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case EDIT_AUTHOR:
                if(resultCode==SAVE_EDIT_AUTHOR)
                {
                    Bundle b = data.getBundleExtra("DATA");
                    TacGia tg = (TacGia) b.getSerializable("tacgia");
                    arr.set(selectedPosition,tg);
                    arrayAdapter.notifyDataSetChanged();
                }
                break;
        }
    }
    private void napDanhSachTacGia()
    {
        arr.clear();
        Cursor cursor = database.query("tacgia",null,null,null,null,null,null);
        TacGia tg;
        if(cursor.moveToFirst())
        {
            do{
                tg = new TacGia(cursor.getString(0),cursor.getString(1));
            }while (cursor.moveToNext());
        }
    }
}