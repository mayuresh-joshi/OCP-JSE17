package org.mj.from17to21.JEP440_recordpatterns;


record Point(int x, int y) {
}

record MyRecord(Object o) {

}

public class BasicRecordPatterns {

    public static void main(String[] args) {
        printSum(new Point(4, 5));
        System.out.println("-----------------------");
        printSumWithRecordPattern(new Point(5, 5));
        System.out.println("-----------------------");
        recordPatternMatchFailure(new MyRecord(new String("MJ")));
        System.out.println("-----------------------");
        recordPatternMatchFailure(new MyRecord(10));
    }

    // As of Java 16
    static void printSum(Object obj) {
        if (obj instanceof Point p) {
            int x = p.x();
            int y = p.y();
            System.out.println(x + y);
        }
    }

    // As of Java 21
    static void printSumWithRecordPattern(Object obj) {

        // "Point(int x, int y)" is the Record pattern
        if (obj instanceof Point(int x, int y)) {
            System.out.println(x + y);
        }

        // Pattern variables need not match the component names, sequence and type matters
        if (obj instanceof Point(int i, int j)) {
            System.out.println(i + j);
        }

        // var can be used
        if (obj instanceof Point(var k, var l)) {
            System.out.println(k + l);
        }

    }

    static void recordPatternMatchFailure(Object obj){
        // Pattern match fail example 1
        if (obj instanceof MyRecord(String s)) {
            System.out.println(s);
        } else {
            System.out.println("Not a String");
        }

        // Pattern match fail example 2
        if (obj instanceof MyRecord(Integer i)) {
            System.out.println(i);
        } else {
            System.out.println("Not an integer");
        }
    }
}
