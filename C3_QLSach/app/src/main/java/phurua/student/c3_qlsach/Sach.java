package phurua.student.c3_qlsach;

import java.io.Serializable;

public class Sach implements Serializable {
    private String maTacGia;
    private String tenSach;
    private String ngayXuatBan;

    public Sach( String tenSach, String ngayXB, String maTacGia) {

        this.tenSach = tenSach;
        this.ngayXuatBan = ngayXB;
        this.maTacGia = maTacGia;
    }

    public void maTacGia(String maTacGia)
    {
         this.maTacGia = maTacGia;
    }
    public void ngayXuatBan(String ngayXuatBan)
    {
         this.ngayXuatBan = ngayXuatBan;
    }
    public void tenSach(String tenSach)
    {
        this.tenSach = tenSach;
    }
    public String maTacGia()
    {
         return this.maTacGia;
    }
    public String ngayXuatBan()
    {
        return this.ngayXuatBan;
    }
    public String tenSach()
    {
        return this.tenSach;
    }
    @Override
    public boolean equals(Object o) {
        // TODO Auto-generated method stub
        if(o instanceof Sach) {
             Sach f = (Sach)o;
            return this.tenSach.equalsIgnoreCase(f.tenSach());
             }
        return false;
        }
        @Override
    public int hashCode() {
        // TODO Auto-generated method stub
         return this.maTacGia.hashCode();
    }

        public String toString() {
         return tenSach;
         }
}
