package com.albertmiro.retailstore.ui.categories;

import android.app.Activity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.albertmiro.retailstore.R;
import com.albertmiro.retailstore.data.db.DBManager;
import com.albertmiro.retailstore.data.dbmodel.DBCategory;
import com.albertmiro.retailstore.ui.categories.adapter.CategoryRVAdapter_;
import com.albertmiro.retailstore.ui.products.ProductsActivity_;
import com.albertmiro.retailstore.ui.shoppingcart.ShoppingCartActivity_;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.categories_activity)
public class CategoriesActivity extends Activity {

    private static final int GRID_SIZE = 2;
    private static final String TAG = CategoriesActivity.class.getSimpleName();

    @ViewById
    RecyclerView recyclerView;

    @Bean
    DBManager dbManager;

    @AfterViews
    public void init() {

        initRecyclerView();
    }

    private void initRecyclerView() {

        CategoryRVAdapter_ adapter = CategoryRVAdapter_.getInstance_(this);
        adapter.pushItems(dbManager.getAllCategories());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, GRID_SIZE));
        recyclerView.setHasFixedSize(true);
    }

    public void openCategory(DBCategory item) {
        Log.d(TAG, "openCategory: " + item.getName());
        ProductsActivity_.intent(this).idCategory(item.getId()).start();
    }

    @Click(R.id.shoppingCart)
    public void openCart() {
        ShoppingCartActivity_.intent(this).start();
    }

}
