package org.mj.module2.lesson5;

import java.sql.SQLException;

// Class implementing AutoCloseable
class MyResource implements AutoCloseable { // Change to Closeable and see the errors

    // Adding identity to each resource
    private static int nextId = 0;
    private final int id = nextId++;

    // Instance Initializer
    {
        System.out.println("Initializing resource with Id: " + id);
    }

    @Override
    public void close() throws SQLException {
        System.out.println("Closing... with Id: " + id);
    }
}

public class ImplementingAutoCloseablePT1 {
    public static void main(String[] args) throws SQLException {
        System.out.println("Starting...");
        MyResource mr0 = new MyResource();
        try (MyResource mr1 = new MyResource(); // Closing is in the reverse order of listing (Not order of creation)
             mr0;
             MyResource mr2 = new MyResource()) {
            System.out.println("Using resources...");
        }
        System.out.println("Ending...");
    }
}
