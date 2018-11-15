package info.goodline.cardbag;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

public class PhotoVH extends RecyclerView.ViewHolder {
    public ImageView ivPhoto;

     PhotoVH(@NonNull View itemView) {
        super(itemView);
        ivPhoto = itemView.findViewById(R.id.ivPhotoCard);
    }
}
