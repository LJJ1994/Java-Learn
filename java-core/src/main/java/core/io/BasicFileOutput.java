package main.java.core.io;

import java.io.*;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-05-03 21:38:38
 * @Modified By:
 */
public class BasicFileOutput {
    private static String file = "./src/BasicFileOutput.txt";
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new StringReader(
                BufferedInputStream.read("./src/HelloWorld.java")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
        int lineCount = 1;
        String s;
        while ((s = in.readLine()) != null){
            System.out.println(lineCount++ + ": " + s);
        }
        out.close();
        System.out.println(BufferedInputStream.read(file));
    }
}
