package org.mj.randomtesting;


interface iA {
    int a = 1;

    private void asd() {
    }

    static void asd2() {
    }

    default void asd3() {
    }

    private static void asd4() {
    }
}

class A {
    static void doSomething() {
        System.out.println("Class A");
    }
}

class B extends A {
    static void doSomething() {
        System.out.println("Class B");
    }
}

public class Test {
    public static void main(String[] args) {
        A.doSomething();
        B.doSomething();
        int a = iA.a;
    }
}
