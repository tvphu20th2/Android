package phurua.student.chuyendoi_doc_dof;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editTextDoC, editTextDoF;
    Button btnchuyendoF, btnchuyendoC, btnClear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ánh xạ
        editTextDoC =(EditText) findViewById(R.id.editTextC);
        editTextDoF =(EditText) findViewById(R.id.editTextF);
        btnchuyendoF = (Button) findViewById(R.id.btnChuyenDoF);
        btnchuyendoC = (Button) findViewById(R.id.btnChuyenDoC);
        btnClear = (Button) findViewById(R.id.btnClear);


        // lập trình sự kiện
        btnchuyendoC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               float f = Float.parseFloat(editTextDoF.getText()+"");
               float c = (f-32)*5/9;
               editTextDoC.setText(c+"");

            }
        });
        btnchuyendoF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float c = Float.parseFloat(editTextDoC.getText()+"");
                float f = c*9/5+32;
                editTextDoF.setText(f+"");

            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTextDoC.setText("");
                editTextDoF.setText("");

            }
        });
    }


}