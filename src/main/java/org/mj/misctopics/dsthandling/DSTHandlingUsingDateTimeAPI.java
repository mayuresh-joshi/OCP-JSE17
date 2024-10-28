package org.mj.misctopics.dsthandling;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class DSTHandlingUsingDateTimeAPI {
    public static void main(String[] args) {

        // ref - https://www.baeldung.com/java-daylight-savings

        // LocalDateTime does not have any zone related info and can't handle DST
        LocalDateTime localDateTimeBeforeDST = LocalDateTime
                .of(2018, 3, 25, 1, 55);

        System.out.println("LocalDateTime: " + localDateTimeBeforeDST);
        System.out.println(localDateTimeBeforeDST.toString().equals("2018-03-25T01:55"));

        // Converting it to ZonedDateTime which can handle DST
        ZoneId italianZoneId = ZoneId.of("Europe/Rome");
        ZonedDateTime zonedDateTimeBeforeDST = localDateTimeBeforeDST
                .atZone(italianZoneId);

        System.out.println("ZonedDateTime before DST: " + zonedDateTimeBeforeDST);
        System.out.println(zonedDateTimeBeforeDST.toString().equals("2018-03-25T01:55+01:00[Europe/Rome]"));

        // Let’s trigger DST through the addition of ten minutes,
        // as DST is scheduled @ 02:00 in Europe/Rome TZ on 2018-03-25
        ZonedDateTime zonedDateTimeAfterDST = zonedDateTimeBeforeDST
                .plus(10, ChronoUnit.MINUTES);

        // After adding 10 min time became 02:05 and DST was scheduled at 02:00 for this TZ, so DST shift was done
        // and time became 03:05, after adding +1 hour for DST
        System.out.println("ZonedDateTime after DST(adding 10 mins): " + zonedDateTimeAfterDST);
        System.out.println(zonedDateTimeAfterDST.toString().equals("2018-03-25T03:05+02:00[Europe/Rome]"));

        // Addition/Subtraction operations will be handled by DST as well
        Long deltaBetweenDatesInMinutes = ChronoUnit.MINUTES
                .between(zonedDateTimeBeforeDST, zonedDateTimeAfterDST);

        System.out.println(zonedDateTimeBeforeDST + " - " + zonedDateTimeAfterDST + " = " + deltaBetweenDatesInMinutes);
        System.out.println(deltaBetweenDatesInMinutes.equals(10L));
    }
}
