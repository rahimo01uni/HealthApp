package com.health.healthapp.ui.Team;

public class Group {
    private String Title;
    private int Img;

    public Group(){

    }

    public Group(String title, int img){
        Title = title;
        Img = img;
    }

    public String getTitle() {
        return Title;
    }

    public int getImg() {
        return Img;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setImg(int img) {
        Img = img;
    }
}
