package main.java.core.annotation;

import java.lang.reflect.Method;
import java.util.*;

public class UseCaseTracker {
    public static void trackedUseCase(List<Integer> useCases, Class<?> cl){
        for (Method method : cl.getDeclaredMethods()) {
            UseCase uc = method.getAnnotation(UseCase.class);
            if (uc != null){
                System.out.println("Found usecase: " + uc.id() + " " + uc.description());
                useCases.remove(Integer.valueOf(uc.id()));
            }
        }
        for (Integer useCase : useCases) {
            System.out.println("warning: Missing usecase-" + useCase);
        }
    }

    public static void main(String[] args) {
        List<Integer> usecases = new ArrayList<>();
        Collections.addAll(usecases, 47, 48, 49, 50);
        trackedUseCase(usecases, PasswordUtils.class);
        Map<String, String> map = new HashMap<>();

    }
}
