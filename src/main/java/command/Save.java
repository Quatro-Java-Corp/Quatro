package command;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import repository.ShapeRepository;

import java.io.FileWriter;
import java.io.IOException;

public class Save implements Command {
    private final ShapeRepository shapeRepository;
    private final String filename;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public Save(String filename, ShapeRepository shapeRepository) {
        this.shapeRepository = shapeRepository;
        this.filename = filename;
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.NONE);
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
    }

    private Runnable saveToFile(String filename) {
        return () -> {
            try (FileWriter writer = new FileWriter(filename + ".json")) {
                objectMapper.writeValue(writer, shapeRepository);
                System.out.println("Shapes saved in " + filename + ".json");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        };
    }

    @Override
    public void run() {
        try {
            new Thread(saveToFile(filename)).start();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
