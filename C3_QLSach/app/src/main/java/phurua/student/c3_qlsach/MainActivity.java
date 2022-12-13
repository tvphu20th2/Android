package phurua.student.c3_qlsach;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnThemTG , btnQltg, btnQlS;
    SQLiteDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnThemTG = findViewById(R.id.btnThemTacGia);
        btnQltg = findViewById(R.id.btnXemDSTG);
        btnQlS = findViewById(R.id.btnQLSach);

        try {
            if (LopChucNang.checkDatabase(this, "quanlysach.db") == false) {

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        btnThemTG.setOnClickListener(this );
        btnQltg.setOnClickListener(this );
        btnQlS.setOnClickListener( this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnThemTacGia:
                Intent themTG = new Intent(this, ThemTacGiaActivity.class);
                startActivity(themTG);
                break;
            case R.id.btnXemDSTG:
                Intent quanlylTG = new Intent(this, DSTacGiaActivity.class);
                startActivity(quanlylTG);
                break;
            case R.id.btnQLSach:
                Intent qlSach = new Intent(this, QuanLySachActivity.class);
                startActivity(qlSach);
                break;
        }
    }
}