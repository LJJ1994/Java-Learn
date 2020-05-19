package main.java.core.holding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-14 18:28:28
 * @Modified By:
 */
class ReversibleArrayList<T> extends ArrayList<T>{
    public ReversibleArrayList(Collection<T> c){
        super(c);
    }
    public Iterable<T> reversed(){
        return new Iterable<T>() {
            public Iterator<T> iterator(){
                return new Iterator<T>() {
                    private int current = size() - 1;
                    @Override
                    public boolean hasNext() {
                        return current > -1;
                    }

                    @Override
                    public T next() {
                        return get(current--);
                    }
                };
            }
        };
    }
}
public class AdapterIdiom {
    public static void main(String[] args) {
        ReversibleArrayList<String> strings = new ReversibleArrayList<>(Arrays.asList("we are dog!".split(" ")));
        for (String  s: strings){
            System.out.print(s + " ");
        }
        System.out.println();
        for (String s : strings.reversed()){
            System.out.print(s + " ");
        }
    }
}
