package hr.unipu.java;

// Nasljeđivanje – eliminacija ponavljanja
public class AShortAnswerQuestion extends AbstractQuestion  {
    private String correctAnswer;   // atibut string

    // konstruktor
    public AShortAnswerQuestion(String text, String correctAnswer) {
        super(text);
        this.correctAnswer = correctAnswer;
    }

    // Ova metoda je zakomentirana jer je sada dio apstraktne klase
//    public String getText() {
//        return text;
//    }

    // konkrenta implementacija nasljeđene metode deklarirane kao apstraktna u apstraktnoj klasi
    public boolean isCorrectAnswer(String answer) {
        return correctAnswer.equalsIgnoreCase(answer);
    }

}
