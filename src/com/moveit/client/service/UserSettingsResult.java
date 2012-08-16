package com.moveit.client.service;

import com.moveit.client.model.UserSettings;

/**
 *
 */
public class UserSettingsResult implements Result{
    private static final long serialVersionUID = 2536342536769646854L;

    private UserSettings userSettings;

    public UserSettingsResult() {
    }

    public UserSettingsResult(UserSettings userSettings) {
        this.userSettings = userSettings;
    }

    public UserSettings getUserSettings() {
        return userSettings;
    }

    public void setUserSettings(UserSettings userSettings) {
        this.userSettings = userSettings;
    }
}