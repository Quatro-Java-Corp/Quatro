package command;

import repository.ShapeRepository;
import shapes.Shape;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Optional;

public class Save implements Command {
    private final ShapeRepository shapeRepository;

    public Save(ShapeRepository shapeRepository) {
        this.shapeRepository = shapeRepository;
    }

    private Runnable saveToFile(String filename) {
        return () -> {
            try (FileWriter writer = new FileWriter(filename + ".txt", true)) {
                int i = 1;
                Optional<Shape> optionalShape = shapeRepository.get(0);
                while (optionalShape.isPresent()) {
                    writer.write(optionalShape.get() + "\n");
                    optionalShape = shapeRepository.get(i);
                    i += 1;
                }
                System.out.println("Shapes saved in " + filename + ".txt");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        };
    }

    @Override
    public void run() {
        try {
            new Thread(saveToFile("shapes")).start();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
