package phurua.student.qlbaihat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;


public class ThemAlbumActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnLuu;
    EditText etMaAlBum, etTenAlBum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_album);
        btnLuu = findViewById(R.id.btnLuuAlbum);
        btnLuu.setOnClickListener(this);
        etMaAlBum = findViewById(R.id.editTextMaAlbum_Them);
        etTenAlBum = findViewById(R.id.editTextTenAlbum_Them);

    }

    @Override
    public void onClick(View v) {
        if(v==btnLuu)
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
