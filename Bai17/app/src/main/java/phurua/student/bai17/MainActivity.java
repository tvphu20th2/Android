package phurua.student.bai17;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView selection;
    ListView listView;
    EditText hoten;
    Button nhap;
    ArrayList<String> arr = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        selection = (TextView) findViewById(R.id.textView);
        listView =(ListView) findViewById(R.id.listview);
        hoten = (EditText) findViewById(R.id.editTextTextPersonName);
        nhap = (Button) findViewById(R.id.btnNhap);

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
            android.R.layout.simple_expandable_list_item_1, arr    );
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selection.setText("position" +position+"; value = "+arr.get(position));
            }
        });
        nhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arr.add(hoten.getText()+"");
                hoten.setText("");
                hoten.requestFocus();
                adapter.notifyDataSetChanged();
            }
        });
    }
}