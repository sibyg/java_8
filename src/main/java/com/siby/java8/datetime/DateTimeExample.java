package com.siby.java8.datetime;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;

public class DateTimeExample {

    public static void main(String... args) {
        LocalDate now = LocalDate.now();
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        LocalDate previousMonth = LocalDate.now().minusMonths(1);

        LocalTime localTime = LocalTime.now();
        localTime.getHour();

        LocalDateTime localDateTime = LocalDateTime.now();

        Set<String> allZoneIds = ZoneId.getAvailableZoneIds();

        ZonedDateTime zonedDateTime = ZonedDateTime.now();

        // period with date
        Period.ofDays(1);

        // duration with time
        Duration.ofHours(1);
    }
}
