package ru.naburnm8.android.labapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Switch;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ru.naburnm8.android.labapp.adapter.BattleAdapter;
import ru.naburnm8.android.labapp.baumansgate.Archer;
import ru.naburnm8.android.labapp.baumansgate.Infantry;
import ru.naburnm8.android.labapp.baumansgate.Mounted;
import ru.naburnm8.android.labapp.baumansgate.Unit;
import ru.naburnm8.android.labapp.data.BattleData;

import java.util.ArrayList;
import java.util.Random;

public class BattleListActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    BattleAdapter battleAdapter;
    Button calculator, profile, players, news;
    Switch themeSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bauman_menu);
        //setTheme(R.style.Base_Theme_Material3_Dark);
        recyclerView = findViewById(R.id.list1);
        calculator = findViewById(R.id.calculator);
        profile = findViewById(R.id.viewProfile);
        players = findViewById(R.id.viewPlayers);
        themeSwitch = findViewById(R.id.themeSwitch);
        themeSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }
            else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }
        });
        profile.setOnClickListener(view -> {
            Intent intent = new Intent(this, ProfileActivity.class);
            startActivity(intent);
        });
        players.setOnClickListener(view -> {
            Intent intent = new Intent(this, PlayersListActivity.class);
            startActivity(intent);
        });
        calculator.setOnClickListener(view -> {
            Intent intent = new Intent(this, CalculatorActivity.class);
            startActivity(intent);
        });
        ArrayList<BattleData> battleData = fillData();
        battleAdapter = new BattleAdapter(this, battleData);
        recyclerView.setAdapter(battleAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        news = findViewById(R.id.news);
        news.setOnClickListener(view -> {
            Intent intent = new Intent(this, NewsActivity.class);
            startActivity(intent);
        });

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
        System.exit(0);
    }
    protected ArrayList<BattleData> fillData() {
        ArrayList<BattleData> data = new ArrayList<>();
        data.add(new BattleData("naburnm8", "gigoao", "01-02-2004 00:31 - 01-02-2004 00:59", getInventory(getUnits("1")), getInventory(getUnits("1")), "map1", "10"));
        data.add(new BattleData("barlamey", "naburnm8", "02-02-2004 00:31 - 02-02-2004 00:59", getInventory(getUnits("1")), getInventory(getUnits("1")), "map2", "15"));
        data.add(new BattleData("ZOV LIKVIDIROVAN", "80085", "03-02-2004 00:31 - 03-02-2004 00:59", getInventory(getUnits("1")), getInventory(getUnits("1")), "map3", "20"));
        return data;
    }
    protected ArrayList<Unit> getUnits(String nickname) {
        ArrayList<Unit> units = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            int classID = random.nextInt(3);
            switch (classID) {
                case 0:
                    units.add(new Archer(random.nextInt(4), random.nextInt(4), random.nextInt(4)));
                    break;
                case 1:
                    units.add(new Mounted(random.nextInt(4), random.nextInt(4), random.nextInt(4)));
                    break;
                case 2:
                    units.add(new Infantry(random.nextInt(4), random.nextInt(4), random.nextInt(4)));
                    break;
                default:
                    throw new IllegalArgumentException("Unexpected value: " + classID);
            }
        }
        return units;
    }
    protected String getInventory(ArrayList<Unit> units) {
        String out = "";
        for (Unit unit : units) {
            out = out + unit.shortToString() + "\n";
        }
        return out;
    }

}
