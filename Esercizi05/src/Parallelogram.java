package geometry.plainfigures;

public class Parallelogram extends Trapezium {
    protected double basis;
    protected double side;

    public Parallelogram(Point[] points) {
        super(points);
        if (isParallelogram(points)) {
            this.basis = points[0].distanceFrom(points[1]);
            this.side = points[1].distanceFrom(points[2]);
        }
    }

    public double getPerimeter() {
        return this.basis*2 + this.side*2;
    }

    public double getArea() {
        return super.getArea();
    }

    static boolean isParallelogram(Point[] points) {
        return points[0].coeffTo(points[1]) == points[2].coeffTo(points[3]) && points[1].coeffTo(points[2]) == points[3].coeffTo(points[0]);
    }
}