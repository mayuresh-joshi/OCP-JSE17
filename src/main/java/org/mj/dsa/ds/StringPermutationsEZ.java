package org.mj.dsa.ds;

public class StringPermutationsEZ {
    /*
     * Given input string "GOD", write a program to find all permutations
     * OP = GOD, GDO, OGD, ODG, DGO, DOG
     * */
    private static void stringPermutations(String answer, String remaining) {
        if (remaining.isEmpty()) {
            System.out.print(answer + " ");
        }

        for (int i = 0; i < remaining.length(); i++) {
            char c = remaining.charAt(i);
            String newRemaining = remaining.replaceFirst(c + "", "");
            stringPermutations(answer + c, newRemaining);
        }
    }

    public static void main(String[] args) {
        String string = "GOD";
        stringPermutations("", string);
    }
}
