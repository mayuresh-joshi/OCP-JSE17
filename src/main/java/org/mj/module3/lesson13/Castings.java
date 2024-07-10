package org.mj.module3.lesson13;


// No relationship in below types but still compiler allows casting (will fail at runtime)
// If below class is made final both 1 and 2 will fail.
class AClass {
}

interface AInterface {
}

public class Castings {
    public static void main(String[] args) {
        // 1
        AClass ac = new AClass();
        AInterface casted = (AInterface) ac; // allowed by compiler but is a runtime ClassCastException

        // 2
        AInterface ai = new AInterface() {
        };
        AClass casted2 = (AClass) ai; // allowed by compiler but is a runtime ClassCastException
    }
}
