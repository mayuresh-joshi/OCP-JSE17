package org.mj.module3.lesson15;

enum DayOfWeek {
    SUNDAY(), MONDAY("Back to work!"), TUESDAY;

    // Instance and Static fields allowed in enum
    public Integer a = 1;
    static public Integer aStatic = 1;

    // Constructors are private by default
    /*public*/ DayOfWeek(String s) {
    }

    DayOfWeek() {

    }

    // Instance and Static methods allowed in enum
    void doSomething() {
    }

    public static void main(String[] args) {
        System.out.println(MONDAY);
    }
}
