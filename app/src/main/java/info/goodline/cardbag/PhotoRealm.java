package info.goodline.cardbag;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class PhotoRealm extends RealmObject {
    @PrimaryKey
    private  long imgID;

    public long getImgID() {
        return imgID;
    }

    public void setImgID(long imgID) {
        this.imgID = imgID;
    }
}
