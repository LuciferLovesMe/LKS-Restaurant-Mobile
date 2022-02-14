package com.abim.lks_restaurant;

public class MyRequest {
        private static final String baseURL = "http://192.168.1.6:789/";
    private static final String loginURL = "api/member";
    private static final String viewURL = "api/viewOrder";
    private static final String fdURL = "api/fd";

    public static String getBaseURL() {
        return baseURL;
    }

    public static String getLoginURL() {
        return getBaseURL() + loginURL;
    }

    public static String getViewURL() {
        return getBaseURL() + viewURL;
    }

    public static String getFdURL() {
        return getBaseURL() + fdURL;
    }
}
