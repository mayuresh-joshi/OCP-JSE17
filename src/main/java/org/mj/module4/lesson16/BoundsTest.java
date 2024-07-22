package org.mj.module4.lesson16;

import java.util.ArrayList;
import java.util.List;

class A {}
class B extends A {}
class C extends B {}

class GenericClass {
    static public void doSomethingUpperBound(List<? extends B> list){}
    static public void doSomethingLowerBound(List<? super B> list){}
}

public class BoundsTest {
    public static void main(String[] args) {

        List<A> aList = List.of(new A());
        List<B> bList = List.of(new B());
        List<C> cList = List.of(new C());


        // B and its sub classes
        //GenericClass.doSomethingUpperBound(aList);
        GenericClass.doSomethingUpperBound(bList);
        GenericClass.doSomethingUpperBound(cList);

        // B and its super classes6
        GenericClass.doSomethingLowerBound(aList);
        GenericClass.doSomethingLowerBound(bList);
        //GenericClass.doSomethingLowerBound(cList);

    }
}
