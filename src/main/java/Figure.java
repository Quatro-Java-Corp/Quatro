public class Figure {
    protected double surfaceArea;

    public Figure(double surfaceArea) throws Exception {
        if(surfaceArea < 0) throw new Exception("Value cannot be negative.");
        this.surfaceArea = surfaceArea;
    }

    public Figure() {
        this.surfaceArea = 0;
    }
    @Override
    public String toString() {
        return "Figure{" +
                "surfaceArea=" + surfaceArea +
                '}';
    }
}
