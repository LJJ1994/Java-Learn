package main.java.core.generics;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-21 20:10:10
 * @Modified By:
 */
class Product{
    private int id;
    private String description;
    private double price;
    public Product(int id, String description, double price){
        this.id = id;
        this.description = description;
        this.price = price;
        System.out.println(toString());
    }
    public static Generator<Product> generator = new Generator<Product>() {
        private Random rand = new Random(47);
        @Override
        public Product next() {
            return new Product(rand.nextInt(1000), "Test",
                    Math.round(rand.nextDouble()*1000.0)+0.99);
        }
    };
    public String toString(){
        return id + ": " + description + " price: $" + price;
    }
    public void priceChange(double change){
        price += change;
    }
}

class Shelf extends ArrayList<Product>{
    public Shelf(int nProducts){
        Generators.fill(this, Product.generator, nProducts);
    }
}

class Aisle extends ArrayList<Shelf>{
    public Aisle(int nShelfs, int nProducts){
        for (int i = 0; i < nShelfs; i++) {
            add(new Shelf(nProducts));
        }
    }
}

class Office{}
class CheckoutStand{}

public class Store extends ArrayList<Aisle>{
    private List<CheckoutStand> checkoutStands = new ArrayList<>();
    private Office office = new Office();
    public Store(int nAisles, int nShelfs, int nProduct){
        for (int i = 0; i < nAisles; i++) {
            add(new Aisle(nShelfs, nProduct));
        }
    }
    public String toString(){
        StringBuilder result = new StringBuilder();
        for(Aisle a : this){
            for (Shelf s : a){
                for (Product p : s){
                    result.append(p);
                    result.append("\n");
                }
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Store(14, 5, 10));
    }
}
