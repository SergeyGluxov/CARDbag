package info.goodline.cardbag;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoVH>{

    private  LayoutInflater inflater;
    private List<Photo> photosList;
    Context context;

    public PhotoAdapter(Context context, List<Photo> photos)
    {
        this.inflater = LayoutInflater.from(context);
        this.context = context;
        this.photosList = photos;
    }

    @NonNull
    @Override
    public PhotoVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.item_photo_card, viewGroup, false);
        return new PhotoVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoVH photoVH, int position) {
        final Photo photo = photosList.get(position);
        File imgFile = new File(
                context.getExternalFilesDir(Environment.DIRECTORY_PICTURES) + "/" +
                        photo.getIconSources() + ".jpg"
        );

        if (imgFile.exists()) {
            Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
            photoVH.ivPhoto.setImageBitmap(myBitmap);
            return;
        }

    }

    @Override
    public int getItemCount() {
        return photosList.size();
    }

    public void setPhotosList(List<Photo> photosList) {
        this.photosList = photosList;
    }
}
