package main.java.core.enumerated;

import net.mindview.util.OSExecute;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Set;
import java.util.TreeSet;

enum Explore{
    HERE,
    THERE
}

public class Reflection {
    public static Set<String> analyze(Class<?> enumClass){
        System.out.println("------Analyze Class: " + enumClass + "-------------");
        System.out.println("interface: ");
        for (Type in : enumClass.getGenericInterfaces()) {
            System.out.println(in);
        }
        System.out.println("Base: " + enumClass.getSuperclass());
        System.out.println("methods: ");
        Set<String> methods = new TreeSet<>();
        for (Method declaredMethod : enumClass.getDeclaredMethods()) {
            methods.add(declaredMethod.getName());
        }
        System.out.println(methods);
        return methods;
    }

    public static void main(String[] args) {
        Set<String> exploreMethods = analyze(Explore.class);
        Set<String> enumMethods = analyze(Enum.class);
        System.out.println(exploreMethods.containsAll(enumMethods));
        OSExecute.command("javap Explore");
    }
}
