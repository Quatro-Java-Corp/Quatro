package command;

import repository.ShapeRepository;

public class ShowFigures implements Command {
    private final ShapeRepository shapeRepository;

    public ShowFigures(ShapeRepository shapeRepository) {
        this.shapeRepository = shapeRepository;
    }

    @Override
    public void run() {
        shapeRepository.print();
    }
}
