package phurua.student.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    static ArrayList<String> arrayList;
    ImageView imageGoc , imageNhan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageGoc = findViewById(R.id.imageViewGoc);
        imageNhan =  findViewById(R.id.imageViewNhan);

        String [] mangTen = getResources().getStringArray(R.array.list_name);
        arrayList = new ArrayList<>(Arrays.asList(mangTen));

        // Trộn mảng
        Collections.shuffle(arrayList);

        int idhinh = getResources().getIdentifier(arrayList.get(5),"drawable",getPackageName());

        imageGoc.setImageResource(idhinh);

        imageNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ImageActivity.class));
            }
        });
    }
}