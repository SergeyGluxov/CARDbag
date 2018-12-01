package info.goodline.cardbag;

import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class CardRealm extends RealmObject {
    @PrimaryKey
    public int id;
    private String name;
    private Category category;
    private String discount;
    private RealmList<Integer> photo;

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public RealmList<Integer> getPhoto() {
        return photo;
    }

    public void setPhoto(RealmList<Integer> photo) {
        this.photo = photo;
    }

    public void setCategory(CategoryRealm categoryRealm) {
    }
}
