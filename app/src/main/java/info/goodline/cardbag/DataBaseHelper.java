package info.goodline.cardbag;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class DataBaseHelper {

    public static List<Category> category = Arrays.asList(
            new Category(1, "Одежда и обувь"),
            new Category(2, "Магазины")
    );
    public static List<Category> getCategories() {
        return category;
    }

    public static  List<Photo> photo = Arrays.asList(
            new Photo(R.drawable.card),
            new Photo(R.drawable.card)
    );
    public static List<Photo> getPhoto() {
        return photo;
    }
}

