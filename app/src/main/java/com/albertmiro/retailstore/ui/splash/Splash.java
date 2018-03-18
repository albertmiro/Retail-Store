package com.albertmiro.retailstore.ui.splash;

import android.app.Activity;

import com.albertmiro.retailstore.R;
import com.albertmiro.retailstore.data.db.MockData;
import com.albertmiro.retailstore.ui.categories.CategoriesActivity_;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.api.UiThreadExecutor;


@EActivity(R.layout.splash_activity)
public class Splash extends Activity {

    private static final long TIME_SPLASH = 1500;

    @Bean
    MockData mockData;

    @AfterViews
    public void init() {
        mockData.initWithData(this);
        startMain();
    }

    @UiThread(id = "splash", delay = TIME_SPLASH)
    void startMain() {
        CategoriesActivity_.intent(this).start();
        finish();
    }

    @Override
    protected void onPause() {
        UiThreadExecutor.cancelAll("splash");
        super.onPause();
    }
}
