package org.mj.module3.lesson7;

public class Outer {
    private String name = "MJ";

    class Inner {
        private String name = "SS";

        void show() {
            System.out.println("Name: " + name);
        }

        void showOuter() {
            System.out.println("Name: " + Outer.this.name); // 'Qualified this' to access outer field
        }
    }

    public static void main(String[] args) {
        Inner in = new Outer().new Inner();
        in.show();
        in.showOuter();
    }
}
