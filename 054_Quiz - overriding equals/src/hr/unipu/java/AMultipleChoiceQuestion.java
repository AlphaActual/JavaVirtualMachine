package hr.unipu.java;

// Nasljeđivanje – eliminacija ponavljanja
public class AMultipleChoiceQuestion extends AbstractQuestion {
    private String[] correctAnswers;    // atribut polje string

    // konstruktor
    public AMultipleChoiceQuestion(String text, String[] correctAnswers) {
        super(text);
        this.correctAnswers = correctAnswers;
    }

    // Ova metoda je zakomentirana jer je sada dio apstraktne klase
//    public String getText() {
//        return text;
//    }

    // konkrenta implementacija nasljeđene metode deklarirane kao apstraktna u apstraktnoj klasi
    public boolean isCorrectAnswer(String answer) {
        for (int i = 0; i < correctAnswers.length; i++) {
            if(correctAnswers[i].equalsIgnoreCase(answer))
                return true;    //ako nađe samo jedan true, vratit će true (=logičko ILI) i izaći će iz metode
        }
        return false;

    }

}
