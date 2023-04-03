package Model.ShapeFactoryWorkers;

import Model.Shapes.Circle;
import Model.ShapeFactory;

public class CircleWorker implements ShapeFactoryWorker {

    public String[] parameterTypes = {
            "surfaceArea", "circuit", "diameter", "radius",
    };

    public boolean acceptParameters(String ShapeName, String[] parametersTypes, Double[] parametersValues) {
        return ShapeName == "circle"
                && parametersTypes.length == 1
                && parametersValues.length == 1
                && ShapeFactory.checkParametersTypes(parametersTypes, parametersTypes);
    }

    public Circle create(String[] parametersTypes, Double[] parametersValues) throws Exception {
        double radius = switch (parametersTypes[0]) {
            case "surfaceArea" -> Math.pow(parametersValues[0] / Math.PI, 0.5);
            case "circuit" -> parametersValues[0] / Math.PI / 2;
            case "diameter" -> parametersValues[0] / 2;
            default -> parametersValues[0];
        };

        return new Circle(radius, Circle.ConstructorType.radius);
    }
}
