package com.health.healthapp.ui.home;

public class LogModel {
    String name,category,Time,status;
    int img;
    public LogModel(String name, String category, String time, int img,String status) {
        this.name = name;
        this.category = category;
        this.Time = time;
        this.img = img;
        this.status=status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int  img) {
        this.img = img;
    }

    public LogModel() {
    }
}
