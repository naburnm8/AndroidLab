package ru.naburnm8.android.labapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import ru.naburnm8.android.labapp.data.BattleData;

public class BattleActivity extends AppCompatActivity {
    BattleData battleData;
    TextView player1, player2, date, turns, player1Inventory, player2Inventory, map;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        battleData = (BattleData) intent.getSerializableExtra("battleData");
        setContentView(R.layout.battle_activity);
        player1 = findViewById(R.id.player1FULL);
        player2 = findViewById(R.id.player2FULL);
        date = findViewById(R.id.dateFULL);
        turns = findViewById(R.id.turnsFULL);
        player1Inventory = findViewById(R.id.player1InventoryFULL);
        player2Inventory = findViewById(R.id.player2InventoryFULL);
        map = findViewById(R.id.mapFULL);
        player1.setText(battleData.getPlayer1());
        player2.setText(battleData.getPlayer2());
        date.setText(battleData.getDate());
        turns.setText(battleData.getTurns());
        map.setText(battleData.getMapName());
        player1Inventory.setText(battleData.getP1Inventory());
        player2Inventory.setText(battleData.getP2Inventory());
    }
}
