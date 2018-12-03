package info.goodline.cardbag;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class CategoryRealm extends RealmObject {

    @PrimaryKey
    public int id;
    public String name;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
