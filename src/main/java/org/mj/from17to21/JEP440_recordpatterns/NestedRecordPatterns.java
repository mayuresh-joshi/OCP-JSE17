package org.mj.from17to21.JEP440_recordpatterns;

enum Color {RED, GREEN, BLUE}

record Point2(int x, int y) {
}

record ColoredPoint(Point2 p, Color c) {
}

record Rectangle(ColoredPoint upperLeft, ColoredPoint lowerRight) {
}

public class NestedRecordPatterns {


    public static void main(String[] args) {
        int x1 = 10, y1 = 20, x2 = 15, y2 = 25;
        Color c1 = Color.BLUE, c2 = Color.GREEN;
        Rectangle r = new Rectangle(new ColoredPoint(new Point2(x1, y1), c1),
                new ColoredPoint(new Point2(x2, y2), c2));

        printUpperLeftColoredPoint(r);
        System.out.println("-----------------------");
        printColorOfUpperLeftPoint(r);
        System.out.println("-----------------------");
        printXCoordOfUpperLeftPointWithPatterns(r);
    }

    // Non-nested Record pattern
    static void printUpperLeftColoredPoint(Rectangle r) {
        if (r instanceof Rectangle(ColoredPoint ul, ColoredPoint lr)) {
            System.out.println(ul.c());
        }
    }

    // Nested Record pattern
    static void printColorOfUpperLeftPoint(Rectangle r) {
        if (r instanceof Rectangle(
                ColoredPoint(Point2 p, Color c),
                ColoredPoint lr
        )) {
            System.out.println(c);
        }
    }

    // A deeply nested Record pattern
    static void printXCoordOfUpperLeftPointWithPatterns(Rectangle r) {
        if (r instanceof Rectangle(
                ColoredPoint(Point2(var x, var y), var c),
                var lr
        )) {
            System.out.println("Upper-left corner x: " + x);
        }
    }
}
