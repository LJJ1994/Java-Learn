package main.java.core.io;

import java.io.*;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-05-04 20:49:49
 * @Modified By:
 */
public class Blip3 implements Externalizable {
    private String s;
    private int i;
    public Blip3(String x, int a){
        System.out.println("Blip3(String x, int a)");
        i = a;
        s = x;
    }
    public Blip3(){
        System.out.println("default constructor");
    }
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("Blip3.writeExternal");
        out.writeObject(s);
        out.writeInt(i);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("Blip3.readExternal");
        s = (String)in.readObject();
        i = in.readInt();
    }

    @Override
    public String toString() {
        return "Blip3{" +
                "s='" + s + '\'' +
                ", i=" + i +
                '}';
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Constructor Blip3...");
        Blip3 blip3 = new Blip3("a string", 47);
        System.out.println(blip3);

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("blip3.out"));
        System.out.println("saving blip3");
        out.writeObject(blip3);
        out.close();

        System.out.println("==============");
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("blip3.out"));
        Blip3 b = (Blip3)in.readObject();
        System.out.println(b);
    }
}
