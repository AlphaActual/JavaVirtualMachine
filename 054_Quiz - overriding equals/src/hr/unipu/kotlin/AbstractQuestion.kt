package hr.unipu.kotlin

// apstraktna klasa koja služi za nasljeđivanje i ima implentirano ranije deklarirano sučelje Question
// - konstruktor, on će se u nasljeđenim klasama pozivati sa super(text)
// - implementacija metode, što će se kasnije nasljeđivati
// - atribut, koji će se kasnije nasljeđivati
abstract class AbstractQuestion(override val text: String) : Question {

    // apstraktna metoda, koja će imati konkretnu implementaciju tek u nasljeđenim klasama
    abstract override fun isCorrectAnswer(answer: String): Boolean

    // Overrding equals iz klase Object
    override fun equals(obj: Any?): Boolean {
        if (this === obj)
            return true
        if (obj == null)
            return false
        if (obj !is AbstractQuestion)
            return false

        val other = obj as AbstractQuestion?
        if (text == null) {
            if (other!!.text != null)
                return false
        } else if (text != other!!.text)
            return false
        return true
    }

    override fun hashCode(): Int {
        val prime = 31
        var result = 1
        result = prime * result + if (text == null) 0 else text!!.hashCode()
        return result
    }


}
