package com.moveit.client.gui;

import com.google.gwt.user.client.Timer;
import com.moveit.client.guicomponents.*;

/**
 *
 */
public class InfoManager {
    private static PopupInfo dropDown = new PopupInfo();
    private static PopupProgressBar progressBar = new PopupProgressBar();

    private static Timer timer;

    public static void startProgressBar(String text) {
        clear();
        progressBar.start(text);
    }

    public static void stopProgressBar() {
        progressBar.stop();
    }


    public static void hideInfo() {
        stopTimer();
        dropDown.hide();
        PopupManager.setBorder(PopupInfo.InfoLevel.SUCCES);
    }



    public static void showInfo(String... msg) {
        clear();
        dropDown.show(PopupInfo.InfoLevel.INFO, msg);
        startTimer(10000);
    }

    public static void showSucces(String... msg) {
        clear();
        dropDown.show(PopupInfo.InfoLevel.SUCCES, msg);
        startTimer(5000);
    }

    public static void showError(String... msg) {
        clear();
        dropDown.show(PopupInfo.InfoLevel.ERROR, msg);
    }

    private static void clear() {
        stopTimer();
        progressBar.stop();
        hideInfo();
    }

    private static void stopTimer() {
        if (timer != null) {
            timer.cancel();
        }
    }

    private static void startTimer(int time) {
        timer = new Timer() {
            @Override
            public void run() {
                hideInfo();
            }
        };
        timer.schedule(time);
    }


}
