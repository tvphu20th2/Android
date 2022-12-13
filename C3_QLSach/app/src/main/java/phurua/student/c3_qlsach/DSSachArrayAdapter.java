package phurua.student.c3_qlsach;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class DSSachArrayAdapter extends ArrayAdapter<Sach> {
    ArrayList<Sach> array;
    int resource;
    TextView tvSTT;
    TextView tvTenSach;
    TextView tvNgayXB;
    Activity context;
    Sach sach;
    public DSSachArrayAdapter(Activity context,ArrayList<Sach> array) {
         super(context, R.layout.sach_item,array);
        // TODO Auto-generated constructor stub

         this.context = context;
        this.array = array;
         }

        public View getView(int position, View convertView, ViewGroup parent){

        LayoutInflater inflater=this.context.getLayoutInflater();
        View row=inflater.inflate(R.layout.sach_item, null);

         sach = array.get(position);
        if(sach !=null){
             tvSTT =(TextView) row.findViewById(R.id.txtSTTSach);
            tvTenSach = (TextView) row.findViewById(R.id.txtTenSach);
             tvNgayXB = (TextView) row.findViewById(R.id.txtNgayXB);
             tvSTT.setText((position+1)+"");
             tvTenSach.setText(sach.tenSach());
             tvNgayXB.setText(sach.ngayXuatBan());

             }
         return row;
         }
 }
