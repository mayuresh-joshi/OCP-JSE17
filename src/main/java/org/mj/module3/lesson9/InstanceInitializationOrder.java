package org.mj.module3.lesson9;

public class InstanceInitializationOrder {
    public String s = initPlx(); // IMP: Field initializer and instance initializer runs in order they are written in source code

    private String initPlx() {
        System.out.println("During assignment...");
        return "Assignment";
    }

    {
        System.out.println("In instance initializer");
        s = "Instance initializer";
    }

    InstanceInitializationOrder() {
        System.out.println("In Constructor");
        s = "Default constructor";
    }

    InstanceInitializationOrder(String s) {
        this();
        System.out.println("In parameterized constructor");
        this.s = s;
    }

    public static void main(String[] args) {
        InstanceInitializationOrder ob1 = new InstanceInitializationOrder();
        System.out.println("Value of initialized var: "+ob1.s);

        System.out.println("=================");

        InstanceInitializationOrder ob2 = new InstanceInitializationOrder("Parameterized constructor");
        System.out.println("Value of initialized var: "+ob2.s);
    }
}
