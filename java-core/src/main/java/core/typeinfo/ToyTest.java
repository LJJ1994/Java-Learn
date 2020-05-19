package main.java.core.typeinfo;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-20 15:09:09
 * @Modified By:
 */
interface HasBatteries{}
interface WaterProof{}
interface Shoots{}

class Toy{
    Toy(){}
    Toy(int i){}
}

class FancyToy extends Toy implements HasBatteries, WaterProof, Shoots{
    FancyToy(){
        super(1);
    }
}

public class ToyTest {
    static void printInfo(Class cc){
        System.out.println("CC Name: " + cc.getName() + " is Interface ? " + "[" + cc.isInterface() + "]");
        System.out.println("Simple Name: " + cc.getSimpleName());
        System.out.println("Canonical Name: " + cc.getCanonicalName());
    }

    public static void main(String[] args) {
        Class c = null;
        try{
            c = Class.forName("main.java.core.typeinfo.FancyToy");
        } catch (ClassNotFoundException e){
            System.out.println("can not found class");
            System.exit(0);
        }
        printInfo(c);
        System.out.println("================================");
        for (Class anInterface : c.getInterfaces()) {
            printInfo(anInterface);
        }
        System.out.println("================================");
        Class up = c.getSuperclass();
        Object obj = null;
        try{
            obj = up.newInstance();
        } catch (IllegalAccessException e){
            System.out.println("Can not Access!");
            System.exit(1);
        } catch (InstantiationException e){
            System.out.println("Can not Instantiation!");
            System.exit(1);
        }
        printInfo(obj.getClass());
        System.out.println("===================================");
        printInfo(Toy.class);
    }
}
