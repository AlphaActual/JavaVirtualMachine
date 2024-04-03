package hr.unipu.kotlin

// Nasljeđivanje – eliminacija ponavljanja
class AShortAnswerQuestion// konstruktor
(text: String, private val correctAnswer: String?   // atibut string
) : AbstractQuestion(text) {

    // Ova metoda je zakomentirana jer je sada dio apstraktne klase
    //    public String getText() {
    //        return text;
    //    }

    // konkrenta implementacija nasljeđene metode deklarirane kao apstraktna u apstraktnoj klasi
    override fun isCorrectAnswer(answer: String): Boolean {
        return correctAnswer!!.equals(answer, ignoreCase = true)
    }

    // Overrding equals iz Object klase
    override fun equals(obj: Any?): Boolean {
        if (this === obj)
            return true
        if (!super.equals(obj))
            return false
        if (obj !is AShortAnswerQuestion)
            return false

        val other = obj as AShortAnswerQuestion?
        if (correctAnswer == null) {
            if (other!!.correctAnswer != null)
                return false
        } else if (correctAnswer != other!!.correctAnswer)
            return false
        return true
    }

    override fun hashCode(): Int {
        val prime = 31
        var result = 1
        result = prime * result + (correctAnswer?.hashCode() ?: 0)
        result = prime * result + super.hashCode()
        return result
    }


}
