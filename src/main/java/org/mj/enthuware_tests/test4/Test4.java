package org.mj.enthuware_tests.test4;


interface Readable {
}

sealed class Document implements Readable permits Book {
}

non-sealed class Book extends Document implements Readable {
}

final class Journal extends Book {
}


class A {
    // abstract static void asd();
}

public class Test4 {


    static void test(int x) {
        switch (x) {
            case 1:
            case 2, 5:
            case 0:
            default:
                break;
            case 4:
                System.out.println("hello");
            case 'a' | 'b':
                System.out.println('c');
        }
    }


    public static void main(String[] args) {
        test(4);

        int a = 10;
        int b = 20;
        a += (a = 4);
        b = b + (b = 5);
        System.out.println(a + ",  " + b);
    }
}
