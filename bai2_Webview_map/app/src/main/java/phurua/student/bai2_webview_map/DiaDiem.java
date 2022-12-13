package phurua.student.bai2_webview_map;

import java.io.Serializable;

public class DiaDiem implements Serializable {
    String tendiadiem;

    @Override
    public String toString() {
        return tendiadiem ;
    }

    public String getTendiadiem() {
        return tendiadiem;
    }

    public void setTendiadiem(String tendiadiem) {
        this.tendiadiem = tendiadiem;
    }

    public Double getKinhdo() {
        return kinhdo;
    }

    public void setKinhdo(Double kinhdo) {
        this.kinhdo = kinhdo;
    }

    public Double getVido() {
        return vido;
    }

    public void setVido(Double vido) {
        this.vido = vido;
    }

    public DiaDiem(String tendiadiem, Double kinhdo, Double vido) {
        this.tendiadiem = tendiadiem;
        this.kinhdo = kinhdo;
        this.vido = vido;
    }

    Double kinhdo, vido;
}
