package main.java.core.io;

import java.io.*;
import java.io.BufferedInputStream;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-05-03 21:47:47
 * @Modified By:
 */
public class StoringAndRecoveringData {
    public static void main(String[] args) throws IOException {
        DataOutputStream out = new DataOutputStream(new BufferedOutputStream(
                new FileOutputStream("data.txt")));
        out.writeDouble(1.123);
        out.writeUTF("this is a dog!");
        out.close();

        DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("data.txt")));
        System.out.println(in.readDouble());
        System.out.println(in.readUTF());
        in.close();
    }
}
