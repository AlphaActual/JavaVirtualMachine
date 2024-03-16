package hr.unipu.java.topic3.staticmethods;

public class Main {

    public static void main(String[] args) {
        Point a = new Point(0,0);
        Point b = new Point(6,0);
        Point c = new Point(3,5);
        Point center = Point.centerOf(a, b, c); // poziv statičke metode
        System.out.println(center.toString());  //toString ovdje nije bio nužan, ali je dodan da se naglasi razlika između statičke i ne-statičke

        // Koristiti polje kao argument nije uvijek praktično, jer ga prije poziva treba formirati.
        Point[] points = new Point[] {a, b, c};
        center = Point.centerOf(points);
        System.out.println(center);

        // Primjer poziva metode s varijabilnim brojem argumenata
        System.out.println(Point.centerOf(a, b));
        System.out.println(Point.centerOf(a, b, c));
        System.out.println(Point.centerOf(a, b, c, new Point(4,8)));

        // 2D vektor pomoću klase Point
        Vector v = new Vector(new Point(3,4));  //klasa Vector za 2D-vektor koji predstavlja vektor iz ishodišta do točke predane u konstruktoru
        System.out.println(v);
        // Promjena iz kanonske baze u neku novu bazu
        Vector.alpha1 = new Vector(0,1);
        Vector.alpha2 = new Vector(-1,2);
        System.out.println(v);
    }
}
