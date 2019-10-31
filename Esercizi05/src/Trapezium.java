package geometry.plainfigures;

public class Trapezium extends Quadrilateral {
    private double minorBase;
    private double majorBase;
    private double side1;
    private double side2;

    public Trapezium(Point[] points) {
        super(points);
        if (isTrapezium(points)) {
            if (points[0].coeffTo(points[1]) == points[2].coeffTo(points[3])) {
                this.minorBase = Math.min(points[0].distanceFrom(points[1]), points[2].distanceFrom(points[3]));
                this.majorBase = Math.max(points[0].distanceFrom(points[1]), points[2].distanceFrom(points[3]));
                this.side1 = points[1].distanceFrom(points[2]);
                this.side2 = points[3].distanceFrom(points[0]);
            }

            else {
                this.minorBase = Math.min(points[1].distanceFrom(points[2]), points[3].distanceFrom(points[0]));
                this.majorBase = Math.max(points[1].distanceFrom(points[2]), points[3].distanceFrom(points[0]));
                this.side1 = points[0].distanceFrom(points[1]);
                this.side2 = points[2].distanceFrom(points[3]);
            }
        }
    }

    public double getPerimeter() {
        return this.side1 + this.side2 + this.minorBase + this.majorBase;
    }

    static boolean isTrapezium(Point[] points) {
        return points[0].coeffTo(points[1]) == points[2].coeffTo(points[3]) || points[1].coeffTo(points[2]) == points[3].coeffTo(points[0]);
    }

}