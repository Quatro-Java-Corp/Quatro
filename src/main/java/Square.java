public final class Square implements Figure{
    private double sideLength;
    private double diagonalLength;
    private double surfaceArea;

    public enum ConstructorType {
        surfaceArea,
        diagonalLength,
        sideLength;
    }



    @Override
    public String toString() {
        return "Square{" +
                "sideLength=" + sideLength +
                ", diagonalLength=" + diagonalLength +
                ", surfaceArea=" + surfaceArea +
                '}';
    }

    @Override
    public double getSurfaceArea() {
        return surfaceArea;
    }

    public double getSideLength() {
        return sideLength;
    }

    public double getDiagonalLength() {
        return diagonalLength;
    }

    public Square(double value, ConstructorType which) throws Exception {

        if(value < 0) throw new Exception("Value cannot be negative.");
        switch(which) {
            case surfaceArea:
                this.surfaceArea = value;
                this.sideLength = Math.pow(surfaceArea,0.5);
                this.diagonalLength = sideLength * Math.pow(2.0,0.5);
                break;
            case diagonalLength:
                this.diagonalLength = value;
                this.surfaceArea = diagonalLength * diagonalLength / 2;
                this.sideLength = Math.pow(surfaceArea,0.5);
                break;
            case sideLength:
                this.sideLength = value;
                this.diagonalLength = sideLength * Math.pow(2,0.5);
                this.surfaceArea =  sideLength * sideLength;

        }


    }
}
