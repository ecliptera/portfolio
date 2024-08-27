package net.gb.knox.portfolio.utility;

public abstract class StringUtility {

    public static String sentenceCase(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }

        return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
    }
}
