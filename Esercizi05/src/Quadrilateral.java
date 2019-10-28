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

        for (int i = 0; i < points.length; i++) {
            s1 += points[i].x * points[(i+1)%4].y;
            s2 += points[i].y * points[(i+1)%4].x;
        }

        return Math.abs((s1 - s2)/2);
    }

    public static double averageArea(Quadrilateral[] q) {
        double s;

        for (Quadrilateral q1 : q)
            s += q1.getArea();

        return s/q.length;
    }

    boolean isQuadrilateral() {
        if (this.points[2].coeffTo(this.points[3]) >= this.points[3].coeffTo(this.points[0]) && this.points[2].coeffTo(this.points[3]) <= this.points[1].coeffTo(this.points[2]));
            return false;

        return true;
    }
}