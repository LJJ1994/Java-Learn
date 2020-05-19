package main.java.core.containers;

import java.util.Random;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-24 09:04:04
 * @Modified By:
 */
public class Prediction {
    private static Random rand = new Random(47);
    private boolean shadow = rand.nextDouble() > 0.5;
    public String toString(){
        if (shadow){
            return "Six more weeks of Winter";
        }
        return "Early Spring";
    }
}
