package org.mj.module3.lesson11;

import java.io.Serializable;

public class NonDenotable {
    public static void main(String[] args) {
        String s = "Hello";
        Integer i = 99;

        var res = true ? s : i; // res is now non-denotable type
        res.compareTo(null);

        int x = 99;
        var res2 = switch (x) { // res2 is also non-denotable type
            case 99 -> s;
            default -> i;
        };
    }
}
