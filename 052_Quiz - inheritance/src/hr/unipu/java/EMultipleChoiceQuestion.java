package hr.unipu.java;

// Nasljeđivanje – eliminacija ponavljanja
public class EMultipleChoiceQuestion extends EShortAnswerQuestion  {
    private String correctAnswer2;


    public EMultipleChoiceQuestion(String text, String correctAnswer1, String correctAnswer2) {
        super(text, correctAnswer1);
        //this.correctAnswer1 = correctAnswer1;
        this.correctAnswer2 = correctAnswer2;
    }

//    public String getText() {
//        return text;
//    }

    @Override
    public boolean isCorrectAnswer(String answer) {
        return correctAnswer.equalsIgnoreCase(answer) || correctAnswer2.equalsIgnoreCase(answer);
    }

}
