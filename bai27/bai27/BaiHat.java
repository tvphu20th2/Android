package com.example.bai27;

import java.io.Serializable;
import java.util.Date;

public class BaiHat implements Serializable {
    String maAlbum;
    String tenBaiHat;
    Date ngayPhatHanh;

    public BaiHat(String maAlbum, String tenBaiHat, Date ngayPhatHanh) {
        this.maAlbum = maAlbum;
        this.tenBaiHat = tenBaiHat;
        this.ngayPhatHanh = ngayPhatHanh;
    }


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


}
