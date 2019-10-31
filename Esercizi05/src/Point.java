package geometry.plainfigures;

public class Point {
    double x;
    double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distanceFrom(Point p) {
        return Math.sqrt(Math.pow(this.x-p.x, 2) + Math.pow(this.y-p.y, 2));
    }

    public double coeffTo(Point p) {
        return Double.isInfinite((this.y - p.y)/(this.x - p.x)) ? Double.POSITIVE_INFINITY : (this.y - p.y)/(this.x - p.x);
    }

    public boolean alignedTo(Point p) {
        return this.y == p.y || this.x == p.x;
    }
    
}