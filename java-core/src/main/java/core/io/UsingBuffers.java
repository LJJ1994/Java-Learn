package main.java.core.io;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-05-04 18:15:15
 * @Modified By:
 */
public class UsingBuffers {
    public static void symmetricScramble(CharBuffer byteBuffer){
        while (byteBuffer.hasRemaining()){
            byteBuffer.mark();
            char c1 = byteBuffer.get();
            char c2 = byteBuffer.get();
            byteBuffer.reset();
            byteBuffer.put(c2).put(c1);
        }
    }

    public static void main(String[] args) {
        char[] data = "UsingBuffers".toCharArray();
        ByteBuffer bb = ByteBuffer.allocate(data.length * 2);
        CharBuffer cb = bb.asCharBuffer();
        cb.put(data);
        System.out.println(cb.rewind());
        symmetricScramble(cb);
        System.out.println(cb.rewind());
        symmetricScramble(cb);
        System.out.println(cb.rewind());
    }
}
