package ru.naburnm8.android.labapp;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.content.res.AppCompatResources;

import java.util.Random;


public class MainActivity extends AppCompatActivity {
    Button button1, button2;
    ImageView imageView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = findViewById(R.id.btn1);
        button2 = findViewById(R.id.exitButton);
        button2.setOnClickListener(v -> {
            finish();
            System.exit(0);
        });
        textView = findViewById(R.id.privacyString);
        textView.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/naburnm8/BaumansGate"));
            startActivity(intent);
        });
        imageView = findViewById(R.id.mainpic);
        shuffleImage(imageView);

    }
    public void btn1click(View view){
        Intent intent = new Intent(MainActivity.this, BattleListActivity.class);
        startActivity(intent);
    }
    protected void shuffleImage(ImageView imageView){
        Random rand = new Random();
        int choice = rand.nextInt(4);
        switch (choice){
            case 0:
                imageView.setImageDrawable(AppCompatResources.getDrawable(getApplicationContext(), R.drawable.vivovskoe));
                break;
            case 1:
                imageView.setImageDrawable(AppCompatResources.getDrawable(getApplicationContext(), R.drawable.skibidi));
                break;
            case 2:
                imageView.setImageDrawable(AppCompatResources.getDrawable(getApplicationContext(), R.drawable.tokpochesnoku));
                break;
            case 3:
                imageView.setImageDrawable(AppCompatResources.getDrawable(getApplicationContext(), R.drawable.perestatzanimatsa));
                break;
        }
    }

}