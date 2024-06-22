package org.mj.module2.lesson5;

import java.io.FileNotFoundException;
import java.sql.SQLException;

// Class implementing AutoCloseable
class MyResource2 implements AutoCloseable { // Change to Closeable and see the errors

    // Adding identity to each resource
    private static int nextId = 0;
    private final int id = nextId++;

    // Instance Initializer
    {
        System.out.println("Initializing resource with Id: " + id);
    }

    @Override
    public void close() throws SQLException {

        if (id == 1)
            throw new SQLException(); // Exception thrown

        System.out.println("Closing... with Id: " + id);
    }
}

public class ImplementingAutoCloseablePT2 {
    public static void main(String[] args) throws SQLException {
        System.out.println("Starting...");
        MyResource2 mr0 = new MyResource2();
        try (MyResource2 mr1 = new MyResource2();   // Closing is in the reverse order of listing (Not order of creation)
             mr0;                                   // Exception thrown while closing one resource will not affect closure of other resources
             MyResource2 mr2 = new MyResource2()) { // Here mr1 throws exception while closing but mr0 and mr2 gets closed successfully

            System.out.println("Using resources...");
            if (Math.random() > 0.5)
                throw new FileNotFoundException();

        } catch (FileNotFoundException e) {
            System.out.println("Exception in try Block...");
            System.out.println(e);

            // Getting Suppressed Exceptions
            System.out.println("Printing Suppressed Exceptions..."); // Suppressed Exceptions!!
            for (Throwable throwable : e.getSuppressed()) {
                System.out.println(throwable);
            }
        }
        System.out.println("Ending...");
    }
}
