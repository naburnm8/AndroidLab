package ru.naburnm8.android.labapp.baumansgate.misc;

public class Point {
    int x;
    int y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    @Override
    public String toString(){
        return this.x + "," + this.y;
    }
}
