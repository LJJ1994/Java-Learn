package main.java.core.innerclasses.controller;

import javax.sound.sampled.Control;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-13 21:37:37
 * @Modified By:
 */
public class GreenHouseControls extends Controller {
    private boolean light = false;

    public class LightOn extends Event{
        public LightOn(long delayTime){
            super(delayTime);
        }
        @Override
        public void action() {
            light = true;
        }
        public String toString(){
            return "Light is on.";
        }
    }


    public class LightOff extends Event{
        public LightOff(long delayTime){
            super(delayTime);
        }
        @Override
        public void action() {
            light = false;
        }
        public String toString(){
            return "Light is off.";
        }
    }

    private boolean water = false;

    public class WaterOn extends Event{
        public WaterOn(long delayTime){
            super(delayTime);
        }
        @Override
        public void action() {
            water = true;
        }
        public String toString(){
            return "Water is on.";
        }
    }
    public class WaterOff extends Event{
        public WaterOff(long delayTime){
            super(delayTime);
        }
        @Override
        public void action() {
            water = false;
        }
        public String toString(){
            return "Water is off.";
        }
    }

    private String thermostat = "Day";
    public class ThermostatDay extends Event{
        public ThermostatDay(long delayTime){
            super(delayTime);
        }

        @Override
        public void action() {
            thermostat = "Day";
        }
        public String toString(){
            return "Thermostat is Day.";
        }
    }

    public class ThermostatNight extends Event{
        public ThermostatNight(long delayTime){
            super(delayTime);
        }

        @Override
        public void action() {
            thermostat = "Night";
        }
        public String toString(){
            return "Thermostat is Night.";
        }
    }

    public class Bell extends Event{
        public Bell(long delayTime){
            super(delayTime);
        }
        @Override
        public void action() {
            addEvent(new Bell(delayTime));
        }
        public String toString(){
            return "Bell ring!";
        }
    }

    public class Restart extends Event{
        private Event[] eventList;

        public Restart(long delayTime, Event[] e){
            super(delayTime);
            eventList = e;
            for (Event event : eventList) {
                addEvent(event);
            }
        }
        @Override
        public void action() {
            for(Event event : eventList){
                event.start();
                addEvent(event);
            }
            start();
            addEvent(this);
        }
        public String toString(){
            return "System restart....";
        }
    }

    public static class Terminate extends Event{
        public Terminate(long time){
            super(time);
        }
        @Override
        public void action() {
            System.exit(0);
        }
        public String toString(){
            return "system terminating...";
        }
    }
}
