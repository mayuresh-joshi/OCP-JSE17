package org.mj.module2.lesson5;

import javax.sound.midi.MidiUnavailableException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FlowControlWithExceptions {
    public static void main(String[] args) throws IOException {

        String file = "FlowControlWithExceptions.class";
        // Try with resources
        try (FileWriter fw = new FileWriter(file);
             FileReader fr = new FileReader(file);) { // trailing semicolon is allowed
            //fw = new FileWriter(file); // resources becomes effectively final so this statement will not be allowed
        } // Also observe, no catch or finally block is mandatory as try with resources gets a compiler generated finally.

        // Also valid
        FileWriter fw2 = new FileWriter(file);
        try (fw2;
             FileReader fr = new FileReader(file)) {

        }


        // Also valid
        FileReader fr = new FileReader(file);
        try (FileReader fr2 = fr;
             FileWriter fw = new FileWriter(file)) {
            fr = new FileReader(file);
        } catch (IOException e) {

        }
        fr = null;

        // Multi-catch
        try {
            if (Math.random() > 0.5)
                throw new FileNotFoundException();
            else
                throw new MidiUnavailableException();
        } /*catch (Exception e) {
            // Compilation error as All Exceptions are caught here so below catch block becomes unreachable.
            // Fails with 'java: exception java.io.FileNotFoundException has already been caught'
        }*/ catch (FileNotFoundException | MidiUnavailableException ex) { // Exceptions in multi-catch should not have a parent-child relation, compilation error.
            System.out.println("type of ex: " + ex.getClass());
        } catch (Exception e) {
            // If you want to have a generic catch block have it as the last one.
        }

    }
}
