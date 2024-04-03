package hr.unipu.kotlin

// Nasljeđivanje – eliminacija ponavljanja
class AMultipleChoiceQuestion// konstruktor
(text: String, private val correctAnswers: Array<String>    // atribut polje string
) : AbstractQuestion(text) {

    // Ova metoda je zakomentirana jer je sada dio apstraktne klase
    //    public String getText() {
    //        return text;
    //    }

    // konkrenta implementacija nasljeđene metode deklarirane kao apstraktna u apstraktnoj klasi
    override fun isCorrectAnswer(answer: String): Boolean {
        for (i in correctAnswers.indices) {
            if (correctAnswers[i].equals(answer, ignoreCase = true))
                return true    //ako nađe samo jedan true, vratit će true (=logičko ILI) i izaći će iz metode
        }
        return false

    }

}
