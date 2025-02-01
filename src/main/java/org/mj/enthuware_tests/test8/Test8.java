package org.mj.enthuware_tests.test8;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.IntStream;


class A {
}

class B extends A {
}

class C extends B {
}

interface Something {
    default final void asd() {
    }
}

public class Test8 {
    public static void main(String[] args) throws Exception {
        SequencedCollection sc = new ArrayList(); //1
        sc.add(111); //2


        SequencedCollection sc2 = new LinkedHashSet();
        SequencedMap sc3 = new LinkedHashMap();

        //System.out.println(sc.get(sc.size()));  //3

        List<Integer> list = new CopyOnWriteArrayList<>();
        ExecutorService es = Executors.newFixedThreadPool(5);
        CyclicBarrier cb = new CyclicBarrier(2, () -> System.out.print("All Done"));
        IntStream.range(0, 5).forEach(n -> es.execute(() -> {
            try {
                list.add(n);
                cb.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                System.out.println("Exception");
            }
        }));
        es.shutdown();

        float a = 10;
        int b = 20;

        float c = b; // can assign int to float
        //int d = a; // can't assign float to int

        Object o = new B();

        if (o instanceof String) {
            System.out.println("String");
        } else if (o instanceof CharSequence) {
            System.out.println("CharSeq");
        } else if (null instanceof B b1) { // 'null instanceof Something' is always false
            System.out.println(b1.getClass().getCanonicalName());
        }

        List<Integer> names = Arrays.asList(1, 2, 3); //1
        names.forEach(x->x=x+1); //2 
        names.forEach(System.out::println); //3


    }
}
