package org.mj.module3.lesson8;

import java.util.ArrayList;
import java.util.List;

public class InstanceAndStaticFields {

    // order or modifiers does not matter, unless governed by convention
    public static final @Deprecated List<String> ls = new ArrayList<>();
    final static  @Deprecated public List<String> ls2 = new ArrayList<>();

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
