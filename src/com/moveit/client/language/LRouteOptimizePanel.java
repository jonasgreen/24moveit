package com.moveit.client.language;


/**
 *
 */
public class LRouteOptimizePanel extends LanguagePage{
    private static final long serialVersionUID = -452087752133152072L;

    public LRouteOptimizePanel() {
    }

    public LRouteOptimizePanel(String danish, String english, String german, String french) {
        super(danish, english, german, french);
    }

    //0 = dansk, 1 = engelsk, 2 = tysk, 3 = fransk.
    public static LRouteOptimizePanel KM_1 = new LRouteOptimizePanel("1 km", "1 km", "", "");
    public static LRouteOptimizePanel KM_2 = new LRouteOptimizePanel("2 km", "2 km", "", "");
    public static LRouteOptimizePanel KM_5 = new LRouteOptimizePanel("5 km", "5 km", "", "");
    public static LRouteOptimizePanel KM_10 = new LRouteOptimizePanel("10 km", "10 km", "", "");
    public static LRouteOptimizePanel KM_20 = new LRouteOptimizePanel("20 km", "20 km", "", "");
    public static LRouteOptimizePanel KM_30 = new LRouteOptimizePanel("30 km", "30 km", "", "");
    public static LRouteOptimizePanel KM_50 = new LRouteOptimizePanel("50 km", "50 km", "", "");
    public static LRouteOptimizePanel KM_75 = new LRouteOptimizePanel("75 km", "75 km", "", "");
    public static LRouteOptimizePanel KM_100 = new LRouteOptimizePanel("100 km", "100 km", "", "");
    public static LRouteOptimizePanel KM_150 = new LRouteOptimizePanel("150 km", "150 km", "", "");
    public static LRouteOptimizePanel KM_200 = new LRouteOptimizePanel("200 km", "200 km", "", "");
    public static LRouteOptimizePanel KM_300 = new LRouteOptimizePanel("300 km", "300 km", "", "");

    public static LRouteOptimizePanel JOB_1 = new LRouteOptimizePanel("1 job", "1 request", "", "");
    public static LRouteOptimizePanel JOB_2 = new LRouteOptimizePanel("2 job", "2 requests", "", "");
    public static LRouteOptimizePanel JOB_3 = new LRouteOptimizePanel("3 job", "3 requests", "", "");
    public static LRouteOptimizePanel JOB_4 = new LRouteOptimizePanel("4 job", "4 requests", "", "");

    public static LRouteOptimizePanel MAX_JOBS = new LRouteOptimizePanel("Maksimale antal job", "Maximum number of requests", "", "");
    public static LRouteOptimizePanel MAX_KM_BETWEEN_JOBS = new LRouteOptimizePanel("Maksimale antal km mellem job", "Maximum km between requests", "", "");

    public static LRouteOptimizePanel FIND_JOBS_TITLE_SHOW = new LRouteOptimizePanel("Find job på ruten (vis)", "Find requests on your route (show)", "", "");
    public static LRouteOptimizePanel FIND_JOBS_TITLE_HIDE = new LRouteOptimizePanel("Find job på ruten (skjul)", "Find requests on your route (hide)", "", "");

    public static LRouteOptimizePanel SEARCH_BUTTON = new LRouteOptimizePanel("Søg", "Search", "", "");

    public static LRouteOptimizePanel FROM = new LRouteOptimizePanel("Fra", "From", "", "");
    public static LRouteOptimizePanel TO = new LRouteOptimizePanel("Til", "To", "", "");

}