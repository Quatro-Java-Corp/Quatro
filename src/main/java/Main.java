import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            String[] inputArgs = input.split(" ");
            if (inputArgs.length == 1 && inputArgs[0].equals("exit")) {
                scanner.close();
                System.exit(0);
            }
            if (inputArgs.length == 3) {
                try {
                    System.out.println(switch (inputArgs[0]) {
                        case "Square" -> convertSquareInputType(inputArgs[1], Double.parseDouble(inputArgs[2]));
                        case "Circle" -> convertCircleInputType(inputArgs[1], Double.parseDouble(inputArgs[2]));
                        default -> "Unknown figure name";
                    });
                } catch (NumberFormatException e) {
                    System.out.println("Value must be a number.");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else if (inputArgs.length == 5) {
                try {
                    System.out.println(switch (inputArgs[0]) {
                        case "Rectangle" -> convertRectangleInputType(inputArgs[1], Double.parseDouble(inputArgs[2]), inputArgs[3], Double.parseDouble(inputArgs[4]));
                        case "Rhombus" -> convertRhombusInputType(inputArgs[1], Double.parseDouble(inputArgs[2]), inputArgs[3], Double.parseDouble(inputArgs[4]));
                        default -> "Unknown figure name";
                    });
                } catch (NumberFormatException e) {
                    System.out.println("Values must be numbers.");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else {
                System.out.println("Invalid number of arguments");
            }
        }
    }

    private static Circle convertCircleInputType(String type, double value) throws Exception {
        return switch (type) {
            case "area" -> Circle.withSurfaceArea(value);
            case "circuit" -> Circle.withCircuit(value);
            case "diameter" -> Circle.withDiameter(value);
            case "radius" -> Circle.withRadius(value);
            default -> throw new Exception("Unknown combination of arguments for circle");
        };
    }

    private static Square convertSquareInputType(String type, double value) throws Exception {
        return switch (type) {
            case "area" -> Square.withSurfaceArea(value);
            case "diagonal" -> Square.withDiagonalLength(value);
            case "side" -> Square.withSideLength(value);
            default -> throw new Exception("Unknown combination of arguments for square");
        };
    }

    private static Rectangle convertRectangleInputType(String type1, double value1, String type2, double value2) throws Exception {
        return switch (type1+"|"+type2) {
            case "short-side|long-side" -> Rectangle.withShortSideAndLongSide(value1, value2);
            case "short-side|diagonal" -> Rectangle.withShortSideAndDiagonal(value1, value2);
            case "short-side|area" -> Rectangle.withShortSideAndSurfaceArea(value1, value2);
            case "long-side|short-side" -> Rectangle.withShortSideAndLongSide(value2, value1);
            case "long-side|diagonal" -> Rectangle.withLongSideAndDiagonal(value1, value2);
            case "long-side|area" -> Rectangle.withLongSideAndSurfaceArea(value1, value2);
            case "diagonal|short-side" -> Rectangle.withShortSideAndDiagonal(value2, value1);
            case "diagonal|long-side" -> Rectangle.withLongSideAndDiagonal(value2, value1);
            case "diagonal|area" -> Rectangle.withDiagonalAndSurfaceArea(value1, value2);
            case "area|short-side" -> Rectangle.withShortSideAndSurfaceArea(value2, value1);
            case "area|long-side" -> Rectangle.withLongSideAndSurfaceArea(value2, value1);
            case "area|diagonal" -> Rectangle.withDiagonalAndSurfaceArea(value2, value1);
            default -> throw new Exception("Unknown combination of arguments for rectangle");
        };
    }

    private static Rhombus convertRhombusInputType(String type1, double value1, String type2, double value2) throws Exception {
        return switch (type1+"|"+type2) {
            case "short-diagonal|long-diagonal" -> Rhombus.withShortDiagonalAndLongDiagonal(value1, value2);
            case "short-diagonal|side" -> Rhombus.withShortDiagonalAndSide(value1, value2);
            case "short-diagonal|area" -> Rhombus.withShortDiagonalAndSurfaceArea(value1, value2);
            case "long-diagonal|short-diagonal" -> Rhombus.withShortDiagonalAndLongDiagonal(value2, value1);
            case "long-diagonal|side" -> Rhombus.withLongDiagonalAndSide(value1, value2);
            case "long-diagonal|area" -> Rhombus.withLongDiagonalAndSurfaceArea(value1, value2);
            case "side|short-diagonal" -> Rhombus.withShortDiagonalAndSide(value2, value1);
            case "side|long-diagonal" -> Rhombus.withLongDiagonalAndSide(value2, value1);
            case "side|area" -> Rhombus.withSideLengthAndSurfaceArea(value1, value2);
            case "area|short-diagonal" -> Rhombus.withShortDiagonalAndSurfaceArea(value2, value1);
            case "area|long-diagonal" -> Rhombus.withLongDiagonalAndSurfaceArea(value2, value1);
            case "area|side" -> Rhombus.withSideLengthAndSurfaceArea(value2, value1);
            default -> throw new Exception("Unknown combination of arguments for rhombus");
        };
    }
}
