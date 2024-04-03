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

    // Overrding equals iz Object klase
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (!(obj instanceof AShortAnswerQuestion))
            return false;

        AShortAnswerQuestion other = (AShortAnswerQuestion) obj;
        if (correctAnswer == null) {
            if (other.correctAnswer != null)
                return false;
        } else if (!correctAnswer.equals(other.correctAnswer))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result +
                ((correctAnswer == null) ? 0 : correctAnswer.hashCode());
        result = prime * result + super.hashCode();
        return result;
    }



}
