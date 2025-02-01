package org.mj.enthuware_tests.test5;

import java.util.Arrays;
import java.util.List;

public class Test5 {
    public static void main(String[] args) {

        //float amount = 1000.0;  // '1000.0'  is a double literal '1000.0f' is a float literal
        double amount2 = 1000.0;

        var c = System.console(); //1
        //char[] line = c.readPassword("Please enter your pwd:"); //2
        //System.out.println("Pwd is " + new String(line));


        Character[] ca = {'b', 'c', 'a', 'e', 'd'};
        List<Character> l = Arrays.asList(ca);
        l.parallelStream().peek(System.out::print).forEachOrdered(System.out::print);

    }
}
