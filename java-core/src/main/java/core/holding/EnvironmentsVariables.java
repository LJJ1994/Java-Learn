package main.java.core.holding;

import java.util.Map;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-14 18:15:15
 * @Modified By:
 */
public class EnvironmentsVariables {
    public static void main(String[] args) {
        for(Map.Entry entry : System.getenv().entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
