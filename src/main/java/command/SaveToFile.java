package command;

import repository.ShapeRepository;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class SaveToFile implements Command {
    private final ShapeRepository shapeRepository;
    private Object lock = new Object();
    public SaveToFile(ShapeRepository shapeRepository) {
        this.shapeRepository = shapeRepository;
    }
    private PrintWriter writer;
    private Runnable saveOneLine(int i) {
        return () -> {
            synchronized (lock) {
                try (FileWriter writer = new FileWriter("shapes.txt", true)) {
                    writer.write(shapeRepository.get(i).get().toString()+ "\n");
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }

        };
    }

    @Override
    public void run()  {
        try {
            int i = 0;
            while (i < shapeRepository.length()) {
                new Thread(saveOneLine(i)).start();
                i += 1;
            }
            System.out.println("Shapes saved in Shape.txt");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }


    }
}
