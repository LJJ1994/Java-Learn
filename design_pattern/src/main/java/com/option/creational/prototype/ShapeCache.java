package com.option.creational.prototype;

import com.option.creational.prototype.impl.Circle;
import com.option.creational.prototype.impl.Rectangle;
import com.option.creational.prototype.impl.Square;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ShapeCache {
    private static Map<Integer, Shape> cacheMap = new ConcurrentHashMap<Integer, Shape>();

    public static Shape getShape(Integer id) {
        Shape shape = cacheMap.get(id);
        return (Shape) shape.clone();
    }

    public static void loadCache() {
        Circle circle = new Circle();
        circle.setId(1);
        cacheMap.put(circle.getId(), circle);

        Rectangle rectangle = new Rectangle();
        rectangle.setId(2);
        cacheMap.put(rectangle.getId(), rectangle);

        Square square = new Square();
        square.setId(3);
        cacheMap.put(square.getId(), square);
    }
}
