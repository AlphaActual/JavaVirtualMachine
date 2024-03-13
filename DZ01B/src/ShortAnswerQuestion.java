/**
 * This class represents a short answer question.
 */
public class ShortAnswerQuestion {
    // The text of the question
    private String text;
    // The correct answer to the question
    private String correctAnswer;

    /**
     * Constructs a new ShortAnswerQuestion with the specified text and correct answer.
     *
     * @param text the text of the question
     * @param correctAnswer the correct answer to the question
     */
    public ShortAnswerQuestion(String text, String correctAnswer) {
        this.text = text;
        this.correctAnswer = correctAnswer;
    }

    /**
     * Returns the text of the question.
     *
     * @return the text of the question
     */
    public String getText() {
        return text;
    }

    /**
     * Checks if the provided answer is correct.
     *
     * @param answer the answer to check
     * @return true if the answer is correct, false otherwise
     */
    public boolean isCorrectAnswer(String answer) {
        return answer.equalsIgnoreCase(correctAnswer);
    }
}
