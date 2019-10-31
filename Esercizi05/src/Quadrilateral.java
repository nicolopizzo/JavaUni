package geometry.plainfigures;

public class Quadrilateral {
    protected Point[] points;

    public Quadrilateral(Point[] points) {
        if (isQuadrilateral(points))
            this.points = points;
        else
            this.points = new Point[4];
    }

    public double getPerimeter() {
        double sum = 0;
        
        for (int i = 0; i < points.length; i++)
            sum += points[i].distanceFrom(points[(i+1)%4]);

        return sum;
    }

    public double getArea() {
        double s1, s2;
        s1 = s2 = 0;

        for (int i = 0; i < points.length; i++) {
            s1 += points[i].x * points[(i+1)%4].y;
            s2 += points[i].y * points[(i+1)%4].x;
        }

        return Math.abs((s1 - s2)/2);
    }

    public static double averageArea(Quadrilateral[] q) {
        double s = 0;

        for (Quadrilateral q1 : q)
            s += q1.getArea();

        return s/q.length;
    }

    boolean isQuadrilateral(Point[] points) {
        return !(points[2].coeffTo(points[3]) >= points[3].coeffTo(points[0]) && points[2].coeffTo(points[3]) <= points[1].coeffTo(points[2]));
    }
}