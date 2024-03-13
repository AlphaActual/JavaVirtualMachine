package hr.unipu.kotlin.topic2.example3

class Student {
    internal val ARR_SIZE = 60
    var id: String? = null
    var name: String? = null
    var surname: String? = null
    private var noOfGrades: Int = 0
    private var grades: Array<CourseGrade?>? = null /* primijetiti razliku u deklaraciji polja u odnosu na C.
							                        Ovo je slično tome da je varijabla ocjene pokazivač na dinamički
							                        alocirano polje pokazivača */

    fun init() { /* nakon 3. predavanja ovakve vlasite inicijalizacijske
				    metode ćemo zamijeniti konstruktorima */
        grades = arrayOfNulls(ARR_SIZE)
        noOfGrades = 0
    }

    fun addGrade(code: Int, title: String, grade: Int) {
        if (grade >= 2 && grade <= 5) {
            val courseGrade = CourseGrade()
            courseGrade.code = code
            courseGrade.title = title
            courseGrade.grade = grade
            grades?.set(noOfGrades++, courseGrade)
        }
    }

    fun averageGrade(): Double {
        var sum = 0
        for (i in 0 until noOfGrades)
            sum += grades?.get(i)?.grade ?: 0
        return if (noOfGrades > 0) sum.toDouble() / noOfGrades else 0.0
    }

    override fun toString(): String {
        return String.format("%s - %s, %s - Average grade = %.2f", id, surname, name, averageGrade())
    }

    override fun equals(obj: Any?): Boolean {
        //pretpostavit ćemo da je primljeni objekt uistinu Student
        val otherStudent = obj as Student?
        return id == otherStudent?.id
    }
}
