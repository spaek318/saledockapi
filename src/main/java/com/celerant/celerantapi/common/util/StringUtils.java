package com.celerant.celerantapi.common.util;


// StringUtils.java
public class StringUtils {
    public static boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    public static String defaultIfNull(String str, String defaultValue) {
        return str != null ? str : defaultValue;
    }
}
