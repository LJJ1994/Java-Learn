package main.java.core.containers;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-24 09:03:03
 * @Modified By:
 */
public class GroundHog {
    protected int number;
    public GroundHog(int number){
        this.number = number;
    }
    public String toString(){
        return "GroundHog #" + number;
    }
}
