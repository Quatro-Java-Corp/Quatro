package factory;

import java.util.List;

import factory.ShapeFactory.ArgumentType;
import factory.ShapeFactory.ShapeName;
import shapes.RegularTriangle;

public class RegularTriangleFactoryWorker implements IShapeFactoryWorker {
    private static ShapeName shapeName = ShapeName.regulartriangle;
    private static int numberOfArguments = 1;

    public RegularTriangle create(ShapeName shapeName, List<ArgumentType> paramsTypes, List<Double> paramsValues) throws Exception {
        if (shapeName != RegularTriangleFactoryWorker.shapeName) {
            return null;
        }

        if (paramsTypes.size() != RegularTriangleFactoryWorker.numberOfArguments) {
            throw new Exception("Invalid number of arguments for RegularTriangle");
        }

        double value = paramsValues.get(0);

        return switch (paramsTypes.get(0)) {
            case area -> RegularTriangle.withSurfaceArea(value);
            case height -> RegularTriangle.withHeight(value);
            case side -> RegularTriangle.withSide(value);
            default -> throw new Exception("Unknown argument Type for regular triangle");
        };
    }
}
