package phurua.student.bai1_webview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    TextView tvTen;
    WebView wv;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("data");
        DiaDiem diaDiem = (DiaDiem) bundle.getSerializable("diadiem");

        tvTen = findViewById(R.id.txtDiadiem);
        tvTen.setText(diaDiem.getTendiadiem());
        wv= findViewById(R.id.webNoidung);
        wv.loadUrl("file:///android_asset/"+diaDiem.getNoidung());




    }
}