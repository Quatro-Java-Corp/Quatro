// package Model.Shapes;

// import javax.management.RuntimeErrorException;

// public final class Rectangle implements Polygon {
//     private final double width;
//     private final double height;
//     private final double diagonalLength;

//     public enum ConstructorArguments {
//         surfaceArea, diagonalLength, sideLength
//     }

//     @Override
//     public String toString() {
//         return "Rectangle{" +
//                 "width=" + width +
//                 ", height=" + height +
//                 ", diagonalLength=" + getDiagonalLength() +
//                 ", surfaceArea=" + getSurfaceArea() +
//                 '}';
//     }

//     @Override
//     public double getSurfaceArea() {
//         return width * height;
//     }

//     public double getWidth() {
//         return width;
//     }

//     public double getHeight() {
//         return width;
//     }

//     public double getDiagonalLength() {
//         return Math.sqrt(Math.pow(width, 2) + Math.pow(height, 2));
//     }

//     public Rectangle(double value1, double value2, ConstructorArguments which1, ConstructorArguments which2)
//             throws Exception {
//         if (value1 < 0 || value2 < 0)
//             throw new Exception("Value cannot be negative.");
//         // sideLength = switch (which) {
//         // case surfaceArea -> Math.pow(value, 0.5);
//         // case diagonalLength -> Math.pow(value * value / 2, 0.5);
//         // case sideLength -> value;
//         // };
//     }
// }
