package hr.unipu.java;

/**
 * This is the Question which accepts only short answer. Short
 * answer is one word.
 *
 * @author Mario Kušek
 *
 */

public class ShortAnswerQuestion {
    // Atributi
    /**
     * Text of question.
     */
    private String text;
    /**
     * Correct answer of the question.
     */
    private String correctAnswer;


    // Konstruktor objekta
    public ShortAnswerQuestion(String text, String correctAnswer) {
        this.text = text;
        this.correctAnswer = correctAnswer;
    }

    // Metode
    public String getText() {
        return text;
    }

    public boolean isCorrectAnswer(String answer) {
        return correctAnswer.equalsIgnoreCase(answer);
    }

}
