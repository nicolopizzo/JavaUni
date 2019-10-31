package geometry.plainfigures;

public class Rectangle extends Parallelogram {
    protected double basis;
    protected double height;

    public Rectangle(Point[] points) {
        super(points);
        if (isRectangle(points)) {
            this.basis = super.basis;
            this.height = super.side;
        }
    }

    public double getPerimeter() {
        return this.basis*2 + this.height*2;
    }

    public double getArea() {
        return this.basis*this.height;
    }

    public static int rectanglesOverAvg(Quadrilateral[] q) {
        int n = 0;
        double avgArea = averageArea(q);

        for (Quadrilateral q1 : q)
            if (q1 instanceof Rectangle && !(q1 instanceof Square) && q1.getArea() > avgArea)
                n++;

        return n;
    }

    static boolean isRectangle(Point[] points) {
        return (points[0].coeffTo(points[1]) == (-1 / (points[1].coeffTo(points[2]))));
    }
}