package main.java.core.holding;

import typyinfo.pets.Pet;
import typyinfo.pets.Pets;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-14 15:35:35
 * @Modified By:
 */
public class ListIteration {
    public static void main(String[] args) {
        ArrayList<Pet> pets = Pets.arrayList(8);
        ListIterator<Pet> it = pets.listIterator();
        System.out.println(pets);
        while(it.hasNext()){
            System.out.println(it.next() + ", " + it.nextIndex() + ", " + it.previousIndex() + "; ");
        }
        // 向前迭代
        while (it.hasPrevious()){
            System.out.println(it.previous().id() + " ");
        }
        System.out.println("=========");
        it = pets.listIterator(3);
        while (it.hasNext()){
            it.next();
            it.set(Pets.randomPet());
        }
        System.out.println(pets);
    }
}
