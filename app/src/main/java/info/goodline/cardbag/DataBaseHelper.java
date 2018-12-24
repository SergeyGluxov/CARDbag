package info.goodline.cardbag;

import java.lang.reflect.Array;
import java.util.ArrayList;
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
    public static List<Card> cards = Arrays.asList();

    public static List<Photo> photos = Arrays.asList(
            new Photo(R.drawable.card),
            new Photo(R.drawable.card)
    );


}

