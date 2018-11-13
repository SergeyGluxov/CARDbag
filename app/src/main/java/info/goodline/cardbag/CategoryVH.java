package info.goodline.cardbag;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class CategoryVH extends RecyclerView.ViewHolder
{
    public TextView tvName;
    public CategoryVH(@NonNull View itemView)
    {
        super(itemView);
        tvName = itemView.findViewById(R.id.tvName);
    }
}
