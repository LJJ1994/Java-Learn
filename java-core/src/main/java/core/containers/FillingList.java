package main.java.core.containers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-23 08:46:46
 * @Modified By:
 */
class StringAddress{
    private String address;
    public StringAddress(String address){
        this.address = address;
    }
    public String toString(){
        return super.toString() + " " + address;
    }
}
public class FillingList {
    public static void main(String[] args) {
        List<StringAddress> stringAddresses = new ArrayList<>(
                Collections.nCopies(4, new StringAddress("hello")));
        System.out.println(stringAddresses);
        Collections.fill(stringAddresses, new StringAddress("world"));
        System.out.println(stringAddresses);
    }
}
