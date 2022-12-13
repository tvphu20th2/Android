package phurua.student.chuyendoilich;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String [] can = {"Canh","Tân", "Nhâm" ,"Quý", "Giáp"
            ,"Ất" ,"Bính","Đinh","Mậu","Kỷ"};
    String [] chi = {"Thân","Dậu", "Tuất" ,"Hợi", "Tý"
            ,"Sửu" ,"Dần","Mão","Thìn","Tỵ", "Ngọ","Mùi"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        EditText editTextDL = (EditText) findViewById(R.id.editTextNamdl);
        Button btnChange = (Button) findViewById(R.id.btnChuyenDoi);
        TextView txtAL = (TextView) findViewById(R.id.txtNamAL);

        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( v==btnChange)
                {
                    int nam = Integer.parseInt(editTextDL.getText().toString());
                    txtAL.setText(can[nam%10]+" "+chi[nam%12]);
                }
            }
        });

    }


}