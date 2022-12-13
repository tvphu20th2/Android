package phurua.student.c3_qlsach;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CapNhatTacGiaActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editMaTG, editTenTG;
    Button btnXoa, btnCapNhat;
    SQLiteDatabase database;
    TacGia tg;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capnhat_tacgia);


        try
        {
            database = openOrCreateDatabase("quanlysach.db",MODE_PRIVATE,null);

        }
        catch (SQLException e)
        {

        }
       btnCapNhat = findViewById(R.id.btnUpdate);
        btnXoa = findViewById(R.id.btnXoa_Sua );
        editMaTG = findViewById(R.id.editTextMaTG_Sua);
        editTenTG = findViewById(R.id.editTextTenTG_Sua);

        btnCapNhat.setOnClickListener(this);
        btnXoa.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnXoa_Sua:
                xoaTrang();
                break;
            case R.id.btnUpdate:
                if (editMaTG.getText().toString().trim().equals(""))
                    LopChucNang
                            .showMessage(this, "Bạn phải nhập mã tác giả", "Lỗi");
                else if (editTenTG.getText().toString().trim().equals(""))
                    LopChucNang.showMessage(this, "Bạn phải nhập tên tác giả",
                            "Lỗi");
                else {
                    ContentValues values = new ContentValues();
                    values.put("matacgia", editMaTG.getText().toString());
                    values.put("tentacgia", editTenTG.getText().toString());
                    String msg;
                    int ret = database.update("tacgia", values, "matacgia=?",
                            new String[] { tg.getMaTG() });
                    if (ret == 0) {
                        msg = "Cập nhật không thành công. Trùng khóa chính";
                        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
                    } else {
                        msg = "Cập nhật tác giả thành công";
                        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
                        tg.setMaTG(editMaTG.getText().toString());
                        tg.setTenTG(editTenTG.getText().toString());
                        setResult(DSTacGiaActivity.SAVE_EDIT_AUTHOR, intent);
                        finish();
                    }
// finish();
// xoaTrang();
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