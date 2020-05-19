package main.java.core.io;

import java.nio.Buffer;
import java.nio.ByteBuffer;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-05-04 13:21:21
 * @Modified By:
 */
public class GetData {
    private static int BSIZE = 1024;

    public static void main(String[] args) {
        ByteBuffer buff = ByteBuffer.allocate(BSIZE);
        int i = 0;
        while (i++ < buff.limit()){
            if (buff.get() != 0){
                System.out.println("nonzero");
            }
        }
        System.out.println("i: " + i);
        buff.rewind();

        buff.asCharBuffer().put("hello");
        char c;
        while ((c=buff.getChar()) != 0){
            System.out.print(c + " ");
        }
        System.out.println();

        buff.rewind();
        buff.asShortBuffer().put((short)1920);
        System.out.println(buff.getShort());

        buff.rewind();
        buff.asIntBuffer().put(1024);
        System.out.println(buff.getInt());

        buff.rewind();
        buff.asLongBuffer().put((long)1025);
        System.out.println(buff.getLong());

        buff.rewind();
        buff.asDoubleBuffer().put((double)291.11);
        System.out.println(buff.getDouble());
    }
}
