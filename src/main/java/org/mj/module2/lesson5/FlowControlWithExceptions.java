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
        }

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
        } catch (FileNotFoundException | MidiUnavailableException ex) {
            System.out.println("type of ex: "+ ex.getClass());
        }

    }
}
