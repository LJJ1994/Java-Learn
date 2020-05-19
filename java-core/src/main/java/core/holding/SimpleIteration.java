package main.java.core.holding;

import typyinfo.pets.Pet;
import typyinfo.pets.Pets;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-14 15:15:15
 * @Modified By:
 */
public class SimpleIteration {
    public static void main(String[] args) {
        List<Pet> pets = Pets.arrayList(12);
        Iterator<Pet> iterator = pets.iterator();
        while(iterator.hasNext()){
            Pet pet = iterator.next();
            System.out.println(pet.id() + ": " + pet + " ");
        }
        System.out.println("==============");
        for (Pet p :pets ) {
            System.out.println(p.id() + ": " + p + " ");
        }

        iterator = pets.iterator();
        for (int i = 0; i < 6; i++) {
            iterator.next();
            iterator.remove();
        }
        System.out.println(pets);
    }
}
