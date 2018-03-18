package com.albertmiro.retailstore.data.db;

import com.albertmiro.retailstore.data.dbmodel.DBCategory;
import com.albertmiro.retailstore.data.dbmodel.DBProduct;

import org.androidannotations.annotations.EBean;

import java.util.List;

import static com.orm.SugarRecord.findById;

@EBean(scope = EBean.Scope.Singleton)
public class DBManager {

    public List<DBProduct> getAllProducts() {
        return DBProduct.listAll(DBProduct.class);
    }

    public List<DBProduct> getAllProductsByCategory(long idCategory) {
        return DBProduct.find(DBProduct.class, "category = ?", String.valueOf(idCategory));
    }

    public List<DBCategory> getAllCategories() {
        return DBCategory.listAll(DBCategory.class);
    }


    public void clearDB() {
        DBProduct.deleteAll(DBProduct.class);
        DBCategory.deleteAll(DBCategory.class);
    }

    public DBProduct getProductById(long productId) {
        return findById(DBProduct.class, productId);
    }

    public void addProductToCart(long productId) {
        //TODO: Just adding 1 product, no considering that the user can add more than one
        DBProduct dbProduct = DBProduct.findById(DBProduct.class, productId);
        dbProduct.setAddedToCart(true);
        dbProduct.save();
    }

    public void removeProductFromCart(long productId) {
        //TODO: Just adding 1 product, no considering that the user can add more than one
        DBProduct dbProduct = DBProduct.findById(DBProduct.class, productId);
        dbProduct.setAddedToCart(false);
        dbProduct.save();
    }

    public List<DBProduct> getAllProductsAtCart() {
        return DBProduct.find(DBProduct.class, "is_added_to_cart = ?", "1");
    }

    public boolean hasData() {
        return DBProduct.count(DBProduct.class) > 0;
    }
}
