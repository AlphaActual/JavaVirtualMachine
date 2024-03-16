package hr.unipu.kotlin

/**
 * This is the Question which accepts only short answer. Short
 * answer is one word.
 *
 * @author Ime Prezime
 * @version 1.0
 */

class ShortAnswerQuestion// Konstruktor objekta
(
        // Atributi
        /**
         * Text of question.
         */
        // Metode
        val text: String,
        /**
         * Correct answer of the question.
         */
        private val correctAnswer: String) {

    fun isCorrectAnswer(answer: String): Boolean {
        return correctAnswer.equals(answer, ignoreCase = true)
    }

}
