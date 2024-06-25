package org.mj.module3.lesson7;

abstract class MyRunnable implements Runnable {
    String message;

    MyRunnable(String msg) {
        message = msg;
    }
}

public class LocalAndAnonClass {
    public static void main(String[] args) {
        // Anonymous Class
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello From Anon Class");
            }
        };
        r2.run();

        // Anonymous class invoking constructor of parent
        Runnable r3 = new MyRunnable("Aloha") {

            @Override
            public void run() {
                System.out.println(message);
            }
        };
        r3.run();
    }
}
