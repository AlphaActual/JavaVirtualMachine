package hr.unipu.kotlin.topic3.constructors

fun main(args: Array<String>) {

    val p = Point()          // Instantation with No-argument constructor

    val p1 = Point(2.0, 5.0)    // Instantation with constructor
    val p2 = Point(p1)            // Copy constructor (deep copy)

    //Point p2;
    //p2 = p1;

    Math.cos(Math.PI)

    p1.x = 1.0
    p1.y = 2.0

    println(p1)
    println(p2)
    // >   (1.0, 2.0)
    // >   (2.0, 5.0)
}