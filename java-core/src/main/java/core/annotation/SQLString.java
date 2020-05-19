package main.java.core.annotation;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SQLString {
    public String name() default "";
    public int value() default 0;
    Constraints constrains() default @Constraints;
}
