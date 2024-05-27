package ru.naburnm8.android.labapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import org.jetbrains.annotations.NotNull;
import ru.naburnm8.android.labapp.R;
import ru.naburnm8.android.labapp.data.PictureData;
import ru.naburnm8.android.labapp.viewholder.PictureViewHolder;

import java.util.ArrayList;

public class PictureAdapter extends RecyclerView.Adapter<PictureViewHolder>{
    private final ArrayList<PictureData> pictures;
    Context context;
    private final LayoutInflater inflater;

    public PictureAdapter(Context context, ArrayList<PictureData> pictures) {
        this.pictures = pictures;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }
    @NonNull
    @NotNull
    @Override
    public PictureViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.recycler_view_pictures, parent, false);
        return new PictureViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull PictureViewHolder holder, int position) {
        int pictureID = pictures.get(position).getPictureID();
        String name = pictures.get(position).getPictureName();
        holder.pictureImage.setImageResource(pictureID);
        holder.pictureName.setText(name);
    }

    @Override
    public int getItemCount() {
        return pictures.size();
    }
}
