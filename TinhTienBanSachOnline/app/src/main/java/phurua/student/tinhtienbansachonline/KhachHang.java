package phurua.student.tinhtienbansachonline;

import android.R.bool;
public class KhachHang {
    private String hoten;

    public KhachHang(String hoten,Boolean vip, int soluong, int thanhtien) {
        this.hoten = hoten;
        this.soluong = soluong;
        this.thanhtien = thanhtien;
        this.vip = vip;
    }

    private int soluong;

    public int getThanhtien() {
        return thanhtien;
    }

    private int thanhtien;

    public Boolean getVip() {
        return vip;
    }

    private Boolean vip;
}
