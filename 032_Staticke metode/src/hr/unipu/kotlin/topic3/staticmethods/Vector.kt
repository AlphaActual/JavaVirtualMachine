package hr.unipu.kotlin.topic3.staticmethods

class Vector {

    private var p: Point? = null

    // Konstruktor za kopiranje
    constructor(p: Point) {
        this.p = Point(p)
    }

    // Konstruktor obični
    constructor(x: Double, y: Double) {
        this.p = Point(x, y)
    }

    override fun toString(): String {
        //(this.p.x, this.p.y) = a1 * (alpha1.x , alpha1.y) + a2 *  (alpha2.x , alpha2.y)
        // => alpha1.x * a1 + alpha2.x * a2 = this.p.x
        // => alpha1.y * a1 + alpha2.y * a2 = this.p.y
        //need to find a1 and a2 => coeff = (a1,a2)
        val coeff = EquationsSolver.Solve(alpha1.p!!.x, alpha2.p!!.x, p!!.x,
                alpha1.p!!.y, alpha2.p!!.y, p!!.y)
        return String.format("(%.2f, %.2f) = %.2f * (%.2f, %.2f) + %.2f * (%.2f, %.2f)",
                p!!.x, p!!.y,
                coeff.x, alpha1.p!!.x, alpha1.p!!.y,
                coeff.y, alpha2.p!!.x, alpha2.p!!.y
        )
    }

    companion object {
        val e1 = Vector(Point(1.0, 0.0))    //konstantna statička varijabla, (kanonska baza)
        val e2 = Vector(Point(0.0, 1.0))

        var alpha1: Vector
        var alpha2: Vector    //statička varijabla, (alternativna baza = lin.kombinacija kanonske baze)

        init {                //inicijalizacija statičkih varijabli
            alpha1 = e1
            alpha2 = e2
        }
    }


}
