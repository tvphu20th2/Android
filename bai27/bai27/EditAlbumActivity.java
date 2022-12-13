package com.example.bai27;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class EditAlbumActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnLuu,btnXoa;
    EditText etMaAlBum,etTenAlBum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_album);
        btnLuu=(Button) findViewById(R.id.buttonCapNhatAlbum);
        btnLuu.setOnClickListener(this);

        etMaAlBum=(EditText) findViewById(R.id.editTextEditMaAlbum);
        etTenAlBum=(EditText) findViewById(R.id.editTextEditTenAlbum);

        Intent intent=getIntent();
        Bundle bundle=intent.getBundleExtra("DATA");
        Album album=(Album)bundle.getSerializable("album");

        etMaAlBum.setEnabled(false);
        etMaAlBum.setText(album.getMaAlbum());
        etTenAlBum.setText(album.getTenAlbum());


    }

    @Override
    public void onClick(View view) {
        if(view==btnLuu)
        {
            Intent intent=getIntent();
            Bundle bundle=new Bundle();
            Album album=new Album(etMaAlBum.getText()+"",etTenAlBum.getText()+"");
            bundle.putSerializable("album", album);
            intent.putExtra("DATA",bundle);
            setResult(MainActivity.UPDATE_ALBUM,intent);
            finish();
        }
    }
}