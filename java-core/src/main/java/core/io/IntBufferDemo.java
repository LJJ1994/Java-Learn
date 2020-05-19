package main.java.core.io;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-05-04 13:32:32
 * @Modified By:
 */
public class IntBufferDemo {
    private static int BSIZE = 1024;

    public static void main(String[] args) {
        ByteBuffer buff = ByteBuffer.allocate(BSIZE);
        IntBuffer intBuffer = buff.asIntBuffer();
        intBuffer.put(new int[]{1,2,3,4,5});
        System.out.println(intBuffer.get(2));

        intBuffer.put(0,102);
        intBuffer.flip();
        while (intBuffer.hasRemaining()){
            System.out.println(intBuffer.get());
        }
    }
}
