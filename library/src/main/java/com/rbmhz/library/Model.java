package com.rbmhz.library;

import android.content.Context;

public class Model {
    String Title;
    String Body;
    Context context;
    boolean ShowProgressBar;

    public Model(String title, String body, Context context,boolean showProgressBar) {
        Title = title;
        Body = body;
        ShowProgressBar = showProgressBar;
        this.context = context;
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
