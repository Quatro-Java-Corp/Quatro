import java.util.Scanner;
import input.InputHandler;
import repository.ShapeRepository;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShapeRepository shapeRepository = new ShapeRepository();
        InputHandler inputHandler = new InputHandler(shapeRepository);
        while (true) {
            inputHandler.parseInput(scanner.nextLine());
        }
    }
}