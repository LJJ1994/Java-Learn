package main.java.core.containers;

import java.util.List;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-24 13:48:48
 * @Modified By:
 */
public class Tester<C> {
    private static int fieldWidth = 8;
    public static TestParam[] defaultParams = TestParam.array(10, 5000, 100, 5000, 1000, 5000, 10000, 500);
    protected C container;
    protected C initialize(int size){
        return container;
    }
    private String headline = "";
    private List<Test<C>> tests;


}
