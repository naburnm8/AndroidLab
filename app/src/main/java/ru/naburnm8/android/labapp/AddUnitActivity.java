package ru.naburnm8.android.labapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import ru.naburnm8.android.labapp.baumansgate.Archer;
import ru.naburnm8.android.labapp.baumansgate.Infantry;
import ru.naburnm8.android.labapp.baumansgate.Mounted;
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
        swordman.setOnClickListener(view -> {
            if(playerSwitch.isChecked()){
                player2UnitsAddable.add(new Infantry(1,0,0));
                addableUnits.setText(getUnitsString(player2UnitsAddable));
            }
            else{
                player1UnitsAddable.add(new Infantry(1,0,0));
                addableUnits.setText(getUnitsString(player1UnitsAddable));
            }
        });
        spearman = findViewById(R.id.spearman);
        spearman.setOnClickListener(view -> {
            if(playerSwitch.isChecked()){
                player2UnitsAddable.add(new Infantry(2,0,0));
                addableUnits.setText(getUnitsString(player2UnitsAddable));
            }
            else{
                player1UnitsAddable.add(new Infantry(2,0,0));
                addableUnits.setText(getUnitsString(player1UnitsAddable));
            }
        });
        hatchetman = findViewById(R.id.hatchetman);
        hatchetman.setOnClickListener(view -> {
            if(playerSwitch.isChecked()){
                player2UnitsAddable.add(new Infantry(3,0,0));
                addableUnits.setText(getUnitsString(player2UnitsAddable));
            }
            else{
                player1UnitsAddable.add(new Infantry(3,0,0));
                addableUnits.setText(getUnitsString(player1UnitsAddable));
            }
        });
        crossbow = findViewById(R.id.crossbow);
        crossbow.setOnClickListener(view -> {
            if(playerSwitch.isChecked()){
                player2UnitsAddable.add(new Archer(3,0,0));
                addableUnits.setText(getUnitsString(player2UnitsAddable));
            }
            else{
                player1UnitsAddable.add(new Archer(3,0,0));
                addableUnits.setText(getUnitsString(player1UnitsAddable));
            }
        });
        shortbow = findViewById(R.id.shortbow);
        shortbow.setOnClickListener(view -> {
            if(playerSwitch.isChecked()){
                player2UnitsAddable.add(new Archer(2,0,0));
                addableUnits.setText(getUnitsString(player2UnitsAddable));
            }
            else{
                player1UnitsAddable.add(new Archer(2,0,0));
                addableUnits.setText(getUnitsString(player1UnitsAddable));
            }
        });
        longbow = findViewById(R.id.longbow);
        longbow.setOnClickListener(view -> {
            if(playerSwitch.isChecked()){
                player2UnitsAddable.add(new Archer(1,0,0));
                addableUnits.setText(getUnitsString(player2UnitsAddable));
            }
            else{
                player1UnitsAddable.add(new Archer(1,0,0));
                addableUnits.setText(getUnitsString(player1UnitsAddable));
            }
        });
        knight = findViewById(R.id.knight);
        knight.setOnClickListener(view -> {
            if(playerSwitch.isChecked()){
                player2UnitsAddable.add(new Mounted(1,0,0));
                addableUnits.setText(getUnitsString(player2UnitsAddable));
            }
            else{
                player1UnitsAddable.add(new Mounted(1,0,0));
                addableUnits.setText(getUnitsString(player1UnitsAddable));
            }
        });
        cuirassier = findViewById(R.id.cuirrasier);
        cuirassier.setOnClickListener(view -> {
            if(playerSwitch.isChecked()){
                player2UnitsAddable.add(new Mounted(2,0,0));
                addableUnits.setText(getUnitsString(player2UnitsAddable));
            }
            else{
                player1UnitsAddable.add(new Mounted(2,0,0));
                addableUnits.setText(getUnitsString(player1UnitsAddable));
            }
        });
        archer = findViewById(R.id.mountedArcher);
        archer.setOnClickListener(view -> {
            if(playerSwitch.isChecked()){
                player2UnitsAddable.add(new Mounted(3,0,0));
                addableUnits.setText(getUnitsString(player2UnitsAddable));
            }
            else{
                player1UnitsAddable.add(new Mounted(3,0,0));
                addableUnits.setText(getUnitsString(player1UnitsAddable));
            }
        });
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
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube://" + "dQw4w9WgXcQ"));
            startActivity(intent);
        });
    }
    protected String getUnitsString(ArrayList<Unit> units){
        String out = "";
        for (Unit unit : units){
            out += unit.shortToString() + "\n";
        }
        return out;
    }

}
