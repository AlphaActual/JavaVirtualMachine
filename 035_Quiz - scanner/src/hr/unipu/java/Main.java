package hr.unipu.java;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Kreiranje objekta 'question', zapis reference u varijablu
        ShortAnswerQuestion question = new ShortAnswerQuestion("U kojem jeziku se programira za Android?", "Java");

        // Poziv medota nad objektom 'question'. Ispis pitanja.
        System.out.println(question.getText());

        // Učitavanje odgovora s tipkovnice
        Scanner scanner = new Scanner(System.in);

        boolean isCorrectAnswer = false;

        // Ponavaljanje učitavanja odgovora s tipkovnice dok odgovor nije točan
        while(!isCorrectAnswer){
            String answer = scanner.nextLine();
            isCorrectAnswer = question.isCorrectAnswer(answer);
            if (isCorrectAnswer) {
                System.out.println("Točno!!!");
            } else {
                System.out.println("Netočno.");
            }
        }

        // Predaja odgovora
//        System.out.println("C: " + question.isCorrectAnswer("C"));
//        System.out.println("Java: " + question.isCorrectAnswer("Java"));
    }
}
