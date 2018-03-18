package com.albertmiro.retailstore.data.dbmodel;

import com.orm.SugarRecord;

public class DBCategory extends SugarRecord {

    private Long id;

    String name;
    int imageResId;

    public DBCategory(Long id, String name, int imageResId) {
        this.id = id;
        this.name = name;
        this.imageResId = imageResId;
    }

    public DBCategory(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public DBCategory() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageResId() {
        return imageResId;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }
}
