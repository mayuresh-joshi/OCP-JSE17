package org.mj.module3.lesson8;

import java.util.Date;
import java.util.List;


class A {
    long doStuff() {
        return 1l;
    }
}

class B extends A {
    long doStuff() {
        return 2l;
    }
}

public class OverloadedAndOverriddenMethods {

    void doStuff(int i) {
        System.out.println("Primitive");
    }

    void doStuff(Integer i) {
        System.out.println("Wrapper");
    }

    //void doStuff(List<String> s) {} // Not allowed. Generics don't matter in method signature both have List<XXX> and are considered same
    void doStuff(List<Date> d) {
    }

    public static void main(String[] args) {
        OverloadedAndOverriddenMethods obj = new OverloadedAndOverriddenMethods();
        obj.doStuff(2);
        obj.doStuff(Integer.valueOf(2));
    }
}
