package phurua.student.danhmucsanpham;

public class SanPham {
    public String getDanhmuc() {
        return danhmuc;
    }

    public void setDanhmuc(String danhmuc) {
        this.danhmuc = danhmuc;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    String danhmuc;

    public SanPham( String ten,String danhmuc) {
        this.danhmuc = danhmuc;
        this.ten = ten;
    }

    String ten;
}
