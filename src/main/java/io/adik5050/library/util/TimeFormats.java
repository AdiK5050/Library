package io.adik5050.library.util;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class TimeFormats {

    private final LocalDateTime dateTime = LocalDateTime.now();
    private final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd-MMM-uuuu");
    private final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("hh-mm-a");

    public String getDate() {
        return dateTime.format(DATE_FORMAT);
    }

    public String getTime() {
        return dateTime.format(TIME_FORMAT);
    }
}
