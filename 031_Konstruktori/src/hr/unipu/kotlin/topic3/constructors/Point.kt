package hr.unipu.kotlin.topic3.constructors

class Point {
    var x: Double = 0.0
    var y: Double = 0.0

    // No-argument constructor
    constructor() {
        this.x = 0.0
        this.y = 0.0
    }

    // Constructor
    constructor(x: Double, y: Double) {
        this.x = x
        this.y = y
        //x = newX;
        //y = newY;
    }

    // Copy constructor
    constructor(p: Point) : this(p.x, p.y) {    // poziv drugog konstruktora

        // identičan, ali duži kod:
        //x = p.x;
        //y = p.y;
        // ili još duže:
        //this.x = p.x;
        //this.y = p.y;
    }

    override fun toString(): String {
        return "($x, $y)"
    }
}
