package com.albertmiro.retailstore.ui.products.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.albertmiro.retailstore.R;
import com.albertmiro.retailstore.data.dbmodel.DBProduct;
import com.albertmiro.retailstore.ui.products.ProductsActivity;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

@EViewGroup(R.layout.product_view_grid)
public class ProductView extends FrameLayout {

    @ViewById
    ImageView picture;

    @ViewById
    TextView name;

    private DBProduct itemProduct;

    public ProductView(@NonNull Context context) {
        super(context);
    }

    public ProductView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }


    public void bind(DBProduct itemProduct) {
        this.itemProduct = itemProduct;
        if (itemProduct.getImageResId() != -1) {
            picture.setImageResource(itemProduct.getImageResId());
        }
        name.setText(itemProduct.getName());
    }

    @Click(R.id.picture)
    public void onPictureCliked() {
        ((ProductsActivity) getContext()).openProduct(itemProduct);
    }

}
