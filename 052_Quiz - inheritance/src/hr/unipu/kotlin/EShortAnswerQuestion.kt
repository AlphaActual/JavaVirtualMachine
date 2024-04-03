package hr.unipu.kotlin

// Najava implementacije sučelja
// - proširena dostupnost na paketno-privatnu (-> obrisati private)
open class EShortAnswerQuestion(text: String,
                                internal var correctAnswer: String) : Question {
    override lateinit var text: String
        internal set


    init {
        this.text = text
    }

    override fun isCorrectAnswer(answer: String): Boolean {
        return correctAnswer.equals(answer, ignoreCase = true)
    }

}
