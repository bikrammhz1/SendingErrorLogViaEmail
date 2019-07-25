package com.rbmhz.library;

import android.content.Context;

public class Model {
    String Title;
    String Body;
    Context context;
    boolean ShowProgressBar;
    boolean ShowToast;

    public Model(String title, String body, Context context,boolean showProgressBar,boolean showToast) {
        Title = title;
        Body = body;
        ShowProgressBar = showProgressBar;
        ShowToast = showToast;
        this.context = context;
    }

    public boolean isShowToast() {
        return ShowToast;
    }

    public boolean getProgressBar() {
        return ShowProgressBar;
    }

    public String getTitle() {
        return Title;
    }

    public String getBody() {
        return Body;
    }

    public Context getContext() {
        return context;
    }
}
