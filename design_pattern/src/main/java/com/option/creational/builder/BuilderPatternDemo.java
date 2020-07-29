package com.option.creational.builder;

public class BuilderPatternDemo {
    public static void main(String[] args) {
        MealBuilder mealBuilder = new MealBuilder();
        Meal meal = mealBuilder.prepareVegMeal();
        meal.showItems();
        System.out.println(meal.getCost());
        System.out.println("======================");

        Meal noVegMeal = mealBuilder.prepareNoVegMeal();
        noVegMeal.showItems();
        System.out.println(noVegMeal.getCost());
    }
}
