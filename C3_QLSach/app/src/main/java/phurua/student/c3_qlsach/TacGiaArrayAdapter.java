package phurua.student.c3_qlsach;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

class TacGiaArrayAdapter extends ArrayAdapter<TacGia> {

    private Activity context;
    private ArrayList<TacGia> arr;
    TextView txtSTT, txtMaTG, txtTenTG;


    public TacGiaArrayAdapter(Activity context, ArrayList<TacGia> arr) {
        super(context,R.layout.tacgia_item ,arr);
        this.context = context;
        this.arr= arr;
    }


    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        LayoutInflater inflater = this.context.getLayoutInflater();
        View row = inflater.inflate(R.layout.tacgia_item,null);
        TacGia tg = arr.get(position);
        if (tg != null)
        {
            txtSTT = row.findViewById(R.id.txtSTT);
            txtMaTG = row.findViewById(R.id.txtMaTG);
            txtTenTG = row.findViewById(R.id.txtTenTG);

            txtSTT.setText((position+1) +"");
            txtMaTG.setText(tg.getMaTG());
            txtTenTG.setText(tg.getTenTG());
        }
        return row;
    }
}
