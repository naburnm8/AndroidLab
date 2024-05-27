package ru.naburnm8.android.labapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ru.naburnm8.android.labapp.adapter.NewsAdapter;
import ru.naburnm8.android.labapp.data.NewsData;

import java.util.ArrayList;

public class NewsActivity extends AppCompatActivity{
    RecyclerView recyclerView;
    NewsAdapter adapter;
    Button addAnEntry;
    ArrayList<NewsData> newsData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_activity);
        recyclerView = findViewById(R.id.newsList);
        addAnEntry = findViewById(R.id.addAnEntry);
        newsData = getNews();
        adapter = new NewsAdapter(this, newsData);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        addAnEntry.setOnClickListener(view -> {
            Intent intent = new Intent(this, CreateNewsActivity.class);
            startActivityForResult(intent, 1);
        });
    }
    protected ArrayList<NewsData> getNews() {
        ArrayList<NewsData> newsData = new ArrayList<>();
        newsData.add(new NewsData(R.drawable.bogustidno, "SiemensOFF", "Отработки", "лол", "27-05-2024"));
        newsData.add(new NewsData(R.drawable.tokpochesnoku, "FN12person", "Дождались?", "я ухожу на пенсию", "13-37-2036"));
        newsData.add(new NewsData(R.drawable.skibidi, "BMSTU", "Новый кампус", "не дождётесь", "09-09-2099"));
        return newsData;
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        NewsData recieved = (NewsData) data.getSerializableExtra("data");
        newsData.add(recieved);
        adapter.notifyDataSetChanged();
    }

}
