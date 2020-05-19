package main.java.core.generics;

import main.java.core.generics.coffee.*;

import java.util.Iterator;
import java.util.Random;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-20 23:19:19
 * @Modified By:
 */
public class CoffeeGenerator implements Generator<Coffee>, Iterable<Coffee> {
    private int size = 0;
    private static Random rand = new Random(47);
    private Class[] types = {Latee.class, Mocha.class, Americano.class, Cappuccino.class, Breeve.class};

    public CoffeeGenerator(int size){
        this.size = size;
    }
    class CoffeeIterator implements Iterator<Coffee>{
        int counter = size;
        public boolean hasNext(){
            return counter > 0;
        }
        public Coffee next(){
            counter--;
            return CoffeeGenerator.this.next();
        }
        public void remove(){
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public Iterator<Coffee> iterator(){
        return new CoffeeIterator();
    }

    @Override
    public Coffee next() {
        try{
            return (Coffee) types[rand.nextInt(types.length)].newInstance();
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        CoffeeGenerator coffees = new CoffeeGenerator(10);
        for (int i = 0; i < 5; i++) {
            System.out.println(coffees.next());
        }
        System.out.println("==============================");
        for (Coffee coffee : new CoffeeGenerator(5)){
            System.out.println(coffee);
        }
    }
}
