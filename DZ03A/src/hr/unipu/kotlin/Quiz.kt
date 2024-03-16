package hr.unipu.kotlin

/**
 * Izgradnja sustava objekata: kompozicija i agregacija
 */

class Quiz {
    var name: String? = null
        private set    //ime kviza
    private val questions = arrayOfNulls<ShortAnswerQuestion>(10)  //polje pitanja
    var noOfQuestions = 0
        private set //inicijalno je kviz prazan (bez pitanja)

    // Konstruktor 1
    constructor() {
        name = "Initial Quiz"
    }

    // Konstruktor 2 (overloading = preopterećivanje)
    constructor(name: String) {
        this.name = name
    }

    // kompozicija klase Quiz
    fun addQuestion(text: String, answer: String) {
        questions[noOfQuestions] = ShortAnswerQuestion(text, answer)
        noOfQuestions++

        //TODO maksimalan broj pitanja
    }

    // agregacija klase Quiz
    fun addQuestion(question: ShortAnswerQuestion) {
        questions[noOfQuestions] = question
        noOfQuestions++

        //TODO maksimalan broj pitanja
    }

    fun getQuestion(index: Int): String? {
        return questions[index]?.text
    }

    fun isCorrectAnswer(questionIndex: Int, answer: String): Boolean? {
        return questions[questionIndex]?.isCorrectAnswer(answer)
    }

}
