package ru.naburnm8.android.labapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import ru.naburnm8.android.labapp.data.UserData;

import java.util.ArrayList;
import java.util.Calendar;

public class LoginActivity extends AppCompatActivity {
    TextInputLayout username;
    Button loginButton;
    ArrayList<UserData> registeredUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        registeredUsers = getRegisteredUsers();
        setContentView(R.layout.login_activity);
        username = findViewById(R.id.textLogin);
        loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(view -> {
            Calendar now = Calendar.getInstance();
            String date = now.getTime().toString();
            String name = "Unknown";
            if(username.getEditText() != null){
            name = username.getEditText().getText().toString();
            }
            if(isRegistered(name)){
                Intent intent = new Intent();
                intent.putExtra("user", registeredUsers.get(RegisteredNumber(name)));
                setResult(RESULT_OK, intent);
                finish();
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("user", new UserData(name, date));
            setResult(RESULT_OK, intent);
            finish();
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, BattleListActivity.class);
        startActivity(intent);
        finish();
    }
    public static ArrayList<UserData> getRegisteredUsers() {
        ArrayList<UserData> registeredUsers = new ArrayList<>();
        registeredUsers.add(new UserData("naburnm8", "01-01-2004", "70%", "Archer"));
        registeredUsers.add(new UserData("gigoao", "01-01-2004", "75%", "Mounted"));
        registeredUsers.add(new UserData("barlamey", "01-01-2004", "90%", "Infantry"));
        registeredUsers.add(new UserData("ZOV LIKVIDIROVAN", "01-01-2004", "30%", "Custom unit"));
        registeredUsers.add(new UserData("80085", "01-01-2004", "50%", "Custom unit"));
        return registeredUsers;
    }
    protected boolean isRegistered(String username) {
        for(UserData user : registeredUsers) {
            if (username.equals(user.getNickname())){
                return true;
            }
        }
        return false;
    }
    protected int RegisteredNumber(String username) {
        int i = 0;
        for(UserData user : registeredUsers) {
            if (username.equals(user.getNickname())){
                return i;
            }
            i++;
        }
        return -1;
    }
}
