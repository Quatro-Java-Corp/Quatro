import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            String[] inputArgs = input.split(" ");
            if (inputArgs.length == 1 && inputArgs[0].equals("exit")) {
                System.exit(0);
            }
            if (inputArgs.length == 3) {
                try {
                    System.out.println(switch (inputArgs[0]) {
                        case "Square" ->
                                new Square(Double.parseDouble(inputArgs[2]), convertSquareInputType(inputArgs[1])).toString();
                        case "Circle" ->
                                new Circle(Double.parseDouble(inputArgs[2]), convertCircleInputType(inputArgs[1])).toString();
                        default -> "Unknown figure name";
                    });
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else {
                System.out.println("Invalid number of arguments");
            }
        }
    }

    private static Circle.ConstructorType convertCircleInputType(String type) throws Exception {
        return switch (type) {
            case "area" -> Circle.ConstructorType.surfaceArea;
            case "circuit" -> Circle.ConstructorType.circuit;
            case "diameter" -> Circle.ConstructorType.diameter;
            case "radius" -> Circle.ConstructorType.radius;
            default -> throw new Exception("Unknown type");
        };
    }

    private static Square.ConstructorType convertSquareInputType(String type) throws Exception {
        return switch (type) {
            case "area" -> Square.ConstructorType.surfaceArea;
            case "diagonal" -> Square.ConstructorType.diagonalLength;
            case "side" -> Square.ConstructorType.sideLength;
            default -> throw new Exception("Unknown type");
        };
    }
}

