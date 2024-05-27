package ru.naburnm8.android.labapp.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import org.jetbrains.annotations.NotNull;
import ru.naburnm8.android.labapp.R;

public class PictureViewHolder extends RecyclerView.ViewHolder {
    public ImageView pictureImage;
    public TextView pictureName;
    public View pictureView;

    public PictureViewHolder(@NonNull @NotNull View itemView) {
        super(itemView);
        pictureView = itemView;
        pictureImage = itemView.findViewById(R.id.pictureImageList);
        pictureName = itemView.findViewById(R.id.pictureNameList);
    }
}
