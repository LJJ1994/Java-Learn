package main.java.core.io;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-05-04 00:20:20
 * @Modified By:
 */
public class TextFile extends ArrayList<String> {
    public static String read(String filename){
        StringBuilder sb = new StringBuilder();
        try{
            BufferedReader in = new BufferedReader(new FileReader(new File(filename).getAbsoluteFile()));
            try{
                String s;
                while ((s = in.readLine()) != null){
                    sb.append(s);
                    sb.append("\n");
                }
            } finally {
                in.close();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static void write(String filename, String text){
        try{
            PrintWriter out = new PrintWriter(new File(filename).getAbsoluteFile());
            try{
                out.print(text);
            } finally {
                out.close();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public TextFile(String filename, String splitter){
        super(Arrays.asList(read(filename).split(splitter)));
        if (get(0).equals("")) remove(0);
    }

    public TextFile(String filename){
        this(filename, "\n");
    }

    public void write(String filename){
        try{
            PrintWriter out = new PrintWriter(new File(filename).getAbsoluteFile());
            try{
                for (String item : this) {
                    out.println(item);
                }
            } finally {
                out.close();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        String file = read("./src/HelloWorld.java");
//        write("test.txt", file);
//
//        TextFile text = new TextFile("test.txt");
//        text.write("test2.txt");

        TreeSet<String> words = new TreeSet<>(new TextFile("./src/main/java/core/io/TextFile.java", "\\W+"));
        System.out.println(words.headSet("a"));

    }
}
