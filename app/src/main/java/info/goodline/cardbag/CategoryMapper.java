package info.goodline.cardbag;

import java.util.ArrayList;
import java.util.List;

public class CategoryMapper {
    public static Category categoryMap2Date(CategoryRealm categoryRealm){
        Category category = new Category();
        category.setName(categoryRealm.getName());
        category.setId(categoryRealm.getId());
        return category;
    }

    public static CategoryRealm categoryMap2Realm(Category category){
        CategoryRealm categoryRealm = new CategoryRealm();
        categoryRealm.setId(category.getId());
        categoryRealm.setName(category.getName());
        return categoryRealm;
    }

    public static List<CategoryRealm> map2RealmList(List<Category> categories) {
        List<CategoryRealm> realmList = new ArrayList<>();
        for (Category category : categories) {
            CategoryRealm categoryRealm = new CategoryRealm();
            categoryRealm.setId(category.getId());
            categoryRealm.setName(category.getName());
            realmList.add(categoryRealm);
        }
        return realmList;
    }

    public static List<Category> map2DataList(List<CategoryRealm> realmList) {
        List<Category> categories = new ArrayList<>();
        for (CategoryRealm categoryRealm : realmList) {
            Category category = new Category(
                    categoryRealm.getId(),
                    categoryRealm.getName()
            );
            categories.add(category);
        }
        return categories;
    }
}
