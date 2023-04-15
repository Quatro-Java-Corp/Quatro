package factory;

import java.util.List;
import java.util.Map.Entry;

import factory.ShapeFactory.ArgumentType;
import shapes.Circle;

public class CircleFactoryWorker implements ShapeFactoryWorker {
    public Circle create(String shapeName, List<Entry<ArgumentType, Double>> args) throws Exception {
        if (!shapeName.equalsIgnoreCase(Circle.name)) {
            return null;
        }

        if (args.size() != Circle.numberOfArguments) {
            throw new Exception("Invalid number of arguments for Circle");
        }

        var arg = args.get(0);

        return switch (arg.getKey()) {
            case area -> Circle.withSurfaceArea(arg.getValue());
            case circuit -> Circle.withCircuit(arg.getValue());
            case diameter -> Circle.withDiameter(arg.getValue());
            case radius -> Circle.withRadius(arg.getValue());
            default -> throw new Exception("Unknown combination of arguments for circle");
        };
    }
}
