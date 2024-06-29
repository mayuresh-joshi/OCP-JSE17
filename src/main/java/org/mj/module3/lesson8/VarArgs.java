package org.mj.module3.lesson8;

public class VarArgs {
    void printStuff(String... names) {
        for (String name : names) {
            System.out.println(name);
        }
    }

    public static void main(String[] args) {
        VarArgs obj = new VarArgs();
        obj.printStuff("MJ", "SS", "AB"); // Can pass a list

        String[] names = new String[]{"MJ", "SS", "AB"};
        obj.printStuff(names); // Can pass an array directly
    }
}
