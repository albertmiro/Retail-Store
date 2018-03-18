package com.albertmiro.retailstore.ui.productdetail;

import android.app.Activity;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.albertmiro.retailstore.R;
import com.albertmiro.retailstore.data.db.DBManager;
import com.albertmiro.retailstore.data.dbmodel.DBProduct;
import com.albertmiro.retailstore.ui.shoppingcart.ShoppingCartActivity_;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.product_detail_activity)
public class ProductDetail extends Activity {

    private static final String TAG = ProductDetail.class.getSimpleName();

    @ViewById
    TextView productName;

    @ViewById
    ImageView imageView;

    @ViewById
    TextView productDescription;

    @ViewById
    TextView textPrice;

    @ViewById
    Button btnAddToCart;

    @Bean
    DBManager dbManager;

    @Extra
    long productId;

    DBProduct product;


    @Override
    protected void onResume() {
        super.onResume();
    }

    @AfterViews
    public void init() {
        product = dbManager.getProductById(productId);
        showProduct();
    }

    private void showProduct() {
        productName.setText(product.getName());
        imageView.setImageResource(product.getImageResId());
        productDescription.setText(product.getDescription());
        textPrice.setText(String.valueOf(product.getPrice() + "€"));

        updateButtonAddedToCart();
    }

    private void updateButtonAddedToCart() {
        if (product.isAddedToCart()) {
            btnAddToCart.setText(R.string.remove_from_cart);
        } else {
            btnAddToCart.setText(R.string.add_to_cart);
        }
    }

    @Click(R.id.btnAddToCart)
    public void onAddToCart() {
        Log.d(TAG, "onAddToCart: ");
        if (product.isAddedToCart()) {
            dbManager.removeProductFromCart(productId);
            product.setAddedToCart(false);
        } else {
            dbManager.addProductToCart(productId);
            product.setAddedToCart(true);
        }
        updateButtonAddedToCart();
    }

    @Click(R.id.shoppingCart)
    public void openCart() {
        ShoppingCartActivity_.intent(this).start();
    }

}
