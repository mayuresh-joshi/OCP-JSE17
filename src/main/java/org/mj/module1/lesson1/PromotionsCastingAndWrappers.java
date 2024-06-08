package org.mj.module1.lesson1;

public class PromotionsCastingAndWrappers {
    public static void main(String[] args) {
        Integer i = 10;
        Integer j = 10;
        
        System.out.println(i == j);
        System.out.println(i.equals(j));

        //Long bad = 99; // fails int primitive to Long
        Long good = 99L; // long primitive to Long

        // Special case in Double and Float classes - Can parse below string and other string will throw NumberFormatExceptions
        System.out.println(Double.parseDouble("Infinity"));
        System.out.println(Double.parseDouble("+Infinity"));
        System.out.println(Double.parseDouble("-Infinity"));
        System.out.println(Double.parseDouble("NaN"));
        System.out.println(Float.parseFloat("Infinity"));
        System.out.println(Float.parseFloat("+Infinity"));
        System.out.println(Float.parseFloat("-Infinity"));
        System.out.println(Float.parseFloat("NaN"));

        // Available for both Float and Double
        System.out.println(Double.isInfinite(Double.parseDouble("Infinity"))); // isFinite and isNan is also available
    }
}
