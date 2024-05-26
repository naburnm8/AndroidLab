package ru.naburnm8.android.labapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import ru.naburnm8.android.labapp.data.UserData;

public class ProfileActivity extends AppCompatActivity {
    boolean loggedIn = false;
    TextView nickname, dateOfRegistration, winPercentage, favouriteUnit, status;
    UserData user = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_activity);
        nickname = findViewById(R.id.nicknameProfile);
        dateOfRegistration = findViewById(R.id.dateOfRegistration);
        winPercentage = findViewById(R.id.winPercentage);
        favouriteUnit = findViewById(R.id.favouriteUnit);
        status = findViewById(R.id.status);
        if(!loggedIn || user == null){
            Intent intent = new Intent(this, LoginActivity.class);
            loggedIn = true;
            startActivityForResult(intent, 1);
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data == null){ return; }
        user = (UserData) data.getSerializableExtra("user");
        nickname.setText(user.getNickname());
        dateOfRegistration.setText(user.getDateOfRegistration());
        winPercentage.setText(user.getWinPercent());
        favouriteUnit.setText(user.getFavouriteUnitType());
        status.setText(user.getStatus());
    }
}
