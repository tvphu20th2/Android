package com.example.bai27;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //Define variable
    public static int NEW_ALBUM = 100;
    public static int SAVE_ALBUM = 101;

    public static int LIST_ALBUM = 201;
    public static int LIST_ALBUM_BACK = 202;


    Button btnThemAlbum,btnDSAlbum,btnQLBaihat;

    public static int EDIT_ALBUM = 300;
    public static int UPDATE_ALBUM = 301;

    ArrayList<Album> albumList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnThemAlbum=(Button) findViewById(R.id.buttonAddAlbum);
        btnDSAlbum=(Button) findViewById(R.id.buttonXemDSAlbum);
        btnQLBaihat=(Button)findViewById(R.id.buttonThemBaiHat);

        btnThemAlbum.setOnClickListener(this);
        btnDSAlbum.setOnClickListener(this);
        btnQLBaihat.setOnClickListener(this);

        albumList.add(new Album("1","Bolero"));
        albumList.add(new Album("2","Pop"));
    }

    @Override
    public void onClick(View view) {
        if(view==btnThemAlbum)
        {
            Intent intent=new Intent(MainActivity.this,AddAlbumActivity.class);
            startActivityForResult(intent,NEW_ALBUM);
        }
        else if(view==btnDSAlbum)
        {
            Intent intent=new Intent(MainActivity.this,ListAlbumActivity.class);
            Bundle bundle=new Bundle();
            bundle.putSerializable("list",albumList);
            intent.putExtra("DATA",bundle);
            startActivityForResult(intent,LIST_ALBUM);
        }
        else if(view==btnQLBaihat) {
            Intent intent=new Intent(this,SongActivity.class);
            Bundle bundle=new Bundle();
            bundle.putSerializable("list",albumList);
            intent.putExtra("DATA",bundle);
            startActivity(intent);
        }
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
}