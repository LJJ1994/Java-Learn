package main.java.core.innerclasses.controller;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-13 21:31:31
 * @Modified By:
 */
public class Controller {
    private List<Event> eventList = new ArrayList<>();
    public void addEvent(Event e){
        eventList.add(e);
    }

    public void run(){
        while (eventList.size() > 0){
            for (Event e : new ArrayList<>(eventList)){
                if(e.ready()){
                    System.out.println(e);
                    e.action();
                    eventList.remove(e);

                }
            }
        }
    }
}
