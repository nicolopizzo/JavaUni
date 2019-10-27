package geometry.plainfigures;

public class Rectangle extends Parallelogram {
    public Rectangle(Point[] points) {
        super(points);
    }

    public getPerimeter() {
        return super.perimeter();
    }

    public getArea() {
        return this.basis*this.side;
    }
}