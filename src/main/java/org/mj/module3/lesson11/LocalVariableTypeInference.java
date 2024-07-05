package org.mj.module3.lesson11;

public class LocalVariableTypeInference {
    public static void main(String[] args) {
        var var = 1; // lol, allowed.
        // var = "Hello"; // type is inferred at compile time and can't be changed later

        //var var2;  // Initialization compulsary when declaring variable with var
        //var2 = 99;

        //var var3 = {1, 2, 3}; // Ambiguous and not allowed, cant infer array type, need to give type explicitly.
        var var4 = new int[]{1, 2, 3};
        //var[] var5 = new long[]{1, 2, 3}; // Not allowed, var must represent entire type

        //var x = 1, y = 2; // var not allowed in a compound declaration;

    }
}
