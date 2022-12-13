package phurua.student.maytinhbotui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editTextNhap;
    TextView tvketqua;
    Button btnSo7, btnSo8, btnSo9, btnSo5, btnSo6, btnSo4, btnSo3, btnSo2, btnSo1, btnSo0,
            btnBang, btnCham, btnChia, btnxoa, btnNhan, btnCong, btnTru;
    int so1, so2;
    int pheptoan = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();


        //cài dat su kien cho button
        btnSo0.setOnClickListener(this);
        btnSo1.setOnClickListener(this);
        btnSo2.setOnClickListener(this);
        btnSo3.setOnClickListener(this);
        btnSo4.setOnClickListener(this);
        btnSo5.setOnClickListener(this);
        btnSo6.setOnClickListener(this);
        btnSo7.setOnClickListener(this);
        btnSo8.setOnClickListener(this);
        btnSo9.setOnClickListener(this);
        btnBang.setOnClickListener(this);
        btnCong.setOnClickListener(this);
        btnTru.setOnClickListener(this);
        btnNhan.setOnClickListener(this);
        btnChia.setOnClickListener(this);
        btnxoa.setOnClickListener(this);
        btnCham.setOnClickListener(this);


    }

    public void AnhXa() {
        editTextNhap = (EditText) findViewById(R.id.editTextNhap);
        tvketqua = (TextView) findViewById(R.id.txtKetQua);
        btnSo0 = (Button) findViewById(R.id.btn0);
        btnSo1 = (Button) findViewById(R.id.btn1);
        btnSo2 = (Button) findViewById(R.id.btn2);
        btnSo3 = (Button) findViewById(R.id.btn3);
        btnSo4 = (Button) findViewById(R.id.btn4);
        btnSo5 = (Button) findViewById(R.id.btn5);
        btnSo6 = (Button) findViewById(R.id.btn6);
        btnSo7 = (Button) findViewById(R.id.btn7);
        btnSo8 = (Button) findViewById(R.id.btn8);
        btnSo9 = (Button) findViewById(R.id.btn9);
        btnCham = (Button) findViewById(R.id.btnCham);
        btnBang = (Button) findViewById(R.id.btnBang);
        btnChia = (Button) findViewById(R.id.btnChia);
        btnxoa = (Button) findViewById(R.id.btnXoa);
        btnNhan = (Button) findViewById(R.id.btnNhan);
        btnCong = (Button) findViewById(R.id.btnCong);
        btnTru = (Button) findViewById(R.id.btnTru);

    }

    @Override
    public void onClick(View view) {

        if (view == btnCham)
        {
            if(editTextNhap.getText().length() >0)
                if(Character.isDigit(editTextNhap.getText().charAt(editTextNhap.getText().length()-1)) )
                    editTextNhap.setText(editTextNhap.getText()+".");

        }
        if (view == btnSo0)
        {
            String s = editTextNhap.getText().toString();
            editTextNhap.setText(s + "0");

            if (pheptoan == 0)
                so1 = so1 * 10 + 0;
            else
                so2 = so2 * 10 + 0;
        }
        if (view == btnSo1)
        {
            String s = editTextNhap.getText().toString();
            editTextNhap.setText(s + "1");

            if (pheptoan == 0)
                so1 = so1 * 10 + 1;
            else
                so2 = so2 * 10 + 1;
        }
        if (view == btnSo2)
        {
            String s = editTextNhap.getText().toString();
            editTextNhap.setText(s + "2");

            if (pheptoan == 0)
                so1 = so1 * 10 + 2;
            else
                so2 = so2 * 10 + 2;
        }
        if (view == btnSo3)
        {
            String s = editTextNhap.getText().toString();
            editTextNhap.setText(s + "3");

            if (pheptoan == 0)
                so1 = so1 * 10 + 3;
            else
                so2 = so2 * 10 + 3;
        }
        if (view == btnSo4)
        {
            String s = editTextNhap.getText().toString();
            editTextNhap.setText(s + "4");

            if (pheptoan == 0)
                so1 = so1 * 10 + 4;
            else
                so2 = so2 * 10 + 4;
        }if (view == btnSo5)
        {
            String s = editTextNhap.getText().toString();
            editTextNhap.setText(s + "5");

            if (pheptoan == 0)
                so1 = so1 * 10 + 5;
            else
                so2 = so2 * 10 + 5;
        }
        if (view == btnSo6)
        {
            String s = editTextNhap.getText().toString();
            editTextNhap.setText(s + "6");

            if (pheptoan == 0)
                so1 = so1 * 10 + 6;
            else
                so2 = so2 * 10 + 6;
        }
        if (view == btnSo7)
        {
            String s = editTextNhap.getText().toString();
            editTextNhap.setText(s + "7");

            if (pheptoan == 0)
                so1 = so1 * 10 + 7;
            else
                so2 = so2 * 10 + 7;
        }
        else if (view == btnSo8)
        {
            String s = editTextNhap.getText().toString();
            editTextNhap.setText(s + "8");

            if (pheptoan == 0)
                so1 = so1 * 10 + 8;
            else
                so2 = so2 * 10 + 8;
        } else if (view == btnSo9)
        {
            String s = editTextNhap.getText().toString();
            editTextNhap.setText(s + "9");
            if (pheptoan == 0)
                so1 = so1 * 10 + 9;
            else
                so2 = so2 * 10 + 9;
        }
        else if (view == btnBang)
        {
            if (pheptoan == 1)
            {
                int kq = (int) so1 + so2;
                tvketqua.setText(kq + "");
            }
            else if (pheptoan == 2)
            {
                int kq = (int) so1 - so2;
                tvketqua.setText(kq + "");
            }
            else if (pheptoan == 3)
            {
                int kq = (int) so1 * so2;
                tvketqua.setText(kq + "");
            }
            else if (pheptoan == 4)
            {
                float kq = (float) so1 / so2;
                tvketqua.setText(kq + "");
            }

        }
        else if (view == btnCong)
        {
            String s = editTextNhap.getText().toString();
            editTextNhap.setText(s + "+");
            pheptoan = 1;
        }
        else if (view == btnTru)
        {
            String s = editTextNhap.getText().toString();
            editTextNhap.setText(s + " - ");
            pheptoan = 2;
        }
        else if (view == btnNhan)
        {
            String s = editTextNhap.getText().toString();
            editTextNhap.setText(s + " x ");
            pheptoan = 3;
        }
        else if (view == btnChia)
        {
            String s = editTextNhap.getText().toString();
            editTextNhap.setText(s + ":");
            pheptoan = 4;
        }
        else if (view == btnxoa)
        {
            editTextNhap.setText("");
            tvketqua.setText("");
            so1 = 0;
            so2 = 0;
            pheptoan = 0;


        }
    }
}





