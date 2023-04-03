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
            default -> throw new Exception("Unknown type");
        };
    }

    private static Square convertSquareInputType(String type, double value) throws Exception {
        return switch (type) {
            case "area" -> Square.withSurfaceArea(value);
            case "diagonal" -> Square.withDiagonalLength(value);
            case "side" -> Square.withSideLength(value);
            default -> throw new Exception("Unknown type");
        };
    }
}
