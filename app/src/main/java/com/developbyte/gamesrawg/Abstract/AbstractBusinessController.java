package com.developbyte.gamesrawg.Abstract;

import android.app.Activity;

import com.developbyte.gamesrawg.Interfaces.IMementoHandler;

public abstract class AbstractBusinessController {

    protected IMementoHandler mementoHandler;
    protected Activity activity;

    public void setMementoHandler(IMementoHandler mementoHandler) {
        this.mementoHandler = mementoHandler;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }
}