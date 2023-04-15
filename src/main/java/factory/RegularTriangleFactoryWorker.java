package factory;

import java.util.List;
import java.util.Map.Entry;

import factory.ShapeFactory.ArgumentType;
import shapes.RegularTriangle;

public class RegularTriangleFactoryWorker implements ShapeFactoryWorker {
    public RegularTriangle create(String shapeName, List<Entry<ArgumentType, Double>> args) throws Exception {
        if (!shapeName.equalsIgnoreCase(RegularTriangle.name)) {
            return null;
        }

        if (args.size() != RegularTriangle.numberOfArguments) {
            throw new Exception("Invalid number of arguments for RegularTriangle");
        }

        var arg = args.get(0);

        return switch (arg.getKey()) {
            case area -> RegularTriangle.withSurfaceArea(arg.getValue());
            case height -> RegularTriangle.withHeight(arg.getValue());
            case side -> RegularTriangle.withSide(arg.getValue());
            default -> throw new Exception("Unknown argument Type for regular triangle");
        };
    }
}
