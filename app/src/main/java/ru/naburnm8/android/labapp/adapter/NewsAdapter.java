package ru.naburnm8.android.labapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import org.jetbrains.annotations.NotNull;
import ru.naburnm8.android.labapp.R;
import ru.naburnm8.android.labapp.data.NewsData;
import ru.naburnm8.android.labapp.viewholder.NewsViewHolder;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsViewHolder> {
    private final ArrayList<NewsData> newsData;
    Context context;
    private final LayoutInflater inflater;

    public NewsAdapter(Context context, ArrayList<NewsData> newsData) {
        this.newsData = newsData;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }


    @NonNull
    @NotNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.recycler_view_news, parent,false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull NewsViewHolder holder, int position) {
        int pictureID = newsData.get(position).getPictureID();
        String title = newsData.get(position).getTitle();
        String author = newsData.get(position).getAuthor();
        String text = newsData.get(position).getContent();
        String date = newsData.get(position).getDate();
        holder.newsTitle.setText(title);
        holder.newsAuthor.setText(author);
        holder.newsDate.setText(date);
        holder.newsContent.setText(text);
        holder.newsImage.setImageResource(pictureID);
    }

    @Override
    public int getItemCount() {
        return newsData.size();
    }
    public void addNews(NewsData newsData) {
        this.newsData.add(newsData);
    }
}
