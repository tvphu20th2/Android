package com.example.quanlybh;

import android.app.Activity;
import android.os.Bundle;



import java.util.Date;

public class BaiHat extends Activity {
    String maAlbum;

    public String getMaAlbum() {
        return maAlbum;
    }

    public void setMaAlbum(String maAlbum) {
        this.maAlbum = maAlbum;
    }

    public String getTenBaiHat() {
        return tenBaiHat;
    }

    public void setTenBaiHat(String tenBaiHat) {
        this.tenBaiHat = tenBaiHat;
    }

    public Date getNgayPhatHanh() {
        return ngayPhatHanh;
    }

    public void setNgayPhatHanh(Date ngayPhatHanh) {
        this.ngayPhatHanh = ngayPhatHanh;
    }

    public BaiHat(String maAlbum, String tenBaiHat, Date ngayPhatHanh) {
        this.maAlbum = maAlbum;
        this.tenBaiHat = tenBaiHat;
        this.ngayPhatHanh = ngayPhatHanh;
    }

    String tenBaiHat;
    Date ngayPhatHanh;

}
