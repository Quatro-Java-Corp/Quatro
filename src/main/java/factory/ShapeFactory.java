package factory;

import shapes.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import exceptions.factory.UnknownShapeException;

public class ShapeFactory {

    public enum ArgumentType {
        side, diagonal, area, radius, diameter, circuit, height, base, cathetus, hypotenuse, semiminoraxis, semimajoraxis, shortbase, longbase
    }

    private final Map<String, ShapeFactoryWorker> workers = new HashMap<>();

    public ShapeFactory() {
        registerWorker(CircleFactoryWorker.shapeName, new CircleFactoryWorker());
        registerWorker(SquareFactoryWorker.shapeName, new SquareFactoryWorker());
        registerWorker(RegularTriangleFactoryWorker.shapeName, new RegularTriangleFactoryWorker());
        registerWorker(RectangleFactoryWorker.shapeName, new RectangleFactoryWorker());
        registerWorker(RhombusFactoryWorker.shapeName, new RhombusFactoryWorker());
        registerWorker(IsoscelesTriangleFactoryWorker.shapeName, new IsoscelesTriangleFactoryWorker());
        registerWorker(RightTriangleFactoryWorker.shapeName, new RightTriangleFactoryWorker());
        registerWorker(EllipseFactoryWorker.shapeName, new EllipseFactoryWorker());
        registerWorker(IsoscelesTrapezoidFactoryWorker.shapeName, new IsoscelesTrapezoidFactoryWorker());
        registerWorker(TriangleFactoryWorker.shapeName, new TriangleFactoryWorker());
    }

    private void registerWorker(String shapeName, ShapeFactoryWorker worker) {
        workers.put(shapeName, worker);
    }

    public Shape createShape(String shapeName, List<Entry<ArgumentType, Double>> args) {
        if (workers.containsKey(shapeName.toLowerCase())) {
            return workers.get(shapeName.toLowerCase()).create(args);
        }
        throw new UnknownShapeException(shapeName);
    }
}
