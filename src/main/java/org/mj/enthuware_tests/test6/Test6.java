package org.mj.enthuware_tests.test6;


import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

interface Device {
    public abstract void switchOn();
}

abstract class Router /* LOCATION 1 */ {    /* LOCATION 2 */
    public void switchOn() {
    }

    public abstract void reset();
}

class MimoRouter extends Router implements Device {
    /* LOCATION 3 */
    public void reset() {
    }
}


class Booby extends Object {
}

class Dooby extends Booby {
}

class Tooby extends Dooby {
}

public class Test6 {

    static List<? super Dooby> dV; // = //code for initialization
    static List<? extends Booby> bV; //= //code for initialization

    public static void main(String[] args) {
        //dV.add(new Tooby() {});
        //bV.add(new Dooby());


        Float f = null;
        try {
            f = Float.valueOf("12.3");
            String s = f.toString();
            int i = Integer.parseInt(s);
            System.out.println("" + i);
        } catch (Exception e) {
            System.out.println("trouble : " + f);
        }

        List<String> ls = Arrays.asList("Tom Cruise", "Tom Hart", "Tom Hanks", "Tom Brady");
        Predicate<String> p = str -> {
            System.out.println("Looking...");
            return str.indexOf("Tom") > -1;
        };
        boolean flag = ls.stream().filter(str -> str.length() > 8).allMatch(p);
    }
}
