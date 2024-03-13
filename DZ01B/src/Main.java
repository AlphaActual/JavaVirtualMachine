/**
 * Main class of the application.
 */
public class Main {
    /**
     * The entry point of the application.
     * @param args The command-line arguments
     */
    public static void main(String[] args) {
        // Create a new ShortAnswerQuestion object with a question and its correct answer
        ShortAnswerQuestion question = new ShortAnswerQuestion(
                "U kojem jeziku se programira za Android?", "Java");
        
        // Print the question text to the console
        System.out.println(question.getText());
        
        // Check if "C" is the correct answer and print the result
        System.out.println("C: " + question.isCorrectAnswer("C"));
        
        // Check if "java" is the correct answer and print the result
        System.out.println("java: " + question.isCorrectAnswer("java"));
    }
}