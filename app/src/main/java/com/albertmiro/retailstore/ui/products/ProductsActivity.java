package com.albertmiro.retailstore.ui.products;

import android.app.Activity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.albertmiro.retailstore.R;
import com.albertmiro.retailstore.data.db.DBManager;
import com.albertmiro.retailstore.data.dbmodel.DBProduct;
import com.albertmiro.retailstore.ui.productdetail.ProductDetail_;
import com.albertmiro.retailstore.ui.products.adapter.ProductRVAdapter;
import com.albertmiro.retailstore.ui.products.adapter.ProductRVAdapter_;
import com.albertmiro.retailstore.ui.shoppingcart.ShoppingCartActivity_;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.products_activity)
public class ProductsActivity extends Activity {

    private static final String TAG = ProductsActivity.class.getSimpleName();

    private static final int GRID_SIZE = 2;

    @ViewById
    RecyclerView recyclerView;

    @Bean
    DBManager dbManager;

    @Extra
    long idCategory;

    @AfterViews
    public void init() {
        initRecyclerView();
    }

    private void initRecyclerView() {

        ProductRVAdapter adapter = ProductRVAdapter_.getInstance_(this);
        adapter.pushItems(dbManager.getAllProductsByCategory(idCategory));
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, GRID_SIZE));
        recyclerView.setHasFixedSize(true);
    }

    public void openProduct(DBProduct itemProduct) {
        ProductDetail_.intent(this).productId(itemProduct.getId()).start();
        Log.d(TAG, "openProduct: ");
    }

    @Click(R.id.shoppingCart)
    public void openCart() {
        ShoppingCartActivity_.intent(this).start();
    }
}
