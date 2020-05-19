package main.java.core.interfaces.filters;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-12 18:47:47
 * @Modified By:
 */
public class Waveform {
    private static long counter = 0;
    private final long id = counter++;
    public String toString(){
        return "Waveform " + id;
    }
}
