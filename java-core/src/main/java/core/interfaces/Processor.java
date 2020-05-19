package main.java.core.interfaces;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-12 18:41:41
 * @Modified By:
 */
public interface Processor {
    String name();
    Object process(Object input);
}
