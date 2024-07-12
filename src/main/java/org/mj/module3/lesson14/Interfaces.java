package org.mj.module3.lesson14;

interface A {
    Integer a = 1; // implicitly public, static and final

    default void doA(A this) { // Receiver parameter
        System.out.println("Default Method");
    }

    private void privateDoA() {
        System.out.println("Private Method");
    }

    static void staticDoA() {
        System.out.println("Static Method");
    }

    void doA2(); // public and abstract by default

    private void m5() {}; // valid

    //Instance methods not allowed without default modifier
    // public void doA3(){}
}

class AImplementor implements A {
    @Override
    public void doA2() {

    }
}

public class Interfaces {
    public static void main(String[] args) {
        AImplementor obj = new AImplementor();
        //obj.staticDoA(); // Not allowed
    }
}
