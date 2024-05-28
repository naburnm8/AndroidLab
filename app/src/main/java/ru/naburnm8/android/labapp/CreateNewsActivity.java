package ru.naburnm8.android.labapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.textfield.TextInputEditText;
import ru.naburnm8.android.labapp.adapter.PictureAdapter;
import ru.naburnm8.android.labapp.data.NewsData;
import ru.naburnm8.android.labapp.data.PictureData;
import ru.naburnm8.android.labapp.data.UserData;

import java.util.ArrayList;

public class CreateNewsActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    PictureAdapter pictureAdapter;
    Button add;
    TextInputEditText title, contents;
    ArrayList<PictureData> pictures;
    TextView poster;
    int chosenPicture;
    String posterNick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_news_activity);
        recyclerView = findViewById(R.id.picturesList);
        add = findViewById(R.id.doneNewsAdd);
        title = findViewById(R.id.titleInputField);
        contents = findViewById(R.id.contentInputField);
        poster = findViewById(R.id.posterName);
        pictures = getPictures();
        chosenPicture = pictures.get(0).getPictureID();
        pictureAdapter = new PictureAdapter(this, pictures);
        recyclerView.setAdapter(pictureAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        add.setOnClickListener(view -> {
            Editable titleFromForm = title.getText();
            String titleFromFormString = "Unknown";
            if (titleFromForm != null) {
                titleFromFormString = titleFromForm.toString();
            }
            Editable contentsFromForm = contents.getText();
            String contentsFromFormString = "Unknown";
            if (contentsFromForm != null) {
                contentsFromFormString = contentsFromForm.toString();
            }
            NewsData news = new NewsData(chosenPicture, posterNick, titleFromFormString, contentsFromFormString);
            Intent data = new Intent();
            data.putExtra("news", news);
            setResult(RESULT_OK, data);
            finish();
        });
        getPosterNick();
    }
    protected ArrayList<PictureData> getPictures(){
        ArrayList<PictureData> pictures = new ArrayList<>();
        pictures.add(new PictureData(R.drawable.ic_launcher_background, "No picture"));
        pictures.add(new PictureData(R.drawable.tokpochesnoku, "Ток по чесноку"));
        pictures.add(new PictureData(R.drawable.skibidi, "Шкибиди доп ес ес"));
        pictures.add(new PictureData(R.drawable.bogustidno, "Богу стыдно"));
        pictures.add(new PictureData(R.drawable.vivovskoe, "Вивовское"));
        pictures.add(new PictureData(R.drawable.perestatzanimatsa, "Что там написано?"));
        pictures.add(new PictureData(R.drawable.letchik, "Летчик"));
        return pictures;
    }
    protected void getPosterNick() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivityForResult(intent, 1);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(data == null) {return;}
        UserData user = (UserData) data.getSerializableExtra("user");
        posterNick = user.getNickname();
        poster.setText(user.getNickname());
    }
    public void setChosenPicture(int chosenPicture){
        this.chosenPicture = chosenPicture;
    }
}
