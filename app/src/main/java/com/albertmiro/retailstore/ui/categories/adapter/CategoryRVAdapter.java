package com.albertmiro.retailstore.ui.categories.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.albertmiro.retailstore.data.dbmodel.DBCategory;
import com.albertmiro.retailstore.ui.categories.view.CategoryView;
import com.albertmiro.retailstore.ui.categories.view.CategoryView_;
import com.albertmiro.retailstore.utils.rv.RecyclerViewAdapterBase;
import com.albertmiro.retailstore.utils.rv.ViewWrapper;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

@EBean
public class CategoryRVAdapter extends RecyclerViewAdapterBase<DBCategory, CategoryView> {

    private static final String TAG = CategoryRVAdapter.class.getSimpleName();

    @RootContext
    Context context;

    @Override
    protected CategoryView onCreateItemView(ViewGroup parent, int viewType) {
        CategoryView view = CategoryView_.build(context);
        return view;
    }

    @Override
    public void onBindViewHolder(ViewWrapper<CategoryView> holder, int position) {
        CategoryView categoryView = holder.getView();
        DBCategory itemCategories = items.get(position);
        categoryView.bind(itemCategories);
    }

}