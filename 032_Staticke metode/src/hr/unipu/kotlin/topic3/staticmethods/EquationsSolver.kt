package hr.unipu.kotlin.topic3.staticmethods

object EquationsSolver {
    private val epsilon = 1e-8
    /**
     * Solves system of two linear equations in two variables
     * ax + by = c and dx + ey = f
     * @param a ax + by = c and dx + ey = f
     * @param b ax + by = c and dx + ey = f
     * @param c ax + by = c and dx + ey = f
     * @param d ax + by = c and dx + ey = f
     * @param e ax + by = c and dx + ey = f
     * @param f ax + by = c and dx + ey = f
     * @return Point (x, y) that is solutin of the equation
     */
    fun Solve(a: Double, b: Double, c: Double, d: Double, e: Double, f: Double): Point {
        val x: Double
        val y: Double
        //using matrix method A      X =   B
        //                    [a b]      [ c ]
        //                    |   |  X = |   |
        //                    [d e]      [ f ]
        //solution is X = A^-1 * B
        //check if solution is possible
        val det = a * e - d * b
        if (Math.abs(det) > epsilon) { //avoiding det != 0
            x = 1 / det * (e * c - b * f)
            y = 1 / det * (-d * c + a * f)
        } else {
            //throw an exception? (latter....)
            System.err.println("Equations do not have a solution")
            x = 0.0
            y = 0.0
        }
        return Point(x, y)
    }
}
