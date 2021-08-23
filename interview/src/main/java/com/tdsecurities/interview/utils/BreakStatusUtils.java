package com.tdsecurities.interview.utils;


public class BreakStatusUtils {

    public static String findBreakStatus(long msPc) {
        long absMsPc = Math.abs(msPc);
        if (absMsPc > 100000) {
            return "100000+";
        } else if (absMsPc >= 10000) {
            return "10000-99999";
        } else if (absMsPc >= 1000) {
            return "1000-9999";
        } else if (absMsPc >= 100) {
            return "100-999";
        } else if (absMsPc >= 0) {
            return "0-99";
        } else {
            return null;
        }
    }
}
