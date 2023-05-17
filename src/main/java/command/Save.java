package command;

import repository.ShapeRepository;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class Save implements Command {
    private final ShapeRepository shapeRepository;
    private Object lock = new Object();
    public Save(ShapeRepository shapeRepository) {
        this.shapeRepository = shapeRepository;
    }
    private PrintWriter writer;
    private Runnable saveToFile(String filename) {
        return () -> {

                try (FileWriter writer = new FileWriter( filename + ".txt", true)) {
                    int i = 0;
                    while (i < shapeRepository.length()) {
                        writer.write(shapeRepository.get(i).get().toString()+ "\n");
                        i += 1;
                    }
                    System.out.println("Shapes saved in Shape.txt");
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }

        };
    }

    @Override
    public void run()  {
        try {
                new Thread(saveToFile("shapes")).start();

        } catch (Exception e){
            System.out.println(e.getMessage());
        }


    }
}
