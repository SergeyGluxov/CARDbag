package info.goodline.cardbag;

import android.widget.ImageView;

public class Photo {
    private int iconUrl;

    public Photo(int iconSources) {
        this.iconUrl = iconSources;
    }

    public int getIconSources() {
        return iconUrl;
    }

    public void setIconSources(int iconUrl) {
        this.iconUrl = iconUrl;
    }
}
