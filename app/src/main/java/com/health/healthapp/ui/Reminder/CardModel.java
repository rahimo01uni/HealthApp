package com.health.healthapp.ui.Reminder;

public class CardModel {
    private String title, remider,leftdays;

    public CardModel(String title, String remider, String leftdays) {
        this.title = title;
        this.remider = remider;
        this.leftdays = leftdays;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRemider() {
        return remider;
    }

    public void setRemider(String remider) {
        this.remider = remider;
    }

    public String getLeftdays() {
        return leftdays;
    }

    public void setLeftdays(String leftdays) {
        this.leftdays = leftdays;
    }
}
