package phurua.student.c3_qlsach;

import java.io.Serializable;

public class TacGia implements Serializable {
    String MaTG;
    String TenTG;

    public TacGia(String maTG, String tenTG) {
        MaTG = maTG;
        TenTG = tenTG;
    }

    public String getMaTG() {
        return MaTG;
    }

    public void setMaTG(String maTG) {
        MaTG = maTG;
    }

    public String getTenTG() {
        return TenTG;
    }

    public void setTenTG(String tenTG) {
        TenTG = tenTG;
    }
}
