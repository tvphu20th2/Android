package phurua.student.qlbaihat;

import android.app.Activity;
import android.os.Bundle;


import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BaiHatActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnChonNgay,btnThembaiHat;
    EditText etNgayPhatHanh,etTenbaiHat;
    Spinner spinnerAlbum;
    ListView lvBaiHat;

    ArrayList<BaiHat> listBaihat=new ArrayList<>();
    ArrayList<Album> albumList;
    BaiHatAdapter adapterbaihat;

    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baihat);
        btnChonNgay=(Button) findViewById(R.id.buttonChonNgay);
        btnThembaiHat=(Button)findViewById(R.id.buttonThemBaiHat);
        etTenbaiHat=(EditText)findViewById(R.id.editTextTenBaiHat);
        etNgayPhatHanh=(EditText)findViewById(R.id.editDateNgayPhatHanh);
        btnChonNgay.setOnClickListener(this);
        btnThembaiHat.setOnClickListener(this);

        //spinner Album
        Intent intent=getIntent();
        Bundle bundle=intent.getBundleExtra("DATA");
        albumList=(ArrayList<Album>)bundle.getSerializable("list");

        spinnerAlbum=(Spinner) findViewById(R.id.spinnerAlbum);
        ArrayAdapter<Album> adapterAlbum=new ArrayAdapter<Album>(
                this, android.R.layout.simple_spinner_item,albumList
        );
        adapterAlbum.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spinnerAlbum.setAdapter(adapterAlbum);

        //listview bai hat
        lvBaiHat=(ListView)findViewById(R.id.lvbaihat);
        adapterbaihat=new BaiHatAdapter(this,listBaihat);
        lvBaiHat.setAdapter(adapterbaihat);


    }

    @Override
    public void onClick(View view) {
        if(view==btnChonNgay)
        {
            Date currentTime = Calendar.getInstance().getTime();

            DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {

                @Override
                public void onDateSet(DatePicker view, int year,
                                      int monthOfYear, int dayOfMonth) {

                    etNgayPhatHanh.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                }
            };

            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    android.R.style.Theme_Holo_Light_Dialog_NoActionBar,
                    dateSetListener, 1900+currentTime.getYear(), currentTime.getMonth(), currentTime.getDate());

            datePickerDialog.show();
        }
        else if(view==btnThembaiHat)
        {
            Album album=albumList.get(spinnerAlbum.getSelectedItemPosition());
            try {
                listBaihat.add(new BaiHat(album.getMaalbum(),
                        etTenbaiHat.getText().toString(),
                        new SimpleDateFormat("dd-MM-yyyy").parse(etNgayPhatHanh.getText().toString())));
            } catch (ParseException e) {
                e.printStackTrace();
            }

            adapterbaihat.notifyDataSetChanged();

        }

    }
}
