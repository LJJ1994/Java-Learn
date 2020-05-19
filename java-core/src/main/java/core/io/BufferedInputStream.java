package main.java.core.io;

import java.io.*;
import java.util.Objects;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-05-03 20:58:58
 * @Modified By:
 */
public class BufferedInputStream {
    public static String read(String filename) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(filename));
        String s;
        StringBuilder sb = new StringBuilder();
        while((s=in.readLine()) != null){
            sb.append(s).append("\n");
        }
        in.close();
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        System.out.println(read("./src/HelloWorld.java"));
//        for (File file : Objects.requireNonNull(new File("./src").listFiles())) {
//            System.out.println(file);
//        }

    }
}
