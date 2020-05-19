package main.java.core.containers;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-24 09:16:16
 * @Modified By:
 */
public class GroundHog2 extends GroundHog {
    public GroundHog2(int n){
        super(n);
    }
    public boolean equals(Object object){
        return object instanceof GroundHog2 && (((GroundHog2)object).number == number);
    }
    public int hashCode(){
        return number;
    }
}
