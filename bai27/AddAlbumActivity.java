package com.example.bai27;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.BreakIterator;

public class AddAlbumActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnLuu;
    EditText etMaAlBum,etTenAlBum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_album);
        btnLuu=(Button) findViewById(R.id.buttonLuuAlbum);
        btnLuu.setOnClickListener(this);
        etMaAlBum=(EditText) findViewById(R.id.editTextNewMaAlbum);
        etTenAlBum=(EditText) findViewById(R.id.editTextNewTenAlbum);
    }

    @Override
    public void onClick(View view) {
        if(view==btnLuu)
        {
            Intent intent=getIntent();
            Album album=new Album(etMaAlBum.getText()+"",etTenAlBum.getText()+"");
            Bundle bundle=new Bundle();
            bundle.putSerializable("album",album);
            intent.putExtra("DATA",bundle);
            setResult(MainActivity.SAVE_ALBUM,intent);
            finish();
        }
    }
}