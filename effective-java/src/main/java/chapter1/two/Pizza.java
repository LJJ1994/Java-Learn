package chapter1.two;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

/**
 * @Author: LJJ
 * @Program: effective-java
 * @Description:
 * @Create: 2020-05-08 21:13:13
 * @Modified By:
 */
public abstract class Pizza {
    public enum Topping{ HAM, MUSHROOM, ONION, PEPPER, SAUSAGE}
    final Set<Topping> toppings;

    abstract static class Builder<T extends Builder<T>>{
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

        public T addTopping(Topping topping){
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }

        protected abstract T self();

        abstract Pizza build();
    }

    Pizza(Builder<?> builder){
        toppings = builder.toppings.clone();
    }
}
