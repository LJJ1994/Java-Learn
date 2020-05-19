package main.java.core.containers;

import net.mindview.util.Generator;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-23 08:54:54
 * @Modified By:
 */
public class CollectionData<T> extends ArrayList<T> {
    public CollectionData(Generator<T> gen, int quantity){
        for (int i = 0; i < quantity; i++) {
            add(gen.next());
        }
    }

    public static <T> CollectionData<T> list(Generator<T> gen, int quantity){
        return new CollectionData<>(gen, quantity);
    }
}
