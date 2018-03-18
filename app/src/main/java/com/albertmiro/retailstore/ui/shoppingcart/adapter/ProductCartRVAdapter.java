package com.albertmiro.retailstore.ui.shoppingcart.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.albertmiro.retailstore.data.dbmodel.DBProduct;
import com.albertmiro.retailstore.ui.shoppingcart.view.ProductCartView;
import com.albertmiro.retailstore.ui.shoppingcart.view.ProductCartView_;
import com.albertmiro.retailstore.utils.rv.RecyclerViewAdapterBase;
import com.albertmiro.retailstore.utils.rv.ViewWrapper;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

@EBean
public class ProductCartRVAdapter extends RecyclerViewAdapterBase<DBProduct, ProductCartView> {

    private static final String TAG = ProductCartRVAdapter.class.getSimpleName();

    @RootContext
    Context context;

    @Override
    protected ProductCartView onCreateItemView(ViewGroup parent, int viewType) {
        ProductCartView view = ProductCartView_.build(context);
        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        return view;
    }

    @Override
    public void onBindViewHolder(ViewWrapper<ProductCartView> holder, int position) {
        ProductCartView productCartView = holder.getView();
        DBProduct itemProduct = items.get(position);
        productCartView.bind(itemProduct);
    }

}