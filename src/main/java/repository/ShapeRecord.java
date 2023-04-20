package repository;

import shapes.Shape;

import java.util.Date;

class ShapeRecord {
    private final Shape shape;
    private final Date creationDate;

    public ShapeRecord(Shape shape) {
        this.shape = shape;
        creationDate = new Date();
    }

    public Shape getShape() {
        return shape;
    }

    public Date getCreationDate() {
        return creationDate;
    }
}
