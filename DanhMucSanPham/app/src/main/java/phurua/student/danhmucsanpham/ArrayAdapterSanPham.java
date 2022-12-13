package phurua.student.danhmucsanpham;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ArrayAdapterSanPham  extends ArrayAdapter<String> {

    private Activity context;
     private ArrayList<String> arr;
    public ArrayAdapterSanPham(Activity context, ArrayList<String> DSSanPham) {
        super(context, R.layout.sanpham_item_layout,DSSanPham);
         // TODO Auto-generated constructor stub
         this.context=context;
         this.arr=DSSanPham;
         }

    @Override
    public int getCount() {
        return this.arr.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //return super.getView(position, convertView, parent);
        LayoutInflater inflater=this.context.getLayoutInflater();
        View row=inflater.inflate(R.layout.sanpham_item_layout, null);
        ImageView imgDisplay=(ImageView)row.findViewById(R.id.imageView1);
        imgDisplay.setImageResource(R.drawable.th);
        TextView txtDisplay=(TextView)row.findViewById(R.id.textView1);
        txtDisplay.setText(arr.get(position));
        return row;
    }

         /*@Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub

        LayoutInflater inflater=this.context.getLayoutInflater();
        View row=inflater.inflate(R.layout.sanpham_item_layout, null);
        ImageView imgDisplay=(ImageView)row.findViewById(R.id.imageView1);
        imgDisplay.setImageResource(R.drawable.th);
        TextView txtDisplay=(TextView)row.findViewById(R.id.textView1);
        txtDisplay.setText(arr.get(position));
        return row;
        }*/
}
