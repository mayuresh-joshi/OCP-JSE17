package org.mj.dsa.ds;

public class StringPermutations {

    /*
     * Given input string "GOD", write a program to find all permutations
     * OP = GOD, GDO, OGD, ODG, DGO, DOG
     * */
    public static void stringPermutations(String newstring, String remaining) {
        if (remaining.length() == 0) {
            System.out.println("newstring: " + newstring);
        }

        for (int i = 0; i < remaining.length(); i++) {
            String newRemaining = remaining.replaceFirst(remaining.charAt(i) + "", "");
            System.out.println("newRemaing=" + newRemaining);
            stringPermutations(newstring + remaining.charAt(i), newRemaining);
        }
    }

    private static void permutation(String string, String answer) {
        if (string.length() == 0) {
            System.out.print(answer + " ");
            //return;
        }

        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            String left_subString = string.substring(0, i);
            String right_subString = string.substring(i + 1);
            String rest = left_subString + right_subString;
            permutation(rest, answer + c);
        }
    }

    public static void main(String[] args) {
        String string = "GOD";
        stringPermutations("", string);
        System.out.println("================");
        permutation(string, "");
    }
}