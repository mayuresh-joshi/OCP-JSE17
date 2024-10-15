package org.mj.from17to21.JEP440_recordpatterns;

class A {
}

class B extends A {
}

sealed interface I permits C, D {
}

final class C implements I {
}

final class D implements I {
}

record Pair<T>(T x, T y) {
}

public class RecordPatternsAndExhaustiveSwitch {
    static Pair<A> p1;
    static Pair<I> p2;

    public static void main(String[] args) {
        // Does not cover all cases
        switch (p1) {                 // Error! Hover over it.
            case Pair<A>(A a, B b) -> {}
            case Pair<A>(B b, A a) -> {}
            //case Pair<A>(A x, A y) -> {}
        }

        switch (p2) {                        // Error!  Hover over it
            case Pair<I>(C fst, D snd) -> {}
            case Pair<I>(D fst, C snd) -> {}
            case Pair<I>(I fst, C snd) -> {}
            //case Pair<I>(D x, D y) -> {}
        }

        // Covers all cases
        switch (p2) {
            case Pair<I>(I i, C c) -> {}
            case Pair<I>(I i, D d) -> {}
        }

        // Covers all cases
        switch (p2) {
            case Pair<I>(C c, I i) -> {}
            case Pair<I>(D d, C c) -> {}
            case Pair<I>(D d1, D d2) -> {}
        }
    }
}
