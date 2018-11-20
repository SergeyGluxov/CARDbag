package info.goodline.cardbag;

import android.widget.ImageView;

import java.io.Serializable;

public class Photo implements Serializable {
    private int iconUrl;

    public Photo(int iconSources) {
        this.iconUrl = iconSources;
    }

    public int getIconSources() {
        return iconUrl;
    }
}
