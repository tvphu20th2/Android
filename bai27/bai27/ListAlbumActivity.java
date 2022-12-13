package com.example.bai27;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListAlbumActivity extends AppCompatActivity {

    ArrayList<Album> albumList;
    ListView lvDSalbum;
    AlbumAdapter adapter;
    int selectAlbum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_album);
        //lấy danh sách Album gởi từ MainActivity
        Intent intent=getIntent();
        Bundle bundle=intent.getBundleExtra("DATA");
        albumList=(ArrayList<Album>)bundle.getSerializable("list");

        lvDSalbum=(ListView) findViewById(R.id.listviewDSAlbum);
        adapter=new AlbumAdapter(this,albumList);
        lvDSalbum.setAdapter(adapter);

        lvDSalbum.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                selectAlbum=i;
                Intent intent=new Intent(ListAlbumActivity.this,EditAlbumActivity.class);
                Bundle bundle=new Bundle();
                bundle.putSerializable("album",albumList.get(i));
                intent.putExtra("DATA",bundle);
                startActivityForResult(intent,MainActivity.EDIT_ALBUM);
            }
        });

        lvDSalbum.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int pos, long l) {
                AlertDialog.Builder builder=new AlertDialog.Builder(ListAlbumActivity.this);
                builder.setTitle("Xác nhận");
                builder.setMessage("Muốn xóa thiệt hả?");
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        albumList.remove(pos);
                        adapter.notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                builder.create().show();
                return true;
            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent intent=getIntent();
        Bundle bundle=new Bundle();
        //Album album=new Album(etMaAlbum.getText()+"",etTenAlbum.getText()+"");
        bundle.putSerializable("list", albumList);
        intent.putExtra("DATA",bundle);
        setResult(MainActivity.LIST_ALBUM_BACK,intent);
        super.onBackPressed();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)  {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == MainActivity.EDIT_ALBUM) {
            if(resultCode == MainActivity.UPDATE_ALBUM) {
                Bundle bundle=data.getBundleExtra("DATA");
                Album album=(Album)bundle.getSerializable("album");
                /*for (Album al:albumList) {
                    if(album.getMaAlbum().equals(album.getMaAlbum()))
                    {
                        al.setTenAlbum(album.getTenAlbum());
                        break;
                    }
                }*/

                albumList.get(selectAlbum).setTenAlbum(album.getTenAlbum());

                adapter.notifyDataSetChanged();

                Toast.makeText(ListAlbumActivity.this, "Cập nhật Album thành công", Toast.LENGTH_SHORT).show();
            }
        }
    }
}