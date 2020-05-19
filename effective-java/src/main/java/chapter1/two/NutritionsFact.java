package chapter1.two;

/**
 * @Author: LJJ
 * @Program: effective-java
 * @Description:
 * @Create: 2020-05-08 20:46:46
 * @Modified By:
 */
public class NutritionsFact {
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    public static class Builder{
        private final int servingSize;
        private final int servings;

        private int calories=0;
        private int fat = 0;
        private int sodium=0;
        private int carbohydrate=0;

        public Builder(int servingSize, int servings){
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder setCalories(int calories){
            this.calories = calories;
            return this;
        }

        public Builder setFat(int fat){
            this.fat = fat;
            return this;
        }

        public Builder setSodium(int sodium){
            this.sodium = sodium;
            return this;
        }

        public Builder setCarbohydrate(int carbohydrate){
            this.carbohydrate = carbohydrate;
            return this;
        }

        public NutritionsFact build(){
            return new NutritionsFact(this);
        }
    }

    private NutritionsFact(Builder builder){
        servingSize = builder.servingSize;
        servings = builder.servings;
        fat = builder.fat;
        calories = builder.calories;
        sodium = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }

    @Override
    public String toString() {
        return "NutritionsFact{" +
                "servingSize=" + servingSize +
                ", servings=" + servings +
                ", calories=" + calories +
                ", fat=" + fat +
                ", sodium=" + sodium +
                ", carbohydrate=" + carbohydrate +
                '}';
    }

    public static void main(String[] args) {
        NutritionsFact nutritionsFact = new Builder(240, 8)
                .setFat(0).setCalories(1).setSodium(2).setCarbohydrate(3).build();
        System.out.println(nutritionsFact);
    }
}
