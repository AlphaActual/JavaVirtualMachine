package hr.unipu.kotlin.topic3.staticmethods

class Point(var x: Double, var y: Double) {
    constructor(p: Point) : this(p.x, p.y) {}

    override fun toString(): String {
        return "($x, $y)"
    }

    // Companion object = static methods in Java
    companion object {

        // Težište triju točaka
        fun centerOf(a: Point, b: Point, c: Point): Point {
            val x = (a.x + b.x + c.x) / 3.0
            val y = (a.y + b.y + c.y) / 3.0
            return Point(x, y)
        }

        // Težište više točaka – rješenje s varijabilnim brojem argumenata
        fun centerOf(a: Point, b: Point, vararg points: Point): Point {
            var x = a.x + b.x
            var y = a.y + b.y
            for (p in points) {
                x += p.x
                y += p.y
            }
            val len = points.size + 2    //points.length and also a and b
            return Point(x / len, y / len)
        }

        // Težište više točaka – rješenje s korištenjem polja
        fun centerOf(points: Array<Point>): Point {
            var x = 0.0
            var y = 0.0
            val len = points.size
            //		for(int i=0; i<len; i++){
            //			x += points[i].getX();
            //			y += points[i].getY();
            //		}
            for (p in points) {        //FOREACH oblik FOR petlje
                x += p.x
                y += p.y
            }

            return Point(x / len, y / len)
        }
    }
}
