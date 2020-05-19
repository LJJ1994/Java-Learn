package main.java.core.io;

import java.io.IOException;
import java.io.StringReader;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-05-03 21:13:13
 * @Modified By:
 */
public class MemoryInput {
    public static void main(String[] args) throws IOException {
        StringReader in = new StringReader(BufferedInputStream.read("./src/HelloWorld.java"));
        int c;
        while ((c = in.read()) != -1){
            System.out.println((char) c);
        }
    }
}
