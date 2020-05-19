package main.java.core.annotation;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Constraints {
    public boolean primaryKey() default false;
    public boolean allowNull() default true;
    public boolean unique() default false;
}
