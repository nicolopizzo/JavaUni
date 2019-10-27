package geometry.plainfigures;

public class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distanceFrom(Point p) {
        return Math.sqrt((Math.pow(this.x-p.x, 2)) + (Math.pow(this.y-p.y)));
    }

    public double coeffTo(Point p) {
        return (this.y - p.y)/(this.x - p.x);
    }
    
}