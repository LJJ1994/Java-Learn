package main.java.core.io;

import java.io.*;
import java.util.Random;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-05-04 20:18:18
 * @Modified By:
 */
class Data implements Serializable{
    private int n;
    public Data(int n){
        this.n = n;
    }
    public String toString(){
        return Integer.toString(n);
    }
}

public class Worm implements Serializable{
    private static Random random = new Random(47);
    private Worm next;
    private char c;
    private Data[] d = {
            new Data(random.nextInt(10)),
            new Data(random.nextInt(10)),
            new Data(random.nextInt(10))
    };
    public Worm(int i, char x){
        System.out.println("Worm constructor: " + i);
        c = x;
        if (--i > 0){
            next = new Worm(i, (char)(x + 1));
        }
    }

    public Worm(){
        System.out.println("default constructor");
    }

    public String toString(){
        StringBuilder result = new StringBuilder(":");
        result.append(c);
        result.append("(");
        for (Data data : d) {
            result.append(data);
        }
        result.append(")");
        if (next != null){
            result.append(next);
        }
        return result.toString();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Worm w = new Worm(6, 'a');
        System.out.println("W = " + w);

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("worm.out"));
        out.writeObject("Storage worm\n");
        out.writeObject(w);
        out.close();
        System.out.println("==================================");
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("worm.out"));
        String s = (String)in.readObject();
        Worm worm = (Worm) in.readObject();
        System.out.println(s + ": " + worm);

        System.out.println("==================================");
        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        ObjectOutputStream out2 = new ObjectOutputStream(byteArray);
        out2.writeObject("storage worm2\n");
        out2.writeObject(w);
        out2.close();

        ObjectInputStream in2 = new ObjectInputStream(new ByteArrayInputStream(byteArray.toByteArray()));
        String s2 = (String)in2.readObject();
        Worm worm1 = (Worm)in2.readObject();
        System.out.println(s2 + ": " + worm1);
    }
}
