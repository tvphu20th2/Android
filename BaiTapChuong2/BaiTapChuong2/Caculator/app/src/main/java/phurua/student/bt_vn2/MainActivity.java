package phurua.student.bt_vn2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;
public class MainActivity extends AppCompatActivity {

    TextView txtKQ;
    EditText edittextnum1, edittextnum2;
    Button btnCong, btnTru, btnNhan, btnChia, btnExit, btnucln;
    String a, b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activty_main);

        //Gọi hàm ánh xạ
        functionBinding();

        btnCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a = edittextnum1.getText().toString().trim();
                b = edittextnum2.getText().toString().trim();
                if (a.isEmpty() || a.isEmpty()){
                    Toast.makeText(MainActivity.this, "Bạn phải nhập đầy đủ !!!", Toast.LENGTH_SHORT).show();
                }
                else {
                    int sum = Integer.parseInt(a) + Integer.parseInt(b);
                    txtKQ.setText(sum + "");
                }
            }
        });

        btnTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a = edittextnum1.getText().toString().trim();
                b = edittextnum2.getText().toString().trim();
                if (a.isEmpty() || a.isEmpty()){
                    Toast.makeText(MainActivity.this, "Bạn phải nhập đầy đủ !!!", Toast.LENGTH_SHORT).show();
                }
                else {
                    int sub = Integer.parseInt(a) - Integer.parseInt(b);
                    txtKQ.setText(sub + "");
                }
            }
        });

        btnNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a = edittextnum1.getText().toString().trim();
                b = edittextnum2.getText().toString().trim();
                if (a.isEmpty() || a.isEmpty()){
                    Toast.makeText(MainActivity.this, "Bạn phải nhập đầy đủ !!!", Toast.LENGTH_SHORT).show();
                }
                else {
                    int mul = Integer.parseInt(a) * Integer.parseInt(b);
                    txtKQ.setText(mul + "");
                }
            }
        });

        btnChia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a = edittextnum1.getText().toString().trim();
                b = edittextnum2.getText().toString().trim();
                if (a.isEmpty() || a.isEmpty()){
                    Toast.makeText(MainActivity.this, "Bạn phải nhập đầy đủ !!!", Toast.LENGTH_SHORT).show();
                }
                else {
                    float div = Integer.parseInt(a) / Integer.parseInt(b);
                    txtKQ.setText(div + "");
                }
            }
        });

        btnucln.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a = edittextnum1.getText().toString().trim();
                b = edittextnum2.getText().toString().trim();
                if (a.isEmpty() || a.isEmpty()){
                    Toast.makeText(MainActivity.this, "Bạn phải nhập đầy đủ !!!", Toast.LENGTH_SHORT).show();
                }
                else {
                    int num1 = Integer.parseInt(a), num2 = Integer.parseInt(b);
                    while (num1 != num2) {
                        if(num1 > num2)
                            num1 = num1 - num2;
                        else
                            num2 = num2 - num1;
                    }
                    txtKQ.setText(num2 + "");
                }
            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void functionBinding(){
        txtKQ = (TextView) findViewById(R.id.txtKQ);
        edittextnum1 = (EditText) findViewById(R.id.edittextnum1);
        edittextnum2 = (EditText) findViewById(R.id.edittextnum2);
        btnCong = (Button) findViewById(R.id.btnCong);
        btnTru = (Button) findViewById(R.id.btnTru);
        btnNhan = (Button) findViewById(R.id.btnNhan);
        btnChia = (Button) findViewById(R.id.btnChia);
        btnucln = (Button) findViewById(R.id.btnucln);
        btnExit = (Button) findViewById(R.id.btnExit);
    }
}
