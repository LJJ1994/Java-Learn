package main.java.core.io;

import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.SortedMap;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-05-04 13:10:10
 * @Modified By:
 */
public class AvailableCharsets {
    public static void main(String[] args) {
        SortedMap<String, Charset> charsets = Charset.availableCharsets();
        Iterator<String> it = charsets.keySet().iterator();
        while (it.hasNext()){
            String CSName = it.next();
            System.out.print(CSName);
            Iterator<String> aliases = charsets.get(CSName).aliases().iterator();
            if (aliases.hasNext()){
                System.out.print(": ");
            }
            while (aliases.hasNext()){
                System.out.print(aliases.next());
                if (aliases.hasNext()){
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }
}
