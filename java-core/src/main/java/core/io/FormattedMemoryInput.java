package main.java.core.io;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-05-03 21:26:26
 * @Modified By:
 */
public class FormattedMemoryInput {
    public static void main(String[] args) throws IOException {
        try{
            DataInputStream in = new DataInputStream(new ByteArrayInputStream(
                    BufferedInputStream.read("./src/HelloWorld.java").getBytes()));
            while (true){
                System.out.println((char) in.readByte());
            }
        } catch (EOFException e){
            e.printStackTrace();
        }
    }
}
