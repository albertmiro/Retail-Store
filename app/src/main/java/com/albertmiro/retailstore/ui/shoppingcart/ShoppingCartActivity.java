package com.albertmiro.retailstore.ui.shoppingcart;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.albertmiro.retailstore.R;
import com.albertmiro.retailstore.data.db.DBManager;
import com.albertmiro.retailstore.data.dbmodel.DBProduct;
import com.albertmiro.retailstore.ui.productdetail.ProductDetail_;
import com.albertmiro.retailstore.ui.shoppingcart.adapter.ProductCartRVAdapter;
import com.albertmiro.retailstore.ui.shoppingcart.adapter.ProductCartRVAdapter_;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.text.DecimalFormat;
import java.util.List;

@EActivity(R.layout.shopping_cart_activity)
public class ShoppingCartActivity extends Activity {

    private static final String TAG = ShoppingCartActivity.class.getSimpleName();

    @ViewById
    RecyclerView recyclerView;

    @ViewById
    TextView price;

    @ViewById
    TextView textNoProducts;

    @Bean
    DBManager dbManager;

    List<DBProduct> products;
    ProductCartRVAdapter adapter;

    @AfterViews
    public void init() {
        initRecyclerView();
    }

    private void initRecyclerView() {
        adapter = ProductCartRVAdapter_.getInstance_(this);
        products = dbManager.getAllProductsAtCart();
        adapter.pushItems(products);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        updatePrice();

        updateLabelNoProducts();
    }

    private void updateLabelNoProducts() {
        if (products.size() == 0) {
            textNoProducts.setVisibility(View.VISIBLE);
        } else {
            textNoProducts.setVisibility(View.GONE);
        }
    }

    public void openProduct(DBProduct itemProduct) {
        Log.d(TAG, "openProduct: ");
        ProductDetail_.intent(this).productId(itemProduct.getId()).start();
    }

    public void removeItem(DBProduct itemProduct) {
        dbManager.removeProductFromCart(itemProduct.getId());
        products = dbManager.getAllProductsAtCart();
        adapter.pushItems(products);
        adapter.notifyDataSetChanged();

        updatePrice();

        updateLabelNoProducts();
    }

    private void updatePrice() {
        float totalPrice = 0f;
        for (DBProduct product : products) {
            totalPrice += product.getPrice();
        }

        DecimalFormat df = new DecimalFormat("#.##");
        price.setText(df.format(totalPrice) + " €");
    }

}
