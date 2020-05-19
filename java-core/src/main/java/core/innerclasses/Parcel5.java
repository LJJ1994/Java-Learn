package main.java.core.innerclasses;

import sun.security.krb5.internal.crypto.Des;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-13 15:15:15
 * @Modified By:
 */
public class Parcel5 {
    public Destination destination(String s){
        class PDestination implements Destination{ // 方法中的内部类，局部内部类
            private String label;
            public PDestination(String l){
                label = l;
            }

            @Override
            public String readLabel() {
                return label;
            }
        }
        return new PDestination(s);
    }

    public static void main(String[] args) {
        Parcel5 parcel5 = new Parcel5();
        Destination home = parcel5.destination("home");
        System.out.println(home.readLabel());
    }
}
