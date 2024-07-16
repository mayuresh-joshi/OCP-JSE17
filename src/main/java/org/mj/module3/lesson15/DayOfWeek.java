package org.mj.module3.lesson15;

enum DayOfWeek {
    SUNDAY(),MONDAY("Back to work!"), TUESDAY;

    DayOfWeek(String s) {
    }

    DayOfWeek() {

    }

    public static void main(String[] args) {
        System.out.println(MONDAY);
    }
}
