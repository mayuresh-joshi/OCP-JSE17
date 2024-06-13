package org.mj.module1.lesson3;

import java.time.Instant;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class TimeZoneConsiderations3 {
    public static void main(String[] args) {
        Period oneYear = Period.ofYears(1);
        Period oneMonth = Period.ofMonths(1);

        ZonedDateTime febOne2020 = ZonedDateTime
                .of(2020, 2, 1, 12, 15, 30, 0, ZoneId.of("GMT"));

        ZonedDateTime marOne2020 = febOne2020.plus(oneMonth);
        ZonedDateTime febOne2021 = febOne2020.plus(oneYear);
        ZonedDateTime marOne2021 = febOne2021.plus(oneMonth);

        Instant febOne2020Inst = febOne2020.toInstant();
        Instant febOne2021Inst = febOne2021.toInstant();

        System.out.println(febOne2020Inst.until(marOne2020, ChronoUnit.DAYS));
        System.out.println(febOne2021Inst.until(marOne2021, ChronoUnit.DAYS));

        System.out.println(febOne2020Inst.until(febOne2021, ChronoUnit.DAYS));

        System.out.println(febOne2020Inst.truncatedTo(ChronoUnit.HOURS));
        System.out.println(febOne2020Inst.truncatedTo(ChronoUnit.DAYS));

    }
}
