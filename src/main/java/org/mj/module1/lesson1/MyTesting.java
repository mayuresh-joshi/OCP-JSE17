package org.mj.module1.lesson1;

import java.io.Serializable;

public class MyTesting {
    public static void main(String[] args) {
        byte b = 1;
        short s = 1;
        byte b2 = 1;
        short i1 = 1;
        short i2 = 2;
        int i3 = 10;
        long lo = i3;
        //short z = b + s;
        //byte b3 = b + b2;
        //short i3 = i1 + i2;

        final int i = 127;
        byte b3 = 127;
        byte br = true ? b3 : i;

        String s2 = "";
        StringBuilder sb2;
        Serializable serializable = true ? s2 : sb2;
        CharSequence charSequence = true ? s2 : sb2;
        Comparable comparable = true ? s2 : sb2;


        Integer iI = 99;
        long lL = iI;
    }
}
