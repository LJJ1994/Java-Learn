package com.option.creational.builder;

import com.option.creational.builder.item.Item;

import java.util.ArrayList;
import java.util.List;

public class Meal {
    private List<Item> items = new ArrayList<Item>();

    public void addItem(Item item){
        items.add(item);
    }

    public float getCost(){
        float cost = 0F;
        for (Item item : items) {
            cost += item.price();
        }
        return cost;
    }

    public void showItems(){
        for (Item item : items) {
            System.out.print("Name: " + item.name());
            System.out.print(", " + "Price: " + item.price());
            System.out.println(", " + "Packing: " + item.pack().packing());
        }
    }
}
