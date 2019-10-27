package geometry.plainfigures;

public class Quadrilateral {
    protected Point[] vertices;

    public Quadrilateral(Point[] vertices) {
        if (isQuadrilateral(vertices))
            this.vertices = vertices;
        else
            this.vertices = new int[4];
    }

    public double getPerimeter() {
        sum = 0;
        
        for (int i = 0; i < p.length; i++)
            sum += p[i].distanceFrom(p[(i+1)%4]);

        return sum;
    }

    public double getArea() {

    }

    private static boolean isQuadrilateral(Point[] vertices) {
        
    }
}