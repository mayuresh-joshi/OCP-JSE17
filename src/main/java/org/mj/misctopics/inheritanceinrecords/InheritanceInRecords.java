package org.mj.misctopics.inheritanceinrecords;

interface A {
    default String hello() {
        return "Hello";
    }
}

// extends keyword not alowed with records but Record can implement interfaces.
// This allows for limited inheritance.
// Inheriting default method from interface A
record R(String name) implements A {

    // Overriding also allowed, uncomment below and execute again
   /* @Override
    public String hello(){
        return "Record Hello";
    }*/
}

public class InheritanceInRecords {
    public static void main(String[] args) {
        R rObj = new R("Records World!");

        System.out.println(rObj.hello()+" "+rObj.name());
    }
}
