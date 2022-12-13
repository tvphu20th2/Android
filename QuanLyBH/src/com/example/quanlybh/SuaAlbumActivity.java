package com.example.quanlybh;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;



public class SuaAlbumActivity extends Activity implements View.OnClickListener {
    Button btnLuu,btnXoa;
    EditText etMaAlBum,etTenAlBum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sua_album);
        btnLuu=(Button) findViewById(R.id.btnUpdate);
        btnLuu.setOnClickListener(this);

        etMaAlBum= (EditText) findViewById(R.id.editTextMaAlbum_Sua);
        etTenAlBum=(EditText) findViewById(R.id.editTextTenAlbum_Sua);

        Intent intent=getIntent();
        Bundle bundle=intent.getBundleExtra("DATA");
        Album album=(Album)bundle.getSerializable("album");

        etMaAlBum.setEnabled(false);
        etMaAlBum.setText(album.getMaalbum());
        etTenAlBum.setText(album.getTenalbum());


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
