import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputHandler inputHandler = new InputHandler();
        ArrayList<Figure> figureList = new ArrayList<Figure>();
        while (true) {
            String input = scanner.nextLine();
            String[] inputArgs = input.split(" ");
            if (inputArgs.length == 1 && inputArgs[0].equals("exit")) {
                scanner.close();
                System.exit(0);
            }
            if (inputArgs.length == 1 && inputArgs[0].equals("ShowFigures")) {
                figureList.sort( (Figure a, Figure b) -> a.getSurfaceArea() < b.getSurfaceArea() ? -1 : 1);
                figureList.forEach(System.out::println);
            } else
            try {
                Figure figure = inputHandler.createFigureWithArguments(inputArgs);
                figureList.add(figure);
                System.out.println(figure.toString());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}