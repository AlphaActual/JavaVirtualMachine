package hr.unipu.kotlin

// Najava implementacije sučelja
class IMultipleChoiceQuestion(override val text: String, private val correctAnswer1: String, private val correctAnswer2: String) : Question {
    override fun isCorrectAnswer(answer: String): Boolean {
        return correctAnswer1.equals(answer, ignoreCase = true) || correctAnswer2.equals(answer, ignoreCase = true)
    }

}
