import java.util.Scanner;
import input.InputHandler;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputHandler inputHandler = new InputHandler();
        while (true) {
            inputHandler.parseInput(scanner.nextLine());
        }
    }
}