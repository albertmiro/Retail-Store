package com.albertmiro.retailstore.ui.products.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.albertmiro.retailstore.data.dbmodel.DBProduct;
import com.albertmiro.retailstore.ui.products.view.ProductView;
import com.albertmiro.retailstore.ui.products.view.ProductView_;
import com.albertmiro.retailstore.utils.rv.RecyclerViewAdapterBase;
import com.albertmiro.retailstore.utils.rv.ViewWrapper;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

@EBean
public class ProductRVAdapter extends RecyclerViewAdapterBase<DBProduct, ProductView> {

    private static final String TAG = ProductRVAdapter.class.getSimpleName();

    @RootContext
    Context context;

    @Override
    protected ProductView onCreateItemView(ViewGroup parent, int viewType) {
        ProductView view = ProductView_.build(context);
        return view;
    }

    @Override
    public void onBindViewHolder(ViewWrapper<ProductView> holder, int position) {
        ProductView productView = holder.getView();
        DBProduct itemProduct = items.get(position);
        productView.bind(itemProduct);
    }

}