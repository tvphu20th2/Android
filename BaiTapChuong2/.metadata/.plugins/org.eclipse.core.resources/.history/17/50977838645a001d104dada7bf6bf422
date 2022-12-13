package phurua.student.qlbaihat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SuaAlbumActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnLuu,btnXoa;
    EditText etMaAlBum,etTenAlBum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sua_album);
        btnLuu=findViewById(R.id.btnUpdate);
        btnLuu.setOnClickListener(this);

        etMaAlBum= findViewById(R.id.editTextMaAlbum_Sua);
        etTenAlBum=findViewById(R.id.editTextTenAlbum_Sua);

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
