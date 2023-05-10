package command;

import repository.ShapeRepository;

public class Remove implements Command {
    private final ShapeRepository shapeRepository;
    private final int index;

    public Remove(int index, ShapeRepository shapeRepository) {
        this.index = index;
        this.shapeRepository = shapeRepository;
    }

    @Override
    public void run() {
        shapeRepository.remove(index);
    }
}
