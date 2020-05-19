package main.java.core.innerclasses.controller;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-13 21:52:52
 * @Modified By:
 */
public class GreenHouseController {
    public static void main(String[] args) {
        GreenHouseControls gc = new GreenHouseControls();
        gc.addEvent(gc.new Bell(900));
        Event[] eventList = {
                gc.new ThermostatNight(0),
                gc.new LightOn(900),
                gc.new LightOff(1000),
                gc.new WaterOn(900),
                gc.new WaterOff(900),
                gc.new ThermostatDay(1000)
        };
        gc.addEvent(gc.new Restart(1000, eventList));
        gc.addEvent(new GreenHouseControls.Terminate(1000));
        gc.run();
    }
}
