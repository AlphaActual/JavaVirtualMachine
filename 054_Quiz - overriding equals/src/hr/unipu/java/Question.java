package hr.unipu.java;

// sučelje kojim se deklariraju metode koje će kasnije biti implementirane
public interface Question {
    String getText();
    boolean isCorrectAnswer(String answer);
}

