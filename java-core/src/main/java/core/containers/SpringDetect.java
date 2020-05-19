package main.java.core.containers;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-24 09:06:06
 * @Modified By:
 */
public class SpringDetect {
    public static <T extends GroundHog> void springDetect(Class<T> type) throws Exception{
        Constructor<T> ghog = type.getConstructor(int.class);
        Map<GroundHog, Prediction> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put(ghog.newInstance(i), new Prediction());
        }
        System.out.println("map= " + map);

        GroundHog gh = ghog.newInstance(3);
        System.out.println("looking up prediction for " + gh);
        if (map.containsKey(gh)){
            System.out.println(map.get(gh));
        }else{
            System.out.println("Key not found: " + gh);
        }
    }

    public static void main(String[] args) throws Exception {
        springDetect(GroundHog.class);
    }
}
