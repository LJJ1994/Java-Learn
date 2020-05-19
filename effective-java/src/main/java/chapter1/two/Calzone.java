package chapter1.two;

/**
 * @Author: LJJ
 * @Program: effective-java
 * @Description:
 * @Create: 2020-05-08 21:25:25
 * @Modified By:
 */
public class Calzone extends Pizza {
    private final boolean sauceInsize;
    public static class Builder extends Pizza.Builder<Builder>{
        private boolean sauceInside = false;
        public Builder sauceInside(){
            sauceInside = true;
            return this;
        }
        @Override
        protected Builder self() {
            return this;
        }

        @Override
        public Calzone build() {
            return new Calzone(this);
        }
    }
    private Calzone(Builder builder) {
        super(builder);
        sauceInsize = builder.sauceInside;
    }

    @Override
    public String toString() {
        return "Calzone{" +
                "sauceInsize=" + sauceInsize +
                ", toppings=" + toppings +
                '}';
    }

    public static void main(String[] args) {
        Calzone calzone = new Builder().addTopping(Topping.HAM).sauceInside().build();
        System.out.println(calzone);
    }
}
