package com.albertmiro.retailstore.data.db;

import android.content.Context;
import android.content.res.TypedArray;

import com.albertmiro.retailstore.R;
import com.albertmiro.retailstore.data.dbmodel.DBCategory;
import com.albertmiro.retailstore.data.dbmodel.DBProduct;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

import java.util.Random;

@EBean
public class MockData {

    @Bean
    DBManager manager;

    public void initWithData(Context context) {
        //To clean DB
//        manager.clearDB();
        if(!manager.hasData()) {
            createCategories(context);
        }
    }

    private void createCategories(Context context) {
        String[] categories = context.getResources().getStringArray(R.array.mock_categories);
        TypedArray img_categories = context.getResources().obtainTypedArray(R.array.mock_img_categories);
        for (int i = 0; i < categories.length; i++) {
            DBCategory cat = new DBCategory((long) i, categories[i], img_categories.getResourceId(i, R.mipmap.ic_launcher));
            cat.save();
            createProducts(context, cat);
        }
        img_categories.recycle();
    }

    private void createProducts(Context context, DBCategory category) {
        //All the categories share the same products
        String[] products = context.getResources().getStringArray(R.array.mock_c0_breakfast);
        TypedArray procuctsImg = context.getResources().obtainTypedArray(R.array.mock_c0_img);
        String lorem = context.getString(R.string.lorem);
        Random rand = new Random();
        for (int i = 0; i < products.length; i++) {
            DBProduct cat = new DBProduct((long) i, procuctsImg.getResourceId(i, R.mipmap.ic_launcher)
                    , products[i] + " / " + category.getName()
                    , lorem, (float) rand.nextInt(200) / 10f, category, false);
            cat.save();
        }
        procuctsImg.recycle();
    }

}
