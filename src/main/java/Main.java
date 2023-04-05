import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputHandler inputHandler = new InputHandler();
        while (true) {
            String input = scanner.nextLine();
            String[] inputArgs = input.split(" ");
            if (inputArgs.length == 1 && inputArgs[0].equals("exit")) {
                scanner.close();
                System.exit(0);
            }
            try {
                System.out.println(inputHandler.createFigureWithArguments(inputArgs).toString());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}