package main.java.core.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-05-03 21:55:55
 * @Modified By:
 */
public class UsingRandomAccessData {
    static String file = "rtest.dat";
    static void display() throws IOException {
        RandomAccessFile rf = new RandomAccessFile(file, "r");
        for (int i = 0; i < 7; i++) {
            System.out.println(i + ": " + rf.readDouble());
        }
        System.out.println(rf.readUTF());
        rf.close();
    }

    public static void main(String[] args) throws IOException {
        RandomAccessFile rw = new RandomAccessFile(file, "rw");
        for (int i = 0; i < 7; i++) {
            rw.writeDouble(i*1.414);
        }
        rw.writeUTF("the end of file.");
        rw.close();
        display();

        rw = new RandomAccessFile(file, "rw");
        rw.seek(5*8);
        rw.writeDouble(47.001);
        rw.close();
        display();
    }
}
