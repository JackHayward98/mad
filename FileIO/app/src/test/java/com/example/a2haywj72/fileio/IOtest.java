package com.example.a2haywj72.fileio;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class IOtest {

    @Test
    public void fileOutputStreamExample() throws Exception {

        File f = null;

        DataOutputStream ds = null;
        FileOutputStream fs = null;
        try {
            // creating a temporary directory if doesn't exist
            f = new File("./temp/data.bin");
            if (!f.exists()) {
                f.getParentFile().mkdirs();
            }
            System.out.println("writing to:" + f.getAbsolutePath());
            fs = new FileOutputStream(f);
            ds = new DataOutputStream(fs);
            ds.writeInt(1);
            ds.writeChar('b');
            ds.writeDouble(3.1415927);

        } catch (IOException e) {
            System.out.println(e);
        } finally {
            if (ds != null) ds.close(); // close the file to ensure data is flushed to file
        }

        FileInputStream fis = null;
        DataInputStream dis = null;
        try {
            // creating a temporary directory if doesn't exist

            System.out.println("reading from:" + f.getAbsolutePath());
            fis = new FileInputStream(f);
            dis = new DataInputStream(fis);

            int i = dis.readInt();
            char c = dis.readChar();
            double d = dis.readDouble();

            System.out.println("i=" + i);
            System.out.println("c=" + c);
            System.out.println("d=" + d);

        } catch (IOException e) {
            System.out.println(e);
        } finally {
            if (ds != null) ds.close(); // close the file to ensure data is flushed to file
        }
    }


}