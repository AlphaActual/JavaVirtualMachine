package hr.unipu.java;

// Najava implementacije sučelja
public class EShortAnswerQuestion implements Question  {
    String text;
    String correctAnswer;   // proširena dostupnost na paketno-privatnu (-> obrisati private)


    public EShortAnswerQuestion(String text, String correctAnswer) {
        this.text = text;
        this.correctAnswer = correctAnswer;
    }

    public String getText() {
        return text;
    }

    public boolean isCorrectAnswer(String answer) {
        return correctAnswer.equalsIgnoreCase(answer);
    }

}
