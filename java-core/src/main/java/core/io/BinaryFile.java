package main.java.core.io;

import java.io.*;
import java.io.BufferedInputStream;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-05-04 00:43:43
 * @Modified By:
 */
public class BinaryFile {
    public static byte[] read(File bFile) throws IOException {
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(bFile))) {
            byte[] data = new byte[in.available()];
            in.read(data);
            return data;
        }
    }

    public static byte[] read(String filename) throws IOException{
        return read(new File(filename).getAbsoluteFile());
    }

    public static void main(String[] args) {

    }
}
