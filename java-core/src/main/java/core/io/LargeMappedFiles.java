package main.java.core.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-05-04 18:27:27
 * @Modified By:
 */
public class LargeMappedFiles {
    private static int LENGTH = 0x8FFFFFF;
    public static void main(String[] args) throws IOException {
        MappedByteBuffer out = new RandomAccessFile("test.dat", "rw").getChannel()
                .map(FileChannel.MapMode.READ_WRITE, 0, LENGTH);
        for (int i = 0; i < LENGTH; i++) {
            out.put((byte)'a');
        }
        System.out.println("finished writing!");

        for (int i = LENGTH/2; i < LENGTH/2+6; i++) {
            System.out.println((char)out.get(i));
        }
    }
}
