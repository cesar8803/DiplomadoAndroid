package mx.mobilestudio.colorlist.model;

import java.util.List;

/**
 * Created by cesar on 9/2/17.
 */

class Code {

    public List<Integer> getRgba() {
        return rgba;
    }

    public void setRgba(List<Integer> rgba) {
        this.rgba = rgba;
    }

   public  List<Integer> rgba;

    public String getHex() {
        return hex;
    }

    public void setHex(String hex) {
        this.hex = hex;
    }

    public String hex;
}
