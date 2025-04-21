package org.mj.dsa.ds;

import java.util.Arrays;

public class SortedMerge {
    /**
     * Given 2 sorted arrays [1,3,5,7] and [2,4,6,8] OP new array: [1,2,3,4,5,6,7,8] Output contains
     * sorted elements from both
     */
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {2, 4, 6, 8};
        int[] arr3 = new int[arr1.length + arr2.length];

        int i = 0, j = 0, k = 0;
        int n1 = arr1.length;
        int n2 = arr2.length;

        while (i < n1 && j < n2) {
            // Pick smaller of the two current elements and move ahead in the array of the picked element
            if (arr1[i] < arr2[j]) {
                arr3[k++] = arr1[i++];
            } else if (arr1[i] > arr2[j]) {
                arr3[k++] = arr2[j++];
            } else {
                arr3[k++] = arr2[j++];
                i++;
            }
        }
        // if there are remaining elements of the first array, move them
        while (i < n1) {
            arr3[k++] = arr1[i++];
        }
        // Else if there are remaining elements of the second array, move them
        while (j < n2) {
            arr3[k++] = arr2[j++];
        }
        System.out.println(Arrays.toString(arr3));
    }
}
