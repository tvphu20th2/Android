package phurua.student.danhmucsanpham;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Spinner danhmuc;
    ListView danhsach;
    ArrayList<String> arrDanhMuc=new ArrayList<String>();
    ArrayList<SanPham> arrSanPham=new ArrayList<SanPham>();
    ArrayList<String> arr=new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        danhmuc= (Spinner) findViewById(R.id.spinerDM);
        danhsach=(ListView) findViewById(R.id.lvsanpham);

        arrDanhMuc.add("Điện thoại");
        arrDanhMuc.add("Máy tính");
        arrDanhMuc.add("Đồng hồ");
        arrSanPham.add(new SanPham ("Nokia 1100", "Điện thoại"));
        arrSanPham.add(new SanPham ("Iphone 5", "Điện thoại"));
        arrSanPham.add(new SanPham("HTC desired", "Điện thoại"));
        arrSanPham.add(new SanPham("Samsung V2", "Điện thoại"));
        arrSanPham.add(new SanPham ("Dell 1640", "Máy tính"));
        arrSanPham.add(new SanPham ("HP Elite", "Máy tính"));
        arrSanPham.add(new SanPham ("Asus V8", "Máy tính"));
        arrSanPham.add(new SanPham("Casio", "Đồng hồ"));
        arrSanPham.add(new SanPham ("Seiko", "Đồng hồ"));
        arrSanPham.add(new SanPham ("Rado", "Đồng hồ"));
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arrDanhMuc);
        adapter.setDropDownViewResource (android.R.layout.simple_list_item_single_choice);
        danhmuc.setAdapter(adapter);
        final ArrayAdapterSanPham adaptersp=new ArrayAdapterSanPham (MainActivity. this, arr);
        danhsach.setAdapter(adaptersp);

        danhmuc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                for(SanPham sp : arrSanPham)
                    if (sp.danhmuc==arrDanhMuc.get(position))
                        arr.add(sp.ten);
                adaptersp.notifyDataSetChanged();
            }

            public void onNothingSelected (AdapterView<?> arg0) {

            }
        });




    }
}