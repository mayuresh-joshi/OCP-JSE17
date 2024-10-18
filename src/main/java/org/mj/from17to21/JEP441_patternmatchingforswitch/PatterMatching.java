package org.mj.from17to21.JEP441_patternmatchingforswitch;

public class PatterMatching {
    public static void main(String[] args) {
        Integer i = 10;
        Long l = 10L;
        Double d = 10D;
        String s = "Hello";

        System.out.println(formatter(i));
        System.out.println(formatter(l));
        System.out.println(formatter(d));
        System.out.println(formatter(s));
        System.out.println("-----------------------");
        System.out.println(formatterPatternSwitch(i));
        System.out.println(formatterPatternSwitch(l));
        System.out.println(formatterPatternSwitch(d));
        System.out.println(formatterPatternSwitch(s));
    }

    // Prior to Java 21
    static String formatter(Object obj) {
        String formatted = "unknown";
        if (obj instanceof Integer i) {
            formatted = String.format("int %d", i);
        } else if (obj instanceof Long l) {
            formatted = String.format("long %d", l);
        } else if (obj instanceof Double d) {
            formatted = String.format("double %f", d);
        } else if (obj instanceof String s) {
            formatted = String.format("String %s", s);
        }
        return formatted;
    }

    // As of Java 21
    static String formatterPatternSwitch(Object obj) {
        return switch (obj) {
            // Here 'Integer i' is the pattern, this is equivalent of 'obj instanceof Interger i'.
            case Integer i -> String.format("int %d", i);
            case Long l -> String.format("long %d", l);
            case Double d -> String.format("double %f", d);
            case String s -> String.format("String %s", s);
            default -> obj.toString();
        };
    }
}
