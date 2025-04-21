package org.mj.dsa.ds;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UniqueDigitsFromArray {

    /*
     * Find all unique digits from the array
     * IP: [1,23,456,34,16]
     * OP: [1,2,3,4,5,6]
     * */
    public static void main(String[] args) {
        int[] ip = new int[]{1, 23, 456, 34, 106};
        Set<Integer> opList = new HashSet<>();
        for (int current : ip) {
            if (current == 0) {
                opList.add(current);
                continue;
            }
            int lastDigit = current % 10;
            while (current != 0) {
                opList.add(lastDigit);
                current = current / 10;
                lastDigit = current % 10;
            }
        }
        System.out.println(Arrays.toString(opList.toArray()));
    }
}