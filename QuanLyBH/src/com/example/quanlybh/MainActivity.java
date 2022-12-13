package com.example.quanlybh;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity implements View.OnClickListener {

     static final int NEW_ALBUM = 100;
     static final int SAVE_ALBUM =101;

     static final int LIST_ALBUM = 201;
     static final int LIST_ALBUM_BACK = 202;

     static int EDIT_ALBUM = 300;
     static int UPDATE_ALBUM = 301;

    Button btnThemAlbum , btnDSAlbum , btnQLBH;

    ArrayList<Album>  albumList = new ArrayList<Album>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnThemAlbum = (Button) findViewById(R.id.btnThemAlbum);
        btnDSAlbum = (Button) findViewById(R.id.btnXemDSAlbum);
        btnQLBH = (Button) findViewById(R.id.btnQlBH);

        btnThemAlbum.setOnClickListener(this);
        btnDSAlbum.setOnClickListener(this);
        btnQLBH.setOnClickListener(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == NEW_ALBUM) {
            if (resultCode == SAVE_ALBUM) {
                Bundle bundle=data.getBundleExtra("DATA");
                Album album=(Album)bundle.getSerializable("album");
                albumList.add(album);
                Toast.makeText(MainActivity.this, "Thêm Album thành công", Toast.LENGTH_SHORT).show();
            }
        }
        else if(requestCode == LIST_ALBUM) {
            if(resultCode == LIST_ALBUM_BACK) {
                Bundle bundle=data.getBundleExtra("DATA");
                albumList= (ArrayList<Album>) bundle.getSerializable("list");
            }
        }
    }

    @Override
    public void onClick(View v) {

        if(v==btnThemAlbum)
        {
            Intent intent = new Intent(MainActivity.this , ThemAlbumActivity.class);
            startActivity(intent);
        }
        else if(v==btnDSAlbum)
        {
            Intent intent = new Intent(MainActivity.this , DSAlbumActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("dsalbum", albumList);
            intent.putExtra("data",bundle);
            startActivity(intent);
        }
        else if(v==btnQLBH)
        {
            Intent intent = new Intent(MainActivity.this , ThemAlbumActivity.class);
            startActivity(intent);
        }
    }
}