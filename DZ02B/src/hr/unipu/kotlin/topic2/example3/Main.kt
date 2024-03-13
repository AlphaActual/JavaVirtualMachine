package hr.unipu.kotlin.topic2.example3

fun main(args: Array<String>) {
    val s = Student()
    s.init()
    s.name = "Ivo"
    s.surname = "Ivić"
    s.id = "1234567890"
    s.addGrade(105, "OOP", 5)
    s.addGrade(20, "ASP", 3)
    s.addGrade(77, "PiPI", 2)

    // .toString (tekstualni ispis objekta)
    println(s)
    println(s.toString())

    // .equals (uspoređuje da li su dvije varijable reference na isti objekt)
    val s2 = Student()
    s2.name = "Ante"
    s2.id = "1234567890"
    println(s == s2)
}
