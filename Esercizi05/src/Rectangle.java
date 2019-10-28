package geometry.plainfigures;

public class Rectangle extends Parallelogram {
    public Rectangle(Point[] points) {
        super(points);
    }

    public double getPerimeter() {
        return super.getPerimeter();
    }

    public double getArea() {
        return this.basis*this.side;
    }

    public static int rectanglesOverAvg(Quadrilateral[] q) {
        int n;
        double avgArea = averageArea(q);

        for (Quadrilateral q1 : q)
            if (q1 instanceof Rectangle && !(q1 instanceof Square) && q1.getArea() > avgArea)
                n++;

        return n;
    }
}