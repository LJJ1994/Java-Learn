package main.java.core.interfaces;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-12 19:29:29
 * @Modified By:
 */
interface CanFight{
    void fight();
}

interface CanSwim{
    void swim();
}

interface CanFly{
    void fly();
}

class ActionCharacter{
    public void fight(){
        System.out.println("action fight!");
    }
}

class Hero extends ActionCharacter implements CanFight, CanFly, CanSwim{

    @Override
    public void swim() {
        System.out.println("hero swim");
    }

    @Override
    public void fly() {
        System.out.println("hero fly");
    }
}

public class Adventure {
    public static void f(CanFight f){
        f.fight();
    }
    public static void s(CanSwim c){
        c.swim();
    }

    public static void l(CanFly l){
        l.fly();
    }

    public static void w(ActionCharacter a){
        a.fight();
    }

    public static void main(String[] args) {
        Hero hero = new Hero();
        f(hero);
        s(hero);
        l(hero);
        w(hero);
    }
}
