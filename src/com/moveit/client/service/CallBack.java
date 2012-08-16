package com.moveit.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.moveit.client.ApplicationException;
import com.moveit.client.language.LService;
import com.moveit.client.gui.InfoManager;

/**
 *
 */
public abstract class CallBack<T> implements AsyncCallback<T> {

    private Action retry;
    private int retries = 0;

    public void startProgressBar() {
        startProgressBar(null);
    }

    public void startProgressBar(String text) {
        InfoManager.startProgressBar(text);
    }


    public void onFailure(Throwable caught) {
        //retries a couple of times
        if(retry != null && retries++ < 2){
            Service.resend(retry, this);
            return;
        }

        InfoManager.stopProgressBar();
        if (caught instanceof ApplicationException) {
            
            InfoManager.showInfo(caught.getMessage());
            fail(caught);
        }
        else {
            InfoManager.showError(LService.ERROR_TRY_AGAIN.getTexts());
            fail(caught);
        }
    }
    

    public void setRetry(Action a){
        retry = a;
    }


    public void onSuccess(T result) {
        InfoManager.stopProgressBar();
        success(result);
    }

    public abstract void success(T result);

    public abstract void fail(Throwable t);
}
