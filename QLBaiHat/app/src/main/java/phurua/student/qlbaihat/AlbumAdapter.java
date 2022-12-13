package phurua.student.qlbaihat;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AlbumAdapter extends BaseAdapter {
    Activity context;
    ArrayList<Album> list;

    public AlbumAdapter(Activity context, ArrayList<Album> list) {
        super();
        this.list = list;
        this.context = context;
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
    public View getView(int i, View convertView, ViewGroup parent) {
        LayoutInflater inflater=this.context.getLayoutInflater();
        View row=inflater.inflate(R.layout.dsalbum_item,null);

        TextView txtSTT=(TextView)row.findViewById(R.id.textViewSTT);
        TextView txtMaAlbum=(TextView)row.findViewById(R.id.textViewMaAlbum);
        TextView txtTenAlbum=(TextView)row.findViewById(R.id.textViewTenAlbum);
        txtSTT.setText((i+1)+"");
        txtMaAlbum.setText(list.get(i).getMaalbum());
        txtTenAlbum.setText(list.get(i).getTenalbum());
        return row;
    }




}
