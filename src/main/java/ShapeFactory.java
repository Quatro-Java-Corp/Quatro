import shapes.*;

import java.util.List;

public class ShapeFactory {

    public enum ShapeName {
        circle, square, rectangle, rhombus, regulartriangle
    }

    public enum ArgumentType {
        side, diagonal, area, radius, diameter, circuit, height
    }

    public Shape createShape(
            ShapeName shapeName,
            List<ArgumentType> parametersNames,
            List<Double> parametersValues) throws Exception {
        return switch (shapeName) {
            case circle -> convertCircleInputType(parametersNames, parametersValues);
            case square -> convertSquareInputType(parametersNames, parametersValues);
            case rectangle -> convertRectangleInputType(parametersNames, parametersValues);
            case rhombus -> convertRhombusInputType(parametersNames, parametersValues);
            case regulartriangle -> convertRegulartriangleInputType(parametersNames, parametersValues);
        };
    }

    private static Circle convertCircleInputType(List<ArgumentType> paramsTypes, List<Double> paramsValues) throws Exception {
        if (paramsTypes.size() != 1) {
            throw new Exception("Invalid number of arguments for circle");
        }

        double value = paramsValues.get(0);

        return switch (paramsTypes.get(0)) {
            case area -> Circle.withSurfaceArea(value);
            case circuit -> Circle.withCircuit(value);
            case diameter -> Circle.withDiameter(value);
            case radius -> Circle.withRadius(value);
            default -> throw new Exception("Unknown combination of arguments for circle");
        };
    }

    private static Square convertSquareInputType(List<ArgumentType> paramsTypes, List<Double> paramsValues) throws Exception {
        if (paramsTypes.size() != 1) {
            throw new Exception("Invalid number of arguments for square");
        }

        double value = paramsValues.get(0);

        return switch (paramsTypes.get(0)) {
            case area -> Square.withSurfaceArea(value);
            case diagonal -> Square.withDiagonalLength(value);
            case side -> Square.withSideLength(value);
            default -> throw new Exception("Unknown combination of arguments for square");
        };
    }

    private static Rectangle convertRectangleInputType(List<ArgumentType> paramsTypes, List<Double> paramsValues) throws Exception {
        if (paramsTypes.size() != 2) {
            throw new Exception("Invalid number of arguments for rectangle");
        }

        double value1 = paramsValues.get(0);
        double value2 = paramsValues.get(1);

        return switch (paramsTypes.get(0).toString() + "|" + paramsTypes.get(1).toString()) {
            case "side|side" -> Rectangle.withShortSideAndLongSide(value1, value2);
            case "side|diagonal" -> Rectangle.withShortSideAndDiagonal(value1, value2);
            case "side|area" -> Rectangle.withShortSideAndSurfaceArea(value1, value2);
            case "diagonal|side" -> Rectangle.withShortSideAndDiagonal(value2, value1);
            case "diagonal|area" -> Rectangle.withDiagonalAndSurfaceArea(value1, value2);
            case "area|side" -> Rectangle.withLongSideAndSurfaceArea(value2, value1);
            case "area|diagonal" -> Rectangle.withDiagonalAndSurfaceArea(value2, value1);
            default -> throw new Exception("Unknown combination of arguments for rectangle");
        };
    }

    private static Rhombus convertRhombusInputType(List<ArgumentType> paramsTypes, List<Double> paramsValues) throws Exception {
        if (paramsTypes.size() != 2) {
            throw new Exception("Invalid number of arguments for rhombus");
        }

        double value1 = paramsValues.get(0);
        double value2 = paramsValues.get(1);

        return switch (paramsTypes.get(0).toString() + "|" + paramsTypes.get(1).toString()) {
            case "diagonal|diagonal" -> Rhombus.withShortDiagonalAndLongDiagonal(value1, value2);
            case "diagonal|side" -> Rhombus.withShortDiagonalAndSide(value1, value2);
            case "diagonal|area" -> Rhombus.withShortDiagonalAndSurfaceArea(value1, value2);
            case "side|diagonal" -> Rhombus.withShortDiagonalAndSide(value2, value1);
            case "side|area" -> Rhombus.withSideLengthAndSurfaceArea(value1, value2);
            case "area|diagonal" -> Rhombus.withShortDiagonalAndSurfaceArea(value2, value1);
            case "area|side" -> Rhombus.withSideLengthAndSurfaceArea(value2, value1);
            default -> throw new Exception("Unknown combination of arguments for rhombus");
        };
    }

    private static RegularTriangle convertRegulartriangleInputType(List<ArgumentType> paramsTypes, List<Double> paramsValues) throws Exception {
        if (paramsTypes.size() != 1) {
            throw new Exception("Invalid number of arguments for regular triangle");
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
