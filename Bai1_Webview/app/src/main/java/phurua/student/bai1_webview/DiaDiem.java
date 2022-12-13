package phurua.student.bai1_webview;

import java.io.Serializable;

public class DiaDiem implements Serializable {
    public String getTendiadiem() {
        return tendiadiem;
    }

    public void setTendiadiem(String tendiadiem) {
        this.tendiadiem = tendiadiem;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    String tendiadiem;

    public DiaDiem(String tendiadiem, String noidung) {
        this.tendiadiem = tendiadiem;
        this.noidung = noidung;
    }

    @Override
    public String toString() {
        return tendiadiem ;
    }

    String noidung;
}
