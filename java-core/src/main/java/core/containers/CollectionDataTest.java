package main.java.core.containers;

import net.mindview.util.Generator;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-23 08:58:58
 * @Modified By:
 */
class Government implements Generator<String>{
    private int index;
    private static String[] strings = "go hell! the fucking world! I want to fuck you! Shit! you mother fuck!".split(" ");

    @Override
    public String next() {
        return strings[index++];
    }
}

public class CollectionDataTest {
    public static void main(String[] args) {
        Set<String> set = new LinkedHashSet<>(CollectionData.list(new Government(), 10));
        System.out.println(set);
    }
}
