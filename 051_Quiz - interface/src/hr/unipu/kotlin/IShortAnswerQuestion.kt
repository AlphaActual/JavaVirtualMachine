package hr.unipu.kotlin

// Najava implementacije sučelja
class IShortAnswerQuestion(override val text: String, private val correctAnswer: String) : Question {

    override fun isCorrectAnswer(answer: String): Boolean {
        return correctAnswer.equals(answer, ignoreCase = true)
    }

}
