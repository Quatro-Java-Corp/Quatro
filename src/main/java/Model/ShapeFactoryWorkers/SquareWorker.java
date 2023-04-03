package Model.ShapeFactoryWorkers;

import Model.ShapeFactory;
import Model.Shapes.Square;

public class SquareWorker implements ShapeFactoryWorker {

    public String[] parameterTypes = {
        "surfaceArea", "diagonalLength", "sideLength",
    };

    public boolean acceptParameters(String ShapeName, String[] parametersTypes, Double[] parametersValues) {
        return ShapeName == "square"
                && parametersTypes.length == 1
                && parametersValues.length == 1
                && ShapeFactory.checkParametersTypes(parametersTypes, parametersTypes);
    }

    public Square create(String[] parametersTypes, Double[] parametersValues) throws Exception {
        double sideLength = switch (parametersTypes[0]) {
            case "surfaceArea" -> Math.pow(parametersValues[0], 0.5);
            case "diagonalLength" -> Math.pow(parametersValues[0] * parametersValues[0] / 2, 0.5);
            default -> parametersValues[0];
        };

        return new Square(sideLength, Square.ConstructorType.sideLength);
    }
}
