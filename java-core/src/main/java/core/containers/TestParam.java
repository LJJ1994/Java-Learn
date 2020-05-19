package main.java.core.containers;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-24 13:41:41
 * @Modified By:
 */
public class TestParam {
    private final int size;
    private final int loops;
    public TestParam(int size, int loops){
        this.size = size;
        this.loops = loops;
    }

    public static TestParam[] array(int... values){
        int size = values.length / 2;
        TestParam[] result = new TestParam[size];
        int n = 0;
        for (int i = 0; i < size; i++) {
            result[i] = new TestParam(values[n++], values[n++]);
        }
        return result;
    }

    public static TestParam[] array(String[] values){
        int[] vals = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            vals[i] = Integer.decode(values[i]);
        }
        return array(vals);
    }
}
