package main.java.core.holding;

import java.util.Iterator;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-14 18:08:08
 * @Modified By:
 */
public class IteratorClass implements Iterable<String> {
    protected String[] words = ("we are dog!").split(" ");
    @Override
    public Iterator<String> iterator() {

        return new Iterator<String>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index < words.length;
            }

            @Override
            public String next() {
                return words[index++];
            }
            public void remove(){
                throw new UnsupportedOperationException();
            }
        };
    }

    public static void main(String[] args) {
        IteratorClass strings = new IteratorClass();
        for (String s : strings){
            System.out.println(s);
        }
    }
}
