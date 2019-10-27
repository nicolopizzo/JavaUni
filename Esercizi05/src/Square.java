package geometry.plainfigures;

public class Square extends Rectangle {
    private double side;

    public Square(Point[] points) {
        super(points);
        this.side = super.basis;
    }

    public double getPerimeter() {
        return this.side*4;
    }

    public double getArea() {
        return this.side*this.side;
    }
}