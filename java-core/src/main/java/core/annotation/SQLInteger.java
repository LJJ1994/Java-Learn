package main.java.core.annotation;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SQLInteger {
    public String name() default "";
    public Constraints constrains() default @Constraints;
}
