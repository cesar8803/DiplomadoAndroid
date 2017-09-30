package mx.mobilestudio.colorlist.model;

import java.util.List;

/**
 * Created by cesar on 9/2/17.
 */

public class ColorsResponse {

    public List<Color> getColors() {
        return colors;
    }

    public void setColors(List<Color> colors) {
        this.colors = colors;
    }

    public List<Color> colors;
}
