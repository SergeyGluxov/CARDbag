package info.goodline.cardbag;

import android.widget.ImageView;

import java.io.Serializable;

public class Photo implements Serializable {
    private long iconUrl;

    public Photo(long iconSources) {
        this.iconUrl = iconSources;
    }

    public long getIconSources() {
        return iconUrl;
    }
}
