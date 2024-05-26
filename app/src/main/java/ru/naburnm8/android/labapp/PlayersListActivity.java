package ru.naburnm8.android.labapp;

import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ru.naburnm8.android.labapp.adapter.PlayerAdapter;
import ru.naburnm8.android.labapp.data.UserData;

import java.util.ArrayList;

public class PlayersListActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    PlayerAdapter adapter;
    Button sortNickname, sortWin, sortDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_list_activity);
        recyclerView = findViewById(R.id.playerList);
        sortDate = findViewById(R.id.sortByRegistration);
        sortWin = findViewById(R.id.sortByPercentage);
        sortNickname = findViewById(R.id.sortByNickname);
        ArrayList<UserData> playerData = LoginActivity.getRegisteredUsers();
        adapter = new PlayerAdapter(this, playerData);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        sortNickname.setOnClickListener(view -> {
            adapter.Sort("name");
            recyclerView.setAdapter(null);
            recyclerView.setAdapter(adapter);
        });
        sortWin.setOnClickListener(view -> {
            adapter.Sort("win");
            recyclerView.setAdapter(null);
            recyclerView.setAdapter(adapter);
        });
        sortDate.setOnClickListener(view -> {
            adapter.Sort("date");
            recyclerView.setAdapter(null);
            recyclerView.setAdapter(adapter);
        });
    }
}
