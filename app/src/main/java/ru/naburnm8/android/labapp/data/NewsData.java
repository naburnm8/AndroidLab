package ru.naburnm8.android.labapp.data;

import ru.naburnm8.android.labapp.R;

import java.io.Serializable;
import java.util.Calendar;

public class NewsData implements Serializable {
    int pictureID;
    String author;
    String title;
    String content;
    String date;
    public NewsData(int pictureID, String author, String title, String content) {
        this.pictureID = pictureID;
        this.author = author;
        this.title = title;
        this.content = content;
        Calendar now = Calendar.getInstance();
        date = String.valueOf(now.getTime());
    }
    public NewsData(String author, String title, String content) {
        this.author = author;
        this.title = title;
        this.content = content;
        Calendar now = Calendar.getInstance();
        date = String.valueOf(now.getTime());
        pictureID = R.drawable.ic_launcher_background;
    }
    public NewsData(int pictureID, String author, String title, String content, String date) {
        this.pictureID = pictureID;
        this.author = author;
        this.title = title;
        this.content = content;
        this.date = date;
    }

    public int getPictureID() {
        return pictureID;
    }

    public void setPictureID(int pictureID) {
        this.pictureID = pictureID;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
