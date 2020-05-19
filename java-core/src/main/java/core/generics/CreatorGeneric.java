package main.java.core.generics;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-22 04:51:51
 * @Modified By:
 */
abstract class CreateWithGeneric<T>{
    T element;
    CreateWithGeneric(){
        element = create();
    }
    abstract T create();
}

class X{}
class Creator extends CreateWithGeneric<X>{

    @Override
    X create() {
        return new X();
    }
    public void f(){
        System.out.println(element.getClass().getSimpleName());
    }
}

public class CreatorGeneric {
    public static void main(String[] args) {
        Creator creator = new Creator();
        creator.f();
    }
}
