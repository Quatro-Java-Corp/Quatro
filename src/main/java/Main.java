import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputHandler inputHandler = new InputHandler();
        FigureRepository figureList = new FigureRepository();
        while (true) {
            String input = scanner.nextLine();
            String[] inputArgs = input.split(" ");
            if (inputArgs.length == 1 && inputArgs[0].equals("exit")) {
                scanner.close();
                System.exit(0);
            }
            if (inputArgs.length == 1 && inputArgs[0].equals("ShowFigures")) {
                figureList.getFigures().forEach(System.out::println);
            } else
                try {
                    Figure figure = inputHandler.createFigureWithArguments(inputArgs);
                    figureList.addFigure(figure);
                    System.out.println(figure.toString());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
        }
    }
}