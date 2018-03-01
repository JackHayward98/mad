package com.example.a2haywj72.fileio;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by 2haywj72 on 01/03/2018.
 */

public class Characterio {

    @Test
    public void fileCharacterStreamExample() throws Exception {
        File f = null;
        try {
            // creating a temporary directory if doesn't exist
            f = new File("./temp/data.txt");
            if (!f.exists()) {
                f.getParentFile().mkdirs();
            }
            System.out.println("writing to:" + f.getAbsolutePath());
            PrintWriter pw =
                    new PrintWriter(new FileWriter(f));

            pw.println("Hello");
            pw.println("It's a nice day!");
            pw.close(); // close the file to ensure data is flushed to file
        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        }

        //read from the file
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader("marks.txt"));
            String line = "";
            while((line = reader.readLine()) != null)
            {
                System.out.println(line);
            }
        }
        catch(IOException e)
        {
            System.out.println("ERROR: " + e);

        }
    }
}
