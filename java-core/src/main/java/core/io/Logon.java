package main.java.core.io;

import java.io.*;
import java.util.Date;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-05-04 21:03:03
 * @Modified By:
 */
public class Logon implements Serializable {
    private String username;
    private Date date = new Date();
    private transient String password;
    public Logon(String name, String pwd){
        username = name;
        password = pwd;
    }

    @Override
    public String toString() {
        return "Logon{" +
                "username='" + username + '\'' +
                ", date=" + date +
                ", password='" + password + '\'' +
                '}';
    }

    public static void main(String[] args) throws IOException,ClassNotFoundException {
        Logon logon = new Logon("LJJ", "123456");
        System.out.println(logon);
        System.out.println("==========write object=============");
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("logon.out"));
        out.writeObject(logon);
        out.close();

        System.out.println("==========read object==========");
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("logon.out"));
        Logon read = (Logon) in.readObject();
        System.out.println(read);
    }
}
