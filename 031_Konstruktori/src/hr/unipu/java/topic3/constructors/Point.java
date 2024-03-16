package hr.unipu.java.topic3.constructors;

public class Point {
    private double x, y;

    public double getX() {
        return x;
    }
    public void setX(double x) {
        this.x = x;
    }
    public double getY() {
        return y;
    }
    public void setY(double y) {
        this.y = y;
    }

    // No-argument constructor
    public Point() {
        this.x = 0;
        this.y = 0;
    }

    // Constructor
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
        //x = newX;
        //y = newY;
    }

    // Copy constructor
    public Point(Point p) {
        this(p.x, p.y); //poziv drugog konstruktora

        // identičan, ali duži kod:
        //x = p.x;
        //y = p.y;
        // ili još duže:
        //this.x = p.x;
        //this.y = p.y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
