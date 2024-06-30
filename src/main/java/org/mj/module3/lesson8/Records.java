package org.mj.module3.lesson8;

import java.io.Serializable;

// Defining records
// In Java documentation, '(String name, int creditLimit)' is called component list and each element is called component (of a record)
// Implicitly final, may optionally mark it as final but not required.
// It is final because subclassing can break immutability
// extends not allowed (By default extends java.lang.Record), implements allowed.
final record Customer(String name, int creditLimit) implements Serializable, Runnable {
    @Override
    public void run() {
        System.out.println("Runnable implemented for " + this.name);
    }

    @Override // This is replacement and not technically override, but @Override is allowed anyway.
    public String toString() {
        //super.toString(); // Cant use super.someMethod like we can use in actual overridden methods
        return "This is " + name + " with credit limit " + creditLimit;
    }

    // Instance methods allowed inside records
    public String getMyDescription() {
        return "Some fancy description for " + name;
    }

    // instance fields not allowed
    //String instanceMessageFiled = "Namaste"; // Comp fails with 'Instance field not allowed in a record' not even final instance fields are allowed

    // static fields allowed
    static String message = "Namaste";

    // static methods allowed as well
    public static void sayHello() {
        System.out.println(message + " from a static Customer method...");
    }

    // { // Instance Initializers also not allowed }

    static {
        System.out.println("Static Initializers allowed...");
    }
}

public class Records {

    // Not related to Records, but varargs work with constructors as well
    public Records(String... s) {
    }

    public static void main(String[] args) {
        Customer c1 = new Customer("MJ", 75000);
        Customer c2 = new Customer("MJ", 75000);
        Customer c3 = new Customer("MJ", 5000);

        // toString and accessors usage
        System.out.println(c1);
        System.out.println("Customer " + c1.name() + " has credit limit " + c1.creditLimit());

        // equals check
        System.out.println("c1.equals(c2)? " + c1.equals(c2));
        System.out.println("c1.equals(c3)? " + c1.equals(c3));

        //hashCode
        System.out.println("c1.hashCode() " + c1.hashCode());
        System.out.println("c2.hashCode() " + c2.hashCode());
        System.out.println("c3.hashCode() " + c3.hashCode());

        // running implemented methods
        c1.run();
        c2.run();
        c3.run();

        // Replacement toString
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);

        // Additional instance methods
        System.out.println(c1.getMyDescription());
        System.out.println(c2.getMyDescription());
        System.out.println(c3.getMyDescription());

        // static method and fields
        Customer.sayHello();
        System.out.println(Customer.message);
    }
}
