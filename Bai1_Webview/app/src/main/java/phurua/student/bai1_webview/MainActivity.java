package phurua.student.bai1_webview;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import java.util.ArrayList;

public class MainActivity extends Activity {
    ListView lv;
    ArrayList<DiaDiem>  diaDiemArrayList= new ArrayList<DiaDiem>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         lv =  findViewById(R.id.list_diadiem);

        diaDiemArrayList.add(new DiaDiem("Hà Tiên","hatien.html"));
        diaDiemArrayList.add(new DiaDiem("Núi Cấm","nuicam.html"));
        diaDiemArrayList.add(new DiaDiem("Tràm Chim","tramchim.html"));
        diaDiemArrayList.add(new DiaDiem("Hòn Đất","hondat.html"));
        diaDiemArrayList.add(new DiaDiem("U Minh","uminh.html"));
        diaDiemArrayList.add(new DiaDiem("Búng Bình Thiên","bungbinhthien.html"));


        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,diaDiemArrayList);
        lv.setAdapter(adapter);

        lv.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View arg1, int arg2,  long arg3) {

                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("diadiem", diaDiemArrayList.get(arg2));

                intent.putExtra("data",bundle);
                startActivity(intent);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }
        });





    }
}