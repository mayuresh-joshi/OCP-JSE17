package org.mj.module3.lesson8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InstanceAndStaticFields {

    // Comma separated list allowed for fields of SAME type
    HashMap hs = new HashMap(), hs2, hs3 = new HashMap();

    // Array declarations
    int[] ia = new int[]{1, 2, 3, 4, 5}; // Preferred style
    int[] ia2 = {1, 2, 3, 4, 5};
    int ia3[] = {1, 2, 3, 4, 5}; // Permitted only because of C++ devs

    int[] ia4 [] = new int[][]{{1, 2, 3}, {4, 5, 6}}; // Ugly but legal
    int [] ia5[] = {{1, 2, 3}, {4, 5, 6}}; // Ugly but legal. also spaces are ignored in array declaration between 'type' and '[]'

    // Order of modifiers does not matter, unless governed by convention
    public static final @Deprecated List<String> ls = new ArrayList<>();
    final static @Deprecated
    public List<String> ls2 = new ArrayList<>();

    // final fields must be initialized (either directly or in static/instance initializer), else compilation fails
    final static public @Deprecated List<String> ls3;
    final public @Deprecated List<String> ls4;

    // removing below will result in compilation failures
    static {
        ls3 = new ArrayList<>();
    }

    {
        ls4 = new ArrayList<>();
    }

    public static void main(String[] args) {

    }
}
