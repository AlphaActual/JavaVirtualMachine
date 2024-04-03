package myQuizPackage;

public class MaxNumberOfQuestions extends RuntimeException {
    public MaxNumberOfQuestions() {
        super("Maksimalan broj pitanja je već postignut!");
    }
    public MaxNumberOfQuestions(int maxQuestions) {
        super("Maksimalan broj pitanja je: " + maxQuestions + "! Ne možete dodati više pitanja.");
    }
}