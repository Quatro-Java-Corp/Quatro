package Model.ShapeFactoryWorkers;

import Model.ShapeFactory;
import Model.Shapes.Diamond;

public class DiamondWorker implements ShapeFactoryWorker {

    public String[] parameterTypes = {
        "surfaceArea", "diagonalLength", "sideLength",
    };

    public boolean acceptParameters(String ShapeName, String[] parametersTypes, Double[] parametersValues) {
        return ShapeName == "diamond"
                && parametersTypes.length == 2
                && parametersValues.length == 2
                && ShapeFactory.checkParametersTypes(parametersTypes, parametersTypes);
    }

    public Diamond create(String[] parametersTypes, Double[] parametersValues) throws Exception {
        String parameter1 = parametersTypes[0];
        String parameter2 = parametersTypes[1];

        double shortDiagonalLength = parametersValues[0];
        double longDiagonalLength = parametersValues[1];


        // if (parameter1 == "diagonalLength" && parameter2 == "diagonalLength") {
        //     return new Diamond(parametersValues[0], parametersValues[1]);
        // } else

        if (parameter1 == "sideLength" && parameter2 == "diagonalLength") {
            shortDiagonalLength = Math.sqrt(Math.pow(parametersValues[0], 2) + Math.pow(parametersValues[1]/2, 2));
        } else if (parameter1 == "diagonalLength" && parameter2 == "sideLength") {
            longDiagonalLength = Math.sqrt(Math.pow(parametersValues[1], 2) + Math.pow(parametersValues[0]/2, 2));
        } else if (parameter1 == "diagonalLength" && parameter2 == "surfaceArea") {
            shortDiagonalLength = parametersValues[0] / parametersValues[1] * 2;
        } else if (parameter1 == "diagonalLength" && parameter2 == "surfaceArea") {
            longDiagonalLength = parametersValues[1] / parametersValues[0] * 2;
        } else if (parameter1 == "sideLength" && parameter2 == "surfaceArea") {
            longDiagonalLength = Math.sqrt(Math.pow(parametersValues[1], 2) + Math.pow(parametersValues[0]/2, 2));
        }
        switch (parameter1 | parameter2) {
            case "diagonalLength" | "diagonalLength" :
            case SliderOne.A | SliderTwo.C :
                // Logic when State #1 is A, and State #2 is either A or C
                break;
            case SliderOne.B | SliderTwo.C :
                // Logic when State #1 is B, and State #2 is C
                break;
            case SliderOne.E | SliderTwo.E :
            default:
                // Logic when State #1 is E, and State #2 is E or
                // none of above match
                break;
        }


        if (parameter1 == "sideLength")
        double sideLength = switch (parametersTypes[0]) {
            case "surfaceArea" -> Math.pow(parametersValues[0], 0.5);
            case "diagonalLength" -> Math.pow(parametersValues[0] * parametersValues[0] / 2, 0.5);
            default -> parametersValues[0];
        };

        return new Diamond(sideLength, Diamond.ConstructorType.sideLength);
    }
}
