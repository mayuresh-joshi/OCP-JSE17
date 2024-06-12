package org.mj.module1.lesson3;

import java.time.Instant;
import java.time.ZoneId;

public class TimeZoneConsiderations {
    public static void main(String[] args) {

        // Printing all known timezone ids
//        ZoneId.getAvailableZoneIds().stream().sorted().forEach(System.out::println);

        // Creating zone id
        var zi = ZoneId.of("Europe/Paris");
        System.out.println(zi);

        // Printing out all rules of a zoneid
        ZoneId.of("Europe/Berlin").getRules().getTransitions().forEach(System.out::println);

        System.out.println("------------------------------------");
        // Finding out when next transition will be applicable
        System.out.println(zi.getRules().nextTransition(Instant.now()));
        System.out.println(zi.getRules().previousTransition(Instant.now()));
    }
}
