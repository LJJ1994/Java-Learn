package main.java.core.generics;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-22 04:29:29
 * @Modified By:
 */
class Building{}
class House extends Building{}
public class ClassTypeCapture<T> {
    private Class<T> kind;
    public ClassTypeCapture(Class<T> tClass){
        kind = tClass;
    }
    public boolean f(Object obj){
        return kind.isInstance(obj);
    }

    public static void main(String[] args) {
        ClassTypeCapture<Building> building = new ClassTypeCapture<>(Building.class);
        System.out.println(building.f(new Building()));
        System.out.println(building.f(new House()));
        System.out.println("======================");
        ClassTypeCapture<House> house = new ClassTypeCapture<>(House.class);
        System.out.println(house.f(new Building()));
        System.out.println(house.f(new House()));
    }
}
