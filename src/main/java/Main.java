import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputHandler inputHandler = new InputHandler();
        ArrayList<Figure> figueList = new ArrayList<Figure>();
        while (true) {
            String input = scanner.nextLine();
            String[] inputArgs = input.split(" ");
            if (inputArgs.length == 1 && inputArgs[0].equals("exit")) {
                scanner.close();
                System.exit(0);
            }
            if (inputArgs.length == 1 && inputArgs[0].equals("ShowFigures")) {
                for (Figure f: figueList) {
                    System.out.println(f.toString());
                }
            } else
            try {
                Figure figure = inputHandler.createFigureWithArguments(inputArgs);
                figueList.add(figure);
                Collections.sort(figueList, (Figure a, Figure b) -> a.getSurfaceArea() < b.getSurfaceArea() ? -1 : 1);
                System.out.println(figure.toString());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}