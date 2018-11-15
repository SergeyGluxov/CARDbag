package info.goodline.cardbag;

import android.widget.EditText;

import java.io.Serializable;
import java.util.List;

public class Card implements Serializable {
    private String name;
    private String category;
    private String discount;

    public List<Photo> getPhoto() {
        return photo;
    }

    public List<Photo> photo;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }


}
