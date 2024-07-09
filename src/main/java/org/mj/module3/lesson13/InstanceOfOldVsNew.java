package org.mj.module3.lesson13;

public class InstanceOfOldVsNew {
    public static void main(String[] args) {
        Object o = "Hello";

        // Old use of instanceof
        if (o instanceof String) {
            String s = (String) o;
            if (s.length() > 4) {
                System.out.println("Its a longish String");
            }
        }

        // New use of instanceof
        if (o instanceof String s) { // Effect is Check+cast+assignment
            //String s = (String) o;
            if (s.length() > 4) {
                System.out.println("Its a longish String");
            }
        }

        // New use of instanceof, more refined. Also note && and || allowed as instanceof expression returns boolean
        if (o instanceof String s && s.length() > 4) { // Effect is Check+cast+assignment
            System.out.println("Its a longish String");
        }

        // Weird case 1
        Object obj = "ASD";
        if ((obj instanceof String s)) { // try Notting (!) this, scope of pattern variable changes
            System.out.println("In scope: " + s);
        } else {
            System.out.println("Not in scope: " /*+ s.getClass().getName()*/);
        }

        // Weird case 2
        if (obj instanceof String s && s.length() > 5) { // Effect is Check+cast+assignment
            System.out.println("Its a longish String" + s);
        } else {
            System.out.println("not long"/* + s*/);
        }

        /*// Weird case 3 - Cant use || here
        if (obj instanceof String s || s.length() > 5) { // Effect is Check+cast+assignment
            System.out.println("Its a longish String" + s);
        } else {
            System.out.println("not long" + s);
        }*/
    }
}
