package repository;

import com.fasterxml.jackson.annotation.JsonIgnore;
import shapes.Shape;

import java.util.Date;

class ShapeRecord {
    private final Shape shape;
    @JsonIgnore
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
