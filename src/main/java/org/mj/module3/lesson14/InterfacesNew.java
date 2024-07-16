package org.mj.module3.lesson14;

interface Parent {
    void doSomething();
}

interface Child extends Parent {
    void doSomething();
}

class Implementor implements Child, Parent{

    @Override
    public void doSomething() {

    }
}
public class InterfacesNew {
    public static void main(String[] args) {
        System.out.println("Observe the source code here carefully");
    }
}
