package hr.unipu.java;

public class Main {

    public static void main(String[] args) {
        // Kreiranje 2 objekta 'question', zapis reference u varijablu
        ShortAnswerQuestion question1 = new ShortAnswerQuestion(
                "U kojem jeziku se programira za Android?", "Java");
        ShortAnswerQuestion question2 = new ShortAnswerQuestion(
                "U kojem jeziku se programira za iPhone?", "Objective-C");


        // Poziv metoda nad 1. objektom: 'question1'
        System.out.println(question1.getText());
        System.out.println("objective-c: " + question1.isCorrectAnswer("objective-c"));
        System.out.println("java: " + question1.isCorrectAnswer("java"));

        // Poziv metoda nad 2. objektom: 'question2'
        System.out.println(question2.getText());
        System.out.println("objective-c: " + question2.isCorrectAnswer("objective-c"));
        System.out.println("java: " + question2.isCorrectAnswer("java"));

    }
}
