package main.java.core.io;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-05-03 21:31:31
 * @Modified By:
 */
public class TestEOF {
    public static void main(String[] args) throws IOException {
        DataInputStream in = new DataInputStream(new ByteArrayInputStream(
        BufferedInputStream.read("./src/HelloWorld.java").getBytes()));
        while (in.available() != 0){
            System.out.println((char) in.readByte());
        }
    }
}