package phurua.student.qlbaihat;



import android.text.Editable;

import java.io.Serializable;

public class Album implements Serializable {




    public String getMaalbum() {
        return maalbum;
    }

    public void setMaalbum(String maalbum) {
        this.maalbum = maalbum;
    }

    public String getTenalbum() {
        return tenalbum;
    }

    public void setTenalbum(String tenalbum) {
        this.tenalbum = tenalbum;
    }

    String maalbum;

    public Album(String maalbum, String tenalbum) {
        this.maalbum = maalbum;
        this.tenalbum = tenalbum;
    }


    String tenalbum;


}
