package main.java.core.typeinfo;

import net.mindview.util.Generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-20 18:59:59
 * @Modified By:
 */
class Part {
    public String toString(){
        return getClass().getSimpleName();
    }
    private static List<Factory<? extends Part>> partFactories = new ArrayList<>();
    static {
        partFactories.add(new FuelFilter.Factory());
        partFactories.add(new AirFilter.Factory());
        partFactories.add(new OilFilter.Factory());
        partFactories.add(new FanBelt.Factory());
        partFactories.add(new PowerSteeringBelt.Factory());
        partFactories.add(new GeneratorBelt.Factory());
    }

    public static Random rand = new Random(47);
    public static Part createRandom(){
        int i = rand.nextInt(partFactories.size());
        return partFactories.get(i).create();
    }
}

class Filter extends Part{}

class FuelFilter extends Filter{
    public static class Factory implements main.java.core.typeinfo.Factory<FuelFilter> {

        @Override
        public FuelFilter create() {
            return new FuelFilter();
        }
    }
}

class AirFilter extends Filter{
    public static class Factory implements main.java.core.typeinfo.Factory<AirFilter>{

        @Override
        public AirFilter create() {
            return new AirFilter();
        }
    }
}

class OilFilter extends Filter{
    public static class Factory implements main.java.core.typeinfo.Factory<OilFilter>{

        @Override
        public OilFilter create() {
            return new OilFilter();
        }
    }
}

class Belt extends Part{}

class FanBelt extends Belt{
    public static class Factory implements main.java.core.typeinfo.Factory<FanBelt>{

        @Override
        public FanBelt create() {
            return new FanBelt();
        }
    }
}

class PowerSteeringBelt extends Belt{
    public static class Factory implements main.java.core.typeinfo.Factory<PowerSteeringBelt>{

        @Override
        public PowerSteeringBelt create() {
            return new PowerSteeringBelt();
        }
    }
}

class GeneratorBelt extends Belt{
    public static class Factory implements main.java.core.typeinfo.Factory<GeneratorBelt>{

        @Override
        public GeneratorBelt create() {
            return new GeneratorBelt();
        }
    }
}

public class RegisterFactories {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(Part.createRandom());
        }
    }
}
