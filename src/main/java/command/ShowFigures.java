package command;

import repository.ShapeRepository;

public class ShowFigures implements Command {
    private final ShapeRepository shapeRepo;

    public ShowFigures(ShapeRepository shapeRepo) {
        this.shapeRepo = shapeRepo;
    }

    @Override
    public void run() {
        shapeRepo.print();
    }
}
