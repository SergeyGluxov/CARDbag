package info.goodline.cardbag;

import android.content.Context;
import android.icu.util.ULocale;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryVH>
{

    private List<Category> category;
    private LayoutInflater inflater;
    public  CategoryAdapter(Context context, List<Category> category)
    {
        this.category = category;
        this.inflater = LayoutInflater.from(context);
    }
    @NonNull
    @Override
    public CategoryVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.item_category, viewGroup, false);
        return new CategoryVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryVH categoryVH, int position) {
        Category categoryItem = category.get(position);
        categoryVH.tvId.setText(categoryItem.getId());
        categoryVH.tvName.setText(categoryItem.getName());
    }

    @Override
    public int getItemCount() {
        return category.size();
    }
}
