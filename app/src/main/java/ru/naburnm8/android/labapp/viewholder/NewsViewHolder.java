package ru.naburnm8.android.labapp.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import org.jetbrains.annotations.NotNull;
import ru.naburnm8.android.labapp.R;

public class NewsViewHolder extends RecyclerView.ViewHolder {
    public TextView newsTitle;
    public TextView newsDate;
    public ImageView newsImage;
    public TextView newsContent;
    public TextView newsAuthor;
    public View newsView;
    public NewsViewHolder(@NonNull @NotNull View itemView) {
        super(itemView);
        newsView = itemView;
        newsTitle = itemView.findViewById(R.id.titleNews);
        newsDate = itemView.findViewById(R.id.newsDate);
        newsImage = itemView.findViewById(R.id.newsImage);
        newsContent = itemView.findViewById(R.id.newsText);
        newsAuthor = itemView.findViewById(R.id.newsAuthor);
    }
}
