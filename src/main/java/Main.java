import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputHandler inputHandler = new InputHandler();
        while (true) {
            try{
            inputHandler.parseInput(scanner.nextLine());
            } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        }
    }
}