package main.java.core.holding;

import typyinfo.pets.Hamster;
import typyinfo.pets.Pet;
import typyinfo.pets.Pets;
import typyinfo.pets.Rat;

import java.util.LinkedList;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-14 15:59:59
 * @Modified By:
 */
public class LinkedListFutures {
    public static void main(String[] args) {
        LinkedList<Pet> pets = new LinkedList<>(Pets.arrayList(8));
        System.out.println(pets);
        System.out.println("pets.getFirst() " + pets.getFirst());
        System.out.println("pets.element() " + pets.element());
        //pets.clear();
        //System.out.println("pets.peek() " + pets.peek()); return null
        //System.out.println("pets.getFirst() " + pets.getFirst()); throw exception NoSuchElement
        System.out.println("pets.remove() " + pets.remove());
        System.out.println("pets.removeFirst() " + pets.removeFirst());
        System.out.println("pets.poll() " + pets.poll());
        System.out.println(pets);

        pets.addFirst(new Rat());
        System.out.println("after addFirst() " + pets);
        pets.add(Pets.randomPet());
        System.out.println("after add " + pets);
        pets.offer(Pets.randomPet());
        System.out.println("after offer " + pets);
        pets.addLast(new Hamster());
        System.out.println("after addLast() " + pets);
        pets.removeLast();
        System.out.println("after removeLast() " + pets);
    }
}
