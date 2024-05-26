package ru.naburnm8.android.labapp.data;

import java.io.Serializable;

public class UserData implements Serializable {
    private String nickname;
    private String dateOfRegistration;
    private String winPercent;
    private String favouriteUnitType;
    private String status;
    public UserData(String nickname, String dateOfRegistration, String winPercent, String favouriteUnitType) {
        this.nickname = nickname;
        this.dateOfRegistration = dateOfRegistration;
        this.winPercent = winPercent;
        this.favouriteUnitType = favouriteUnitType;
        this.status = "Player";
    }
    public UserData(String nickname, String dateOfRegistration) {
        this.nickname = nickname;
        this.dateOfRegistration = dateOfRegistration;
        this.winPercent = "0%";
        this.favouriteUnitType = "None";
        this.status = "Observer";
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getDateOfRegistration() {
        return dateOfRegistration;
    }

    public void setDateOfRegistration(String dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
    }

    public String getWinPercent() {
        return winPercent;
    }

    public void setWinPercent(String winPercent) {
        this.winPercent = winPercent;
    }

    public String getFavouriteUnitType() {
        return favouriteUnitType;
    }

    public void setFavouriteUnitType(String favouriteUnitType) {
        this.favouriteUnitType = favouriteUnitType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
