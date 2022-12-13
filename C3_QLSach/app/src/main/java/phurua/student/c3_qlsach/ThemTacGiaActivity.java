package phurua.student.c3_qlsach;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ThemTacGiaActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnXoa , btnLuu;
    EditText editMaTG , editTenTG;
    SQLiteDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_tac_gia);

        btnLuu = findViewById(R.id.btnLuuTacGia);
        btnXoa = findViewById(R.id.btnXoaTG_Them );
        editMaTG = findViewById(R.id.editTextMaTacGia_Them);
        editTenTG = findViewById(R.id.editTextTenTG_Them);

        btnLuu.setOnClickListener(this);
        btnXoa.setOnClickListener(this);

        try
        {
            database = openOrCreateDatabase("quanlysach.db",MODE_PRIVATE,null);

        }
        catch (SQLException e)
        {

        }
    }

    @Override
    public void onStop() {
        super.onStop();
        database.close();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.them_tac_gia,menu);
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnXoaTG_Them:
                xoaTrang();
                break;
            case R.id.btnLuuTacGia:
                if(editMaTG.getText().toString().trim().equals(""))
                    LopChucNang.showMessage(this,"Bạn phải nhập mã tác giảm","Lỗi");
                else if(editTenTG.getText().toString().equals(""))
                    LopChucNang.showMessage(this,"Bạn phải nhập tên tác giả ", "Lỗi");
                else
                {
                    ContentValues values = new ContentValues();
                    values.put("matacgia",editMaTG.getText().toString());
                    values.put("tentacgia",editTenTG.getText().toString());
                    String msg;
                    if(database.insert("tacgia",null,values)==1)
                        msg = "thêm không thành công. Trùng khóa chính";
                    else
                        msg ="Thêm mới tác giả thành công";
                    Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
                    xoaTrang();
                }


               
                break;
        }
    }

    private void xoaTrang() {
        editMaTG.setText(null);
        editTenTG.setText(null);
        editMaTG.setFocusable(true);
    }
}