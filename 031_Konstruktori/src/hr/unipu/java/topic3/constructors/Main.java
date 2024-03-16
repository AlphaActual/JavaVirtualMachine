package hr.unipu.java.topic3.constructors;

public class Main {

    public static void main(String[] args) {

        Point p = new Point();          // Instantation with No-argument constructor

        Point p1 = new Point(2, 5);    // Instantation with constructor
        Point p2 = new Point(p1);            // Copy constructor (deep copy)

        //Point p2;
        //p2 = p1;

        Math.cos(Math.PI);

        p1.setX(1);
        p1.setY(2);
        System.out.println(p1);
        System.out.println(p2);
    }
}
