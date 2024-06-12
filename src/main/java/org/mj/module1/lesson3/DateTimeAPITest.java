package org.mj.module1.lesson3;

import java.time.*;
import java.time.temporal.ChronoField;

public class DateTimeAPITest {
    public static void main(String[] args) {

        //Part 1
        // Absolute moment in time/history. This gets the 'zulu' time
        Instant i1 = Instant.now();
        System.out.println("Current Absolute time: " + i1);

        // Print Kolkata time
        ZonedDateTime zdt = ZonedDateTime.ofInstant(i1, ZoneId.of("Asia/Kolkata"));
        System.out.println("Current time in Kolkata timezone: " + zdt);

        // Print Denver time
        zdt = ZonedDateTime.ofInstant(i1, ZoneId.of("America/Denver"));
        System.out.println("Currenttime in Denver timezone: " + zdt);

        // Creating LocalDateTime
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println("Current System local time: " + ldt);

        // Creating Duration
        Duration dur = Duration.ofMinutes(30);
        System.out.println("Duration of 30 mins: " + dur);

        Duration dur2 = Duration.ofMinutes(300);
        System.out.println("Duration of 300 mins: " + dur2);

        Duration dur3 = Duration.ofMinutes(305);
        System.out.println("Duration of 305 mins: " + dur3);

        // Creating Period
        Period p = Period.of(1, 14, 540);
        System.out.println("Period: " + p);

        // Normalization does not normalize DAYS!
        System.out.println("Period (Normalized) : " + p.normalized());


        // Part 2
        LocalDate ld = LocalDate.of(2030, 9, 29);
        System.out.println(ld);
        System.out.println(ld.getMonth());

        // Adding 10 days
        LocalDate ld2 = ld.plusDays(10);
        System.out.println(ld2);

        System.out.println(ld.with(ChronoField.MONTH_OF_YEAR, 10));

        var ld3 = LocalDate.parse("1997-09-29");
        System.out.println(ld3);

        LocalDateTime ldt1 = LocalDateTime.now();
        LocalDate ld4 = LocalDate.from(ldt1);
        System.out.println(ld4);
    }
}
