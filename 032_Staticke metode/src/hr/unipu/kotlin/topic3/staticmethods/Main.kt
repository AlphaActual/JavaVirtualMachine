package hr.unipu.kotlin.topic3.staticmethods

fun main(args: Array<String>) {
    val a = Point(0.0, 0.0)
    val b = Point(6.0, 0.0)
    val c = Point(3.0, 5.0)
    var center = Point.centerOf(a, b, c) // poziv statičke metode
    println(center.toString())  //toString ovdje nije bio nužan, ali je dodan da se naglasi razlika između statičke i ne-statičke
    // > (3.0, 1.6666666666666667)


    // Koristiti polje kao argument nije uvijek praktično, jer ga prije poziva treba formirati.
    val points = arrayOf(a, b, c)
    center = Point.centerOf(points)
    println(center)
    // > (3.0, 1.6666666666666667)

    // Primjer poziva metode s varijabilnim brojem argumenata
    println(Point.centerOf(a, b))
    println(Point.centerOf(a, b, c))
    println(Point.centerOf(a, b, c, Point(4.0, 8.0)))
    // > (3.0, 0.0)
    // > (3.0, 1.6666666666666667)
    // > (3.25, 3.25)

    // 2D vektor pomoću klase Point
    val v = Vector(Point(3.0, 4.0))  //klasa Vector za 2D-vektor koji predstavlja vektor iz ishodišta do točke predane u konstruktoru
    println(v)
    // > (3,00, 4,00) = 3,00 * (1,00, 0,00) + 4,00 * (0,00, 1,00)

    // Promjena iz kanonske baze u neku novu bazu
    Vector.alpha1 = Vector(0.0, 1.0)
    Vector.alpha2 = Vector(-1.0, 2.0)
    println(v)
    // > (3,00, 4,00) = 10,00 * (0,00, 1,00) + -3,00 * (-1,00, 2,00)

}
