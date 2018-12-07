package info.goodline.cardbag;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class PhotoRealm extends RealmObject {
    @PrimaryKey
    private  int imgID;

    public int getImgID() {
        return imgID;
    }

    public void setImgID(int imgID) {
        this.imgID = imgID;
    }
}
