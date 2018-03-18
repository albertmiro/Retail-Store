package com.albertmiro.retailstore.ui.shoppingcart.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.albertmiro.retailstore.R;
import com.albertmiro.retailstore.data.dbmodel.DBProduct;
import com.albertmiro.retailstore.ui.shoppingcart.ShoppingCartActivity;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

@EViewGroup(R.layout.product_cart_view)
public class ProductCartView extends FrameLayout implements View.OnClickListener {

    @ViewById
    ImageView picture;

    @ViewById
    TextView name;

    private DBProduct itemProduct;

    public ProductCartView(@NonNull Context context) {
        super(context);
    }

    public ProductCartView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public void bind(DBProduct itemProduct) {
        this.itemProduct = itemProduct;
        if (itemProduct.getImageResId() != -1) {
            picture.setImageResource(itemProduct.getImageResId());
        }
        name.setText(itemProduct.getName() + " - " + itemProduct.getPrice() + "€");

        setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        ((ShoppingCartActivity) getContext()).openProduct(itemProduct);
    }

    @Click(R.id.removeItem)
    public void removeItem() {
        ((ShoppingCartActivity) getContext()).removeItem(itemProduct);
    }


}
