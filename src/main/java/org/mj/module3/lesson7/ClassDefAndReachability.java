package org.mj.module3.lesson7;

public class ClassDefAndReachability {
    static {
        System.out.println("Hello from static initializer");
    }

    {
        System.out.println("Hello form instance initializer");
    }

    static class A {  // Nested class
    }

    class B {  // Inner class
    }

    static enum X {}

    static interface Y {
    }

    final static record Z() {
    }

    public static void main(String[] args) {

    }
}
