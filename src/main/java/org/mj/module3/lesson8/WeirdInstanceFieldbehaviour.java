package org.mj.module3.lesson8;


// if we change Parent to an interface then the super keyword will not work super.x will fail to compile
class Parent {
    int x = 100;
}

class Child extends Parent {
    int x = 200;

    public void go(){
        System.out.println("Child class version: "+x);
        System.out.println("Parent class version: "+super.x);

        // Even though we assigned the object of 'Child' class using 'this'.
        // The reference used to access x is 'Parent' type.
        // Dynamic binding only occurs in case of method calls. Here the Object type matters.
        // For fields, the reference type will decide which field will be accessed.
        // Since reference p is of 'Parent' type then the Parent.x is evaluated
        Parent p = this;  // Assigning Child object to Parent reference.
        System.out.println("Weird" +
                " behaviour: "+p.x);
    }
}

public class WeirdInstanceFieldbehaviour {
    public static void main(String[] args) {
        Child c = new Child();
        c.go();
    }
}
