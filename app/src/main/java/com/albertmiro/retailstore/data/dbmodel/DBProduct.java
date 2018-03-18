package com.albertmiro.retailstore.data.dbmodel;

import com.orm.SugarRecord;

public class DBProduct extends SugarRecord {

    private Long id;

    int imageResId;
    String name;
    String description;
    float price;
    DBCategory category;

    boolean isAddedToCart;

    public DBProduct(Long id, int imageResId, String name, String description, float price, DBCategory category, boolean isAddedToCart) {
        this.id = id;
        this.imageResId = imageResId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.isAddedToCart = isAddedToCart;
    }

    public DBProduct() {
    }

    public int getImageResId() {
        return imageResId;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public DBCategory getCategory() {
        return category;
    }

    public void setCategory(DBCategory category) {
        this.category = category;
    }

    public boolean isAddedToCart() {
        return isAddedToCart;
    }

    public void setAddedToCart(boolean addedToCart) {
        isAddedToCart = addedToCart;
    }
}
