package info.goodline.cardbag;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoVH>{

    private List<Photo> photoList;
    Context context;

    public PhotoAdapter(Context context, List<Photo> photo)
    {
        this.context = context;
        this.photoList = photo;
    }

    @NonNull
    @Override
    public PhotoVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_photo_card, viewGroup, false);
        return new PhotoVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoVH photoVH, int position) {
        final Photo photo = photoList.get(position);
        photoVH.ivPhoto.setImageResource(photo.getIconSources());
    }

    @Override
    public int getItemCount() {
        return photoList.size();
    }
}
