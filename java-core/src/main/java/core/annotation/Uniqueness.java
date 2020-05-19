package main.java.core.annotation;

public @interface Uniqueness {
    Constraints constrains() default @Constraints(unique = true);
}
