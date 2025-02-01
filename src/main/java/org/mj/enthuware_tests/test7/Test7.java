package org.mj.enthuware_tests.test7;


import java.nio.file.Path;
import java.nio.file.Paths;

interface House {
    public default String getAddress() {
        return "101 Main Str";
    }
}

interface Bungalow extends House {
    public default String getAddress() {
        return "101 Smart Str";
    }
}

class MyHouse implements Bungalow, House {
}

public class Test7 {
    static Path p1 = Paths.get("c:\\main\\project\\Starter.java");

    public static String getRoot() {
        String root = p1.getRoot().toString();
        return root;
    }

    public static void main(String[] args) {
        System.out.println(getRoot());
    }
}
