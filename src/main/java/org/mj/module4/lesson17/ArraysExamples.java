package org.mj.module4.lesson17;

public class ArraysExamples {
    public static void main(String[] args) {

        int[] ai = new int[5]; // needs size/list of elements else comp fail
        int ia2[] = new int[5]; // deprecated but allowed

        String[][] si = new String[5][]; // partial create
        System.out.println(si[1]);
        si[1] = new String[5];
        System.out.println(si[1]);

        System.out.println(ai[2]);
        String[] sa = {,};
        System.out.println(sa.length);
        String[] sa2 = new String[]{"MJ",};

    }
}
