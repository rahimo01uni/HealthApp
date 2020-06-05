package com.health.healthapp.main;

public class note_model {
    //ID,Category,Subcategory,naME,Value,date,time,status.NOTE
    int id;
    String category,subcategory,name,value,date,time,status,note;
   public note_model(){}
    public note_model(int id, String category, String subcategory, String name, String value, String date, String time, String status, String note) {
        this.id = id;
        this.category = category;
        this.subcategory = subcategory;
        this.name = name;
        this.value = value;
        this.date = date;
        this.time = time;
        this.status = status;
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
