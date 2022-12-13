package com.example.quanlybh;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;



import java.util.ArrayList;

public class DSAlbumActivity extends Activity {

    ArrayList<Album> albumList;
    ListView lvDSalbum;
    AlbumAdapter adapter;
    int selectAlbum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dsalbum);

        //lấy danh sách Album gởi từ MainActivity
        Intent intent=getIntent();
        Bundle bundle=intent.getBundleExtra("DATA");
        albumList=(ArrayList<Album>)bundle.getSerializable("list");

        lvDSalbum=(ListView) findViewById(R.id.lvDSAlbum);
        adapter=new AlbumAdapter(this,albumList);
        lvDSalbum.setAdapter(adapter);
    }
}
