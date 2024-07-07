package org.mj.module3.lesson12;

class P {
    P doStuff(int i, String s) {
        return null;
    }
}

class Q extends P {
   // @Override
        // Not a valid override
    Q doStuff(Integer i, String s) {
        return null;
    }
}

public class ImplementationInheritance {
    public static void main(String[] args) {

    }
}
