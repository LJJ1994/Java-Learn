package com.option.behavioral.iterator;

import com.option.behavioral.iterator.impl.NameRepository;

public class IteratorPatternDemo {
    public static void main(String[] args) {
        NameRepository nameRepository = new NameRepository();
        for (Iterator iterator = nameRepository.getIterator(); iterator.hasNext();){
            String name = (String) iterator.next();
            System.out.println("Name: " + name);
        }
    }
}
