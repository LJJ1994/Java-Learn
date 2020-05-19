package main.java.core.generics;

import java.util.*;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-21 19:48:48
 * @Modified By:
 */
class Customer{
    private static long counter=0;
    private final long id=counter++;
    private Customer(){
    }
    public String toString(){
        return "Customer " + id;
    }
    public static Generator<Customer> generator(){
        return new Generator<Customer>() {
            @Override
            public Customer next() {
                return new Customer();
            }
        };
    }
}

class Teller{
    private static long counter=0;
    private final long id=counter++;
    private Teller(){}
    public String toString(){
        return "Teller " + id;
    }
    public static Generator<Teller> generator = new Generator<Teller>() {
        @Override
        public Teller next() {
            return new Teller();
        }
    };
}

public class BankTeller {
    public static void serves(Teller t, Customer c){
        System.out.println(t + "serves " + c);
    }

    public static void main(String[] args) {
        Random rand = new Random(47);
        Queue<Customer> line = new LinkedList<>();
        Generators.fill(line, Customer.generator(), 10);
        List<Teller> tellers = new ArrayList<>();
        Generators.fill(tellers, Teller.generator, 4);
        for (Customer customer : line) {
            serves(tellers.get(rand.nextInt(tellers.size())), customer);
        }
    }
}
