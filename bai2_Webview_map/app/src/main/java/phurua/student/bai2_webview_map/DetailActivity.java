package phurua.student.bai2_webview_map;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    TextView tvTen;
    WebView wv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("data");
        DiaDiem diaDiem = (DiaDiem) bundle.getSerializable("diadiem");

        tvTen = findViewById(R.id.txtDiadiem);
        tvTen.setText(diaDiem.getTendiadiem());
        wv= findViewById(R.id.webNoidung);

        wv.getSettings().setJavaScriptEnabled(true);
        wv.loadData("<iframe width='100%' height='100%' frameborder='0' style='border:0' src='https://www.google.com/maps/embed/v1/place?key=AIzaSyCi5fy1hSfq-UmzgLG6dINJkndeY4gHKt0&zoom=10&maptype=satellite&q="+diaDiem.getTendiadiem()+"'></iframe>","text/html", "UTF-8");

    }
}