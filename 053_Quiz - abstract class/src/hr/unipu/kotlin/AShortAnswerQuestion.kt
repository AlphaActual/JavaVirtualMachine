package hr.unipu.kotlin

// Nasljeđivanje – eliminacija ponavljanja
class AShortAnswerQuestion// konstruktor
(text: String, private val correctAnswer: String   // atibut string
) : AbstractQuestion(text) {

    // Ova metoda je zakomentirana jer je sada dio apstraktne klase
    //    public String getText() {
    //        return text;
    //    }

    // konkrenta implementacija nasljeđene metode deklarirane kao apstraktna u apstraktnoj klasi
    override fun isCorrectAnswer(answer: String): Boolean {
        return correctAnswer.equals(answer, ignoreCase = true)
    }

}
