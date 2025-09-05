package com.celerant.celerantapi.common.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtils {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static String formatDateTime(LocalDateTime dateTime) {
        return dateTime != null ? dateTime.format(FORMATTER) : null;
    }

    public static LocalDateTime parseDateTime(String dateTimeString) {
        return dateTimeString != null && !dateTimeString.trim().isEmpty()
                ? LocalDateTime.parse(dateTimeString, FORMATTER)
                : null;
    }
}
