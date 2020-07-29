package com.option.creational.builder;

import com.option.creational.builder.item.impl.ChickenBurger;
import com.option.creational.builder.item.impl.Coke;
import com.option.creational.builder.item.impl.Pepsi;
import com.option.creational.builder.item.impl.VegBurger;

public class MealBuilder {
    public Meal prepareVegMeal(){
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new Coke());
        return meal;
    }

    public Meal prepareNoVegMeal(){
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new Pepsi());
        return meal;
    }
}
