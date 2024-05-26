package ru.naburnm8.android.labapp.data;

import java.io.Serial;
import java.io.Serializable;

public class BattleData implements Serializable {

    private String player1;
    private String player2;
    private String date;
    private String p1Inventory = "";
    private String p2Inventory = "";
    private String mapName = "";
    private String turns = "";

    public BattleData(String player1, String player2, String date) {
        this.player1 = player1;
        this.player2 = player2;
        this.date = date;
    }
    public BattleData(String player1, String player2, String date, String p1Inventory, String p2Inventory, String mapName, String turns) {
        this.player1 = player1;
        this.player2 = player2;
        this.date = date;
        this.p1Inventory = p1Inventory;
        this.p2Inventory = p2Inventory;
        this.mapName = mapName;
        this.turns = turns;
    }

    public String getPlayer1() {
        return player1;
    }

    public void setPlayer1(String player1) {
        this.player1 = player1;
    }

    public String getPlayer2() {
        return player2;
    }

    public void setPlayer2(String player2) {
        this.player2 = player2;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getP1Inventory() {
        return p1Inventory;
    }

    public void setP1Inventory(String p1Inventory) {
        this.p1Inventory = p1Inventory;
    }

    public String getP2Inventory() {
        return p2Inventory;
    }

    public void setP2Inventory(String p2Inventory) {
        this.p2Inventory = p2Inventory;
    }

    public String getMapName() {
        return mapName;
    }

    public void setMapName(String mapName) {
        this.mapName = mapName;
    }

    public String getTurns() {
        return turns;
    }

    public void setTurns(String turns) {
        this.turns = turns;
    }

    @Override
    public String toString() {
        return "BattleData{" +
                "player1='" + player1 + '\'' +
                ", player2='" + player2 + '\'' +
                ", date='" + date + '\'' +
                ", p1Inventory='" + p1Inventory + '\'' +
                ", p2Inventory='" + p2Inventory + '\'' +
                ", mapName='" + mapName + '\'' +
                ", turns=" + turns +
                '}';
    }
}
