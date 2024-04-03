package hr.unipu.kotlin

// Nasljeđivanje – eliminacija ponavljanja
// -  //this.correctAnswer1 = correctAnswer1;
class EMultipleChoiceQuestion(text: String,
                              correctAnswer1: String,
                              private val correctAnswer2: String)
    : EShortAnswerQuestion(text, correctAnswer1) {

    //    public String getText() {
    //        return text;
    //    }

    override fun isCorrectAnswer(answer: String): Boolean {
        return correctAnswer.equals(answer, ignoreCase = true) || correctAnswer2.equals(answer, ignoreCase = true)
    }

}
