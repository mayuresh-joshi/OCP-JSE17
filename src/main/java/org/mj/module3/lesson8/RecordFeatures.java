package org.mj.module3.lesson8;


record X(int a, String b) {

    // Canonical constructor, names of canonical constructor must match the component names exactly, otherwise comp error
    X(int a, String b) {
        System.out.println("From Canonical Constructor");
        this.a = a;
        this.b = b;
    }

    // Additional constructors allowed
    X() {
        this(1, "Default"); // Calling the canonical constructor, this is compulsory for each overloaded constructor.
    }
}

record Y(int a, String b) {

    // Compact constructor, If you want to perform any extra actions before initialization.
    // These can be used for validations and normalizations of arguments.
    // These must NOT 1. initialize the fields(compilation failure) 2. try to access the fields (gets zero,null values)
    Y {
        System.out.println("From Compact Constructor");
        System.out.println(a); // From constructor arguments NOT the fields
        System.out.println(b);

        //System.out.println(this.a); // Comp failure. this.a and b are not initialized yet
        //System.out.println(this.b);

        System.out.println(a()); // Methods does not throw compilation error but returns uninitialized values
        System.out.println(b());


        System.out.println("----------------------");
    }

}

record Z(int a, int b) {

    // Canonical constructor can be used to manipulate values during assignment
    Z(int a, int b) {
        this.a = a * 2;
        this.b = b * 2;
    }
}

public class RecordFeatures {
    public static void main(String[] args) {

        X x = new X(1, "MJ");
        Y y = new Y(1, "MJ");

        System.out.println(x.a());
        System.out.println(x.b());

        System.out.println(y.a());
        System.out.println(y.b());

        Z z = new Z(2, 4);
        System.out.println(z);

        X defaultX = new X();
        System.out.println(defaultX);
    }
}
