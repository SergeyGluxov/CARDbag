package info.goodline.cardbag;

import java.io.Serializable;

public class Category implements Serializable {

    public void setId(int id) {
        this.id = id;
    }

    private int id;

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public Category(int id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }


}
