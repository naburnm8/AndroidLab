package ru.naburnm8.android.labapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import ru.naburnm8.android.labapp.baumansgate.Unit;

import java.util.ArrayList;

public class AddUnitActivity extends AppCompatActivity {
    ArrayList<Unit> player1UnitsAddable;
    ArrayList<Unit> player2UnitsAddable;
    Button swordman, spearman, hatchetman, crossbow, shortbow, longbow, knight, cuirassier, archer, done, clear;
    Switch playerSwitch;
    TextView addableUnits;
    ImageView imageBog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_unit_activity);
        player1UnitsAddable = new ArrayList<>();
        player2UnitsAddable = new ArrayList<>();
        swordman = findViewById(R.id.swordman);
        spearman = findViewById(R.id.spearman);
        hatchetman = findViewById(R.id.hatchetman);
        crossbow = findViewById(R.id.crossbow);
        shortbow = findViewById(R.id.shortbow);
        longbow = findViewById(R.id.longbow);
        knight = findViewById(R.id.knight);
        cuirassier = findViewById(R.id.cuirrasier);
        archer = findViewById(R.id.mountedArcher);
        done = findViewById(R.id.doneButton);
        done.setOnClickListener(view -> {
            Intent intent = new Intent();
            intent.putExtra("player1", player1UnitsAddable);
            intent.putExtra("player2", player2UnitsAddable);
            setResult(RESULT_OK, intent);
            finish();
        });
        clear = findViewById(R.id.clearButton);
        clear.setOnClickListener(view -> {
            if (playerSwitch.isChecked()){
                player2UnitsAddable.clear();
                addableUnits.setText("Units cleared.");
            }
            else {
                player1UnitsAddable.clear();
                addableUnits.setText("Units cleared.");
            }
        });
        playerSwitch = findViewById(R.id.playerSwitch);
        addableUnits = findViewById(R.id.addableUnits);
        imageBog = findViewById(R.id.imageBog);
        playerSwitch.setOnCheckedChangeListener((buttonView, isChecked) ->{
            if(isChecked){
                addableUnits.setText(getUnitsString(player2UnitsAddable));
            }
            else{
                addableUnits.setText(getUnitsString(player1UnitsAddable));
            }
        });
        imageBog.setOnClickListener(view -> {

        })
    }
    protected String getUnitsString(ArrayList<Unit> units){
        String out = "";
        for (Unit unit : units){
            out += unit.shortToString() + "\n";
        }
        return out;
    }

}
