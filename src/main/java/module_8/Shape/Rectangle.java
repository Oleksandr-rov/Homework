package module_8.Shape;

public class Rectangle extends Shape {
    boolean isSquare;
    @Override
    public void draw() {
        System.out.println("Shape is rectangle");
    }

    public static class Rhombus extends Shape{
        @Override
        public void draw() {
            System.out.println("Shape is rhombus");
        }
    }
}
