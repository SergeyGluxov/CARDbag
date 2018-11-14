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
    private onItemClickListener clickListener;
    public  CategoryAdapter(Context context, List<Category> category,  onItemClickListener clickListener)
    {
        this.category = category;
        this.inflater = LayoutInflater.from(context);
        this.clickListener = clickListener;
    }
    @NonNull
    @Override
    public CategoryVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.item_category, viewGroup, false);
        return new CategoryVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryVH categoryVH, int position) {
        final Category categoryItem = category.get(position);
        categoryVH.tvName.setText(categoryItem.getName());
        categoryVH.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListener.onItemClick(categoryItem);
            }
        });
    }

    @Override
    public int getItemCount() {
        return category.size();
    }


    public interface onItemClickListener {
        void onItemClick(Category item);
    }

}
