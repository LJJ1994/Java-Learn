package main.java.core.io;

import java.io.*;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-05-04 12:39:39
 * @Modified By:
 */
public class GetChannel {
    public static void main(String[] args) throws IOException {
        FileChannel fc = new FileOutputStream("data1.txt").getChannel();
        fc.write(ByteBuffer.wrap("some text".getBytes()));
        fc.close();

        fc = new RandomAccessFile("data1.txt", "rw").getChannel();
        fc.position(fc.size());
        fc.write(ByteBuffer.wrap("some more".getBytes()));
        fc.close();

        fc = new FileInputStream("data1.txt").getChannel();
        ByteBuffer buff = ByteBuffer.allocate(1024);
        fc.read(buff);
        buff.flip();
        while (buff.hasRemaining()){
            System.out.println((char) buff.get());
        }
    }
}
