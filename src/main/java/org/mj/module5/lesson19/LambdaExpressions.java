package org.mj.module5.lesson19;

import java.util.function.Predicate;

public class LambdaExpressions {
    public static void main(String[] args) {
        Predicate<String> prd = ((Predicate<String>) s -> s.length() > 3)
                .and(s -> s.startsWith("M"));

        System.out.println(prd.test("MJ"));
        System.out.println(prd.test("Mayuresh"));
    }
}
