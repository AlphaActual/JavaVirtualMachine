package hr.unipu.kotlin

// sučelje kojim se deklariraju metode koje će kasnije biti implementirane
interface Question {
    val text: String
    fun isCorrectAnswer(answer: String): Boolean
}

