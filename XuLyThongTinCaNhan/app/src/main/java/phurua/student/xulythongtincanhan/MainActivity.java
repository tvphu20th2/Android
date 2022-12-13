package phurua.student.xulythongtincanhan;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    EditText hoten,cmnd,thongtinbosung;
    CheckBox docbao,docsach,doccode;
    Button btnGoiThongTin;
    RadioButton DH , CD , TC;
    RadioGroup bangcap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hoten=(EditText)findViewById(R.id.editName);
        cmnd=(EditText)findViewById(R.id.editCMND);
        thongtinbosung=(EditText)findViewById(R.id.editThongtinbosung);

        docbao=(CheckBox)findViewById(R.id.chkBao);
        docsach=(CheckBox)findViewById(R.id.chkSach);
        doccode=(CheckBox)findViewById(R.id.chkCode);
        bangcap=(RadioGroup)findViewById(R.id.radBangcap);

       // TC = (RadioButton)findViewById(R.id.radTC);
        //CD = (RadioButton)findViewById(R.id.radCD);
       // DH = (RadioButton)findViewById(R.id.radDH);


        btnGoiThongTin=(Button)findViewById(R.id.btnSubmit);

        btnGoiThongTin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s=hoten.getText()+"\n";
                s+=cmnd.getText()+"\n";
                int id=bangcap.getCheckedRadioButtonId();
                switch(id)
                {
                    case R.id.radTC:
                        s+="Trung cấp\n";
                        break;
                    case R.id.radCD:
                        s+="Cao đẳng\n";
                        break;
                    case R.id.radDH:
                        s+="Đại học\n";
                        break;
                }


                if(docbao.isChecked())
                    s+="Đọc báo -";
                if(docsach.isChecked())
                    s+="Đọc sách -";
                if(doccode.isChecked())
                    s+="Đọc coding";
                s+="\n-----------------------------------------------\n";
                s+="Thông tin bổ sung:\n";
                s+=thongtinbosung.getText();
                s+="\n-----------------------------------------------\n";
                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this, androidx.constraintlayout.widget.R.style.Base_V7_Theme_AppCompat_Dialog);

                builder.setMessage(s);
                builder.setTitle("Thông tin cá nhân");
                builder.setIcon(android.R.drawable.ic_dialog_alert);
                builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int arg0) {


                    }
                });
                AlertDialog dialog=builder.create();
                dialog.show();
            }
        });
    }

}

