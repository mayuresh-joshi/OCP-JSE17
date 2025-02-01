package org.mj.enthuware_tests.test3;

public class Test3 {
    public static void main(String[] args) {
        var k = 9;
        var s = 5;
        switch (k) {
            default:
                if (k == 10) {
                    s = s * 2;
                } else {
                    s = s + 4;
                    break;
                }
            case 7:
                s = s + 3;
        }
        System.out.println(s);

        //2
        String myStr = "good";
        char[] myCharArr = {'g', 'o', 'o', 'd'};
        String newStr = "";
        for (char ch : myCharArr) {
            newStr = newStr + ch;
        }
        boolean b1 = newStr == myStr;
        boolean b2 = newStr.equals(myStr);
        System.out.println(b1 + " " + b2);
    }
}

class TestClass implements T1, T2 {

    @Override
    public void m1() {

    }
}

interface T1 {
    int VALUE = 1;

    void m1();
}

interface T2 {
    int VALUE = 2;

    void m1();
}
