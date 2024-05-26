package ru.naburnm8.android.labapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import ru.naburnm8.android.labapp.baumansgate.Unit;

import java.io.Serializable;
import java.util.ArrayList;

public class CalculatorActivity extends AppCompatActivity {
    ArrayList<Unit> player1Units;
    ArrayList<Unit> player2Units;
    TextView player1Text, player2Text, outcome;
    Button addUnitsButton, calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator_activity);
        player1Text = findViewById(R.id.player1Units);
        player2Text = findViewById(R.id.player2Units);
        outcome = findViewById(R.id.outcomeText);
        addUnitsButton = findViewById(R.id.addUnitsButton);
        calculateButton = findViewById(R.id.calculateButton);
        addUnitsButton.setOnClickListener(view -> {
            Intent intent = new Intent(this, AddUnitActivity.class);
            startActivityForResult(intent, 1);
        });
        calculateButton.setOnClickListener(view -> {
            int plr1RatingATK = getOverallAttack(player1Units) - getOverallDefence(player2Units);
            int plr2RatingATK = getOverallAttack(player2Units) - getOverallDefence(player1Units);
            int plr1RatingDEF = getOverallDefence(player1Units) - getOverallDefence(player2Units);
            int plr2RatingDEF = getOverallDefence(player2Units) - getOverallDefence(player1Units);
            int plr1RatingOverall = (plr1RatingATK + plr1RatingDEF)/2;
            int plr2RatingOverall = (plr2RatingATK + plr2RatingDEF)/2;
            if(plr1RatingOverall > plr2RatingOverall){
                outcome.setTextColor(Color.GREEN);
                outcome.setText("Player 1 wins!");
            }
            else if (plr1RatingOverall == plr2RatingOverall){
                outcome.setTextColor(Color.BLACK);
                outcome.setText("Stalemate");
            }
            else{
                outcome.setTextColor(Color.RED);
                outcome.setText("Player 2 wins.");
            }
        });

    }
    @Override
    protected void onResume() {
        super.onResume();
        player1Text.setText(getUnitsString(player1Units));
        player2Text.setText(getUnitsString(player2Units));
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Serializable plr1 = data.getSerializableExtra("player1");
        Serializable plr2 = data.getSerializableExtra("player2");
        if(plr1 != null){
            player1Units = (ArrayList<Unit>) plr1;
        }
        if(plr2 != null){
            player2Units = (ArrayList<Unit>) plr2;
        }
    }
    protected int getOverallAttack(ArrayList<Unit> playerUnits) {
        int atk = 0;
        for(Unit u : playerUnits) {
            atk = atk + u.getBaseStatByName("Attack");
        }
        return atk;
    }
    protected int getOverallDefence(ArrayList<Unit> playerUnits) {
        int def = 0;
        for(Unit u : playerUnits) {
            def = def + u.getBaseStatByName("Defence");
        }
        return def;
    }
    protected String getUnitsString(ArrayList<Unit> units) {
        String unitsString = "";
        for(Unit u : units) {
            unitsString = unitsString + u.shortToString() + "\n";
        }
        return unitsString;
    }

}
