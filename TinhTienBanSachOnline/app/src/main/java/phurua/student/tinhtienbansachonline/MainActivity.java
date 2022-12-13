package phurua.student.tinhtienbansachonline;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText hotenkh,soluongsach,tongsokh,tongsokhvip,tongdoanhthu;
    CheckBox vip;
    Button tinhtt,tiep,thongke,thoat;
    TextView thanhtien;

    ArrayList<KhachHang> arr=new ArrayList<KhachHang>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hotenkh = (EditText) findViewById(R.id.tenkhachhang);
        soluongsach = (EditText) findViewById(R.id.soluongsach);
        tongsokh = (EditText) findViewById(R.id.tongsokh);
        tongsokhvip = (EditText) findViewById(R.id.tongsokhvip);
        tongdoanhthu = (EditText) findViewById(R.id.tongdoanhthu);

        vip = (CheckBox) findViewById(R.id.vip);

        tinhtt = (Button) findViewById(R.id.tinhtt);
        tiep = (Button) findViewById(R.id.tiep);
        thongke = (Button) findViewById(R.id.thongke);
        thoat = (Button) findViewById(R.id.thoat);

        thanhtien = (TextView) findViewById(R.id.thanhtien);

        tinhtt.setOnClickListener((View.OnClickListener) this);
        tiep.setOnClickListener((View.OnClickListener) this);
        thongke.setOnClickListener((View.OnClickListener) this);
        thoat.setOnClickListener((View.OnClickListener) this);
    }


    public void onClick(View arg0) {
        if(arg0==tinhtt)
        {
            KhachHang kh=new KhachHang(hotenkh.getText()+"",
                    vip.isChecked(),
                    Integer.parseInt(soluongsach.getText()+""),
                    Integer.parseInt(soluongsach.getText()+"")*20000);
            thanhtien.setText(kh.getThanhtien()+"");
            arr.add(kh);
        }

else if(arg0==tiep)
        {
            hotenkh.setText("");
            soluongsach.setText("");
            thanhtien.setText("");
            hotenkh.requestFocus();
            vip.setChecked(false);
        }
        else if(arg0==thongke)
        {
            int slvip=0,tong=0;

            //vl for dạng biến đếm
            for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i).getVip())
                    slvip++;
                tong+=arr.get(i).getThanhtien();
            }
            tongsokh.setText(""+arr.size());
            tongsokhvip.setText(""+slvip);
            tongdoanhthu.setText(""+tong);
        }
        else if(arg0==thoat)
        {
            finish();
        }
}
}