package ru.naburnm8.android.labapp.data;

public class PictureData {
    int pictureID;
    String pictureName;
    public PictureData(int pictureID, String pictureName) {
        this.pictureID = pictureID;
        this.pictureName = pictureName;
    }

    public int getPictureID() {
        return pictureID;
    }

    public void setPictureID(int pictureID) {
        this.pictureID = pictureID;
    }

    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }
}
