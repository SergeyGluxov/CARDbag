package info.goodline.cardbag;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmList;

public class PhotoMapper {
    public static List<Photo> photoMap2Date(List<PhotoRealm> realmList) {
        List<Photo> photos = new ArrayList<>();
        for (PhotoRealm photoRealm : realmList) {
            Photo photo = new Photo(
                    photoRealm.getImgID()
            );
            photos.add(photo);
        }
        return photos;
    }

    public static RealmList<PhotoRealm> photoMap2Realm(List<Photo> photo){
        RealmList<PhotoRealm> photoRealm = new RealmList<>();
        for (Photo photos:photo){
            PhotoRealm photoRealm1 = new PhotoRealm();
            photoRealm1.setImgID(photos.getIconSources());
            photoRealm.add(photoRealm1);
        }
        return photoRealm;
    }
}
