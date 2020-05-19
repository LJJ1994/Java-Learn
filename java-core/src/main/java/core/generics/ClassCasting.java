package main.java.core.generics;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-22 11:42:42
 * @Modified By:
 */
public class ClassCasting {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception{
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(args[0]));
//        List<Widget> o = (List<Widget>) in.readObject();
        List<Widget> cast = (List<Widget>) List.class.cast(in.readObject());
    }
}
