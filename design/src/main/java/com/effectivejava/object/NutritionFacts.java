package com.effectivejava.object;

/**
 * @description: 使用Builder模式来创建对象
 * @author: yangjiang
 * @create: 2021-03-08 17:30
 **/
public class NutritionFacts {
    //为了使对象不可变，需要让所有的域为private
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    public static class Builder {
        //必须的参数
        private final int servingSize;
        private final int servings;

        //可选的参数
        private int calories;
        private int fat;
        private int sodium;
        private int carbohydrate;


        //1、利用所有必需的参数调用构造器来生成一个Builder对象
        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }


        //2、在builder对象上调用类似setter的方法，来设置每个可选的参数
        public Builder calories(int val) {
            calories = val;
            return this;
        }

        public Builder fat(int val) {
            fat = val;
            return this;
        }

        public Builder sodium(int val) {
            sodium = val;
            return this;
        }

        public Builder carbohydrate(int val) {
            carbohydrate = val;
            return this;
        }


        //3、调用无参的build方法来生成目标对象
        public NutritionFacts build() {
            return new NutritionFacts(this);
        }

    }

    @Override
    public String toString() {
        return "NutritionFacts{" +
                "servingSize=" + servingSize +
                ", servings=" + servings +
                ", calories=" + calories +
                ", fat=" + fat +
                ", sodium=" + sodium +
                ", carbohydrate=" + carbohydrate +
                '}';
    }

    private NutritionFacts(Builder builder) {
        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }
}
