package org.mj.module3.lesson8;

import java.sql.SQLException;

public class Methods {


    void doStuff() throws SQLException, SQLException {
        // Repetition of exceptions allowed after throws clause.
        System.out.println("Weird...");
    }


    public static void main(String[] args) {
        try {
            new Methods().doStuff();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
