package phurua.student.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ImageActivity extends AppCompatActivity {

    ArrayList<String> arrayList;
    TableLayout myTable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        myTable = (TableLayout) findViewById(R.id.tableLayout);

        int dong = 6;
        int cot =3;

        //Trộn Mảng
        Collections.shuffle(MainActivity.arrayList);

        // tạo dòng và cột
        for (int i = 1 ;i <= dong;i++)
        {
            TableRow tableRow = new TableRow(this);

            //tạo cột -> ImageView
            for (int j = 1;j <= cot; j++){
                ImageView imageView = new ImageView(this);
                TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(200,200);
                imageView.setLayoutParams(layoutParams);

                int vitri = cot * ( i - 1) + j - 1;

                int idHinh = getResources().getIdentifier(MainActivity.arrayList.get(0),
                        "drawable",getPackageName());
                imageView.setImageResource(idHinh);
                // add image vào tablerow
                tableRow.addView(imageView);
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent();
                        intent.putExtra("tenhinhchon",MainActivity.arrayList.get(vitri));
                        setResult(RESULT_OK,intent);
                        finish();
                    }
                });

            }
            // add tablerow vào table
            myTable.addView(tableRow);
        }
    }
}