package phurua.student.alert_dialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;

import android.view.View;

import android.widget.Button;
import android.widget.CheckBox;

import android.widget.EditText;

import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    EditText editUser,editPassword;
    Button btnLogin,btnExit;
    CheckBox checkBoxLuu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Control();

        AnhXa();

    }

    private void AnhXa() {
        editUser =findViewById(R.id.edittextuser);
        editPassword =findViewById(R.id.edittextpassword);
        btnLogin =findViewById(R.id.btnLogin);
        btnExit = findViewById(R.id.btnExit);
        checkBoxLuu = findViewById(R.id.chkLuu);

    }

    private void Control() {
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this, android.R.style.Theme_DeviceDefault_Dialog_NoActionBar);
                builder.setTitle("Thông Báo");
                builder.setIcon(android.R.drawable.ic_dialog_info);
                builder.setMessage("Bạn có chắc chắn muốn thoát");
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        MainActivity.this.finish();

                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {


                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(checkBoxLuu.isChecked()){
                    Toast.makeText(MainActivity.this,"chào mừng bạn đăng nhập hệ thống, bạn đã lưu thông tin"
                            ,Toast.LENGTH_SHORT).show();

                }
                else {
                    Toast.makeText(MainActivity.this,"chào mừng bạn đăng nhập hệ thống, bạn không lưu thông tin"
                            ,Toast.LENGTH_SHORT).show();
                }

            }

        });
    }





}