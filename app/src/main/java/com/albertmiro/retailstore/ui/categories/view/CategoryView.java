package com.albertmiro.retailstore.ui.categories.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.albertmiro.retailstore.R;
import com.albertmiro.retailstore.data.dbmodel.DBCategory;
import com.albertmiro.retailstore.ui.categories.CategoriesActivity;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

@EViewGroup(R.layout.category_view_grid)
public class CategoryView extends FrameLayout {

    @ViewById
    ImageView picture;

    @ViewById
    TextView name;

    private DBCategory categoryItem;

    public CategoryView(@NonNull Context context) {
        super(context);
    }

    public CategoryView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }


    public void bind(DBCategory itemCategory) {
        this.categoryItem = itemCategory;
        if (itemCategory.getImageResId() != -1) {
            picture.setImageResource(itemCategory.getImageResId());
        }
        name.setText(itemCategory.getName());
    }

    @Click(R.id.picture)
    public void onPictureCliked() {
        ((CategoriesActivity) getContext()).openCategory(categoryItem);
    }

}
