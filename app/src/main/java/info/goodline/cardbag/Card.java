package info.goodline.cardbag;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Card implements Serializable {
    private int Id;
    private String name;
    private Category category;
    private String discount;
    private List<Photo> photos;

    public Card() {
    }

    public Card(int id, String name, Category category, String discount, List<Photo> photos) {
        Id = id;
        this.name = name;
        this.category = category;
        this.discount = discount;
        this.photos = photos;
    }


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }


    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    public String getName() {
        return name;
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


}
