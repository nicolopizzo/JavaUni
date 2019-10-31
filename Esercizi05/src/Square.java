package geometry.plainfigures;

public class Square extends Rectangle {
    private double side;

    public Square(Point[] points) {
        super(points);
        if(isSquare(points))
            this.side = super.basis;
    }

    public double getPerimeter() {
        return this.side*4;
    }

    public double getArea() {
        return this.side*this.side;
    }

    private boolean isSquare(Point[] points) {
        return points[0].distanceFrom(points[1]) == points[1].distanceFrom(points[2]);
    }
}