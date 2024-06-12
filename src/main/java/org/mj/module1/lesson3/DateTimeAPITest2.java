package org.mj.module1.lesson3;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class DateTimeAPITest2 {
    public static void main(String[] args) {
        LocalDate ld = LocalDate.now();

        // This line fails at runtime with DateTimeException as LocalDate ld does not have the necessary "time" elements from which LocalTime can be created
        //LocalTime lt = LocalTime.from(ld);

        // Another way of failing, we are trying to extract seconds from a date, but it does not have the seconds element
        //System.out.println(ld.get(ChronoField.SECOND_OF_MINUTE));

        // Before getting something we can test if it is supported
        System.out.println(ld.isSupported(ChronoField.YEAR));
        System.out.println(ld.isSupported(ChronoField.SECOND_OF_MINUTE));

        // We can add info later
        var ldt = ld.atTime(21, 20);
        System.out.println(ldt);
        System.out.println(ldt.isSupported(ChronoField.MINUTE_OF_HOUR));
        System.out.println(ldt.isSupported(ChronoField.SECOND_OF_MINUTE));
        System.out.println(ldt.getSecond());

        var ld2 = LocalDate.of(2100, 12, 11);
        var res = ld2.adjustInto(ldt);
        System.out.println(res);
        System.out.println(ld.isLeapYear());

        Period thirtyDays = Period.ofDays(30);
        LocalDate feb14 = LocalDate.of(2024, 2, 14);
        System.out.println(feb14);
        System.out.println(feb14.plus(thirtyDays));
        System.out.println(feb14.minus(thirtyDays));

        Period oneMonth = Period.ofMonths(1);
        System.out.println(feb14);
        System.out.println(feb14.plus(oneMonth));
        System.out.println(feb14.minus(oneMonth));
    }
}
