package geometry.plainfigures;

public class Parallelogram extends Quadrilateral {
    protected double basis;
    protected double side;

    public Parallelogram(Point[] points) {
        super(points);
        // if (isQuadrilateral(points)) {
        //     this.basis = points[0].distanceFrom(points[1]);
        //     this.side = points[1].distanceFrom(points[2]);
        // }
    }

    public double getPerimeter() {
        return this.basis*2 + this.side*2;
    }

    public double getArea() {
        return super.getArea();
    }
}