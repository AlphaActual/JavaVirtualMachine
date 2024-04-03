package hr.unipu.kotlin

// apstraktna klasa koja služi za nasljeđivanje i ima implentirano ranije deklarirano sučelje Question
abstract class AbstractQuestion// konstruktor, on će se u nasljeđenim klasama pozivati sa super(text)
(// implementacija metode, što će se kasnije nasljeđivati
        override val text: String    // atribut, koji će se kasnije nasljeđivati
) : Question {

    // apstraktna metoda, koja će imati konkretnu implementaciju tek u nasljeđenim klasama
    abstract override fun isCorrectAnswer(answer: String): Boolean

}
