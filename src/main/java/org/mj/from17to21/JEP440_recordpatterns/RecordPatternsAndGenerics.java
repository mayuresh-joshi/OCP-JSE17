package org.mj.from17to21.JEP440_recordpatterns;

record Box<T>(T t) {
}

public class RecordPatternsAndGenerics {

    public static void main(String[] args) {
        Box<Box<String>> bbs = new Box<Box<String>>(new Box<String>("MJ"));
        Box<String> bs = new Box<String>("MJ2");

        test1(bbs);
        System.out.println("-----------------------");
        test2(bbs);
        System.out.println("-----------------------");
        test3(bs);
    }

    // Everything explicit in Record Pattern
    static void test1(Box<Box<String>> bbs) {
        if (bbs instanceof Box<Box<String>>(Box(var s))) {
            System.out.println("String " + s);
        }
    }

    // Types being inferred automatically
    static void test2(Box<Box<String>> bbs) {
        if (bbs instanceof Box(Box(var s))) {
            System.out.println("String " + s);
        }
    }

    // Simple type inferencing (Non-nested Example)
    static void test3(Box<String> bbs) {
        if (bbs instanceof Box(var s)) {
            System.out.println("String " + s);
        }
    }
}
