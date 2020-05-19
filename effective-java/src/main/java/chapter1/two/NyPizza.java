package chapter1.two;

import java.util.Objects;

/**
 * @Author: LJJ
 * @Program: effective-java
 * @Description:
 * @Create: 2020-05-08 21:21:21
 * @Modified By:
 */
public class NyPizza extends Pizza {
    public enum Size{SMALL, MEDIUM, LARGE}
    private final Size size;
    public static class Builder extends Pizza.Builder<Builder>{
        private final Size size;
        public Builder(Size size){
            this.size = Objects.requireNonNull(size);
        }
        @Override
        protected Builder self() {
            return this;
        }

        @Override
        Pizza build() {
            return new NyPizza(this);
        }
    }
    private NyPizza(Builder builder) {
        super(builder);
        size = builder.size;
    }
}
