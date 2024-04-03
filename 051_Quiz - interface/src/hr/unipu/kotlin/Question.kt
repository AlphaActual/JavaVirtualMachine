package hr.unipu.kotlin

// Question  je sučelje
interface Question {
    val text: String
    fun isCorrectAnswer(answer: String): Boolean
}
