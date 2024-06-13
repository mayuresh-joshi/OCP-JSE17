package org.mj.module1.lesson3;

import java.time.*;

public class TimeZoneConsiderations2 {
    public static void main(String[] args) {

        // Local Date time conversions
        var ld = LocalDate.of(1997, 9, 29);
        var lt = LocalTime.of(8, 15);

        var ldt = LocalDateTime.of(ld, lt);
        System.out.println(ldt);

        var ldt2 = LocalDateTime.from(LocalDate.of(1997, 10, 12).adjustInto(ldt));
        System.out.println(ldt2);

        // Zoned Date time conversions
        var zdt = ZonedDateTime.of(ldt, ZoneId.of("Asia/Kolkata"));
        System.out.println("Time in India: " + zdt);

        Instant instant = zdt.toInstant();
        System.out.println(instant);

        var zdt2 = ZonedDateTime.ofInstant(instant, ZoneId.of("America/New_York"));
        System.out.println("Time in New York: " + zdt2);

        // Method 2 - better one

        var zdt3 = zdt.withZoneSameInstant(ZoneId.of("America/New_York"));
        System.out.println("Time in New York (better approach): " + zdt3);

        // Comparing ZonedDateTime
        System.out.println(zdt.equals(zdt2)); // Returns false
        System.out.println(zdt.toInstant().equals(zdt2.toInstant())); // Returns true

        // Moving between TimeZones
        var takeOff = ZonedDateTime.of(2030, 9, 29, 12, 0, 0, 0, ZoneId.of("Asia/Kolkata"));
        System.out.println("Takeoff, home time: " + takeOff);
        var landing = takeOff.plusHours(21).plusMinutes(30);
        System.out.println("Landing, home time: " + landing);
        System.out.println("Landing, New York time: " + landing.withZoneSameInstant(ZoneId.of("America/New_York")));
    }
}
