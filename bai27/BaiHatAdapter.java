package com.example.bai27;

import android.app.Activity;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;



import java.util.ArrayList;
import java.util.Date;

public class BaiHatAdapter extends BaseAdapter {

    private ArrayList<BaiHat> list;
    Activity context;
    public BaiHatAdapter(@NonNull Activity context, ArrayList<BaiHat> list) {
        super();
        this.context=context;
        this.list=list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater=this.context.getLayoutInflater();
        View row=inflater.inflate(R.layout.baihat_item_layout,null);

        TextView txtSTT=(TextView)row.findViewById(R.id.textViewSTTBH);
        TextView txtTenBH=(TextView)row.findViewById(R.id.textViewTenBH);
        TextView txtNgayPH=(TextView)row.findViewById(R.id.textViewNgayPH);
        txtSTT.setText((i+1)+"");
        txtTenBH.setText(list.get(i).getTenBaiHat());

        Date ngayPH=list.get(i).getNgayPhatHanh();
        txtNgayPH.setText(DateFormat.format("dd-MM-yyyy", ngayPH).toString());
        return row;
    }
}
