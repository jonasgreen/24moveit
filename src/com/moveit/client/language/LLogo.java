package com.moveit.client.language;

/**
 *
 */
public class LLogo extends LanguagePage{
    private static final long serialVersionUID = -8485438864079345776L;

    public LLogo() {
    }

    public LLogo(String danish, String english, String german, String french) {
        super(danish, english, german, french);
    }


    //0 = dansk, 1 = engelsk, 2 = tysk, 3 = fransk.

    public static LLogo SIGN_IN = new LLogo("Log på", "Log in", "", "");
    public static LLogo SIGN_UP = new LLogo("Opret gratis konto", "Create free account", "", "");
    public static LLogo LOG_OFF = new LLogo("Log ud", "Log out", "", "");



}