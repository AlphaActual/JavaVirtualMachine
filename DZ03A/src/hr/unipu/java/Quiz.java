package hr.unipu.java;
import java.util.Scanner;

/**
 *
 * @author Pritišanac Tin
 * @version 1.0
 * DZ 3A korištenjem kompozicije
 * Kod svih zadaća dostupan je na git repozitoriju: https://github.com/AlphaActual/JavaVirtualMachine
 *
 */

public class  Quiz {
    static final int MAX_QUESTIONS_DEFAULT = 10;
    private String name;    //ime kviza
    private ShortAnswerQuestion[] questions;  //polje pitanja
    private int noOfQuestions = 0; //inicijalno je kviz prazan (bez pitanja)

    // Konstruktor 1 postavljanje početne vrijednosti
    public Quiz() {
       this(MAX_QUESTIONS_DEFAULT);
    }

    //    Konstruktor 2
    public Quiz(int maxQuestions) {
        this("Initial Quiz", maxQuestions);
    }

    // Konstruktor 3 (overloading = preopterećivanje)
    public Quiz(String name, int maxQuestions) {
        questions = new ShortAnswerQuestion[maxQuestions];
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // kompozicija klase Quiz
    public boolean addQuestion(String text, String answer) {
        if(noOfQuestions < questions.length) {
            questions[noOfQuestions++] = new ShortAnswerQuestion(text, answer);
            return true;
        } else {
            return false;
        }
    }

    // agregacija klase Quiz
    public boolean addQuestion(ShortAnswerQuestion question) {
        if (noOfQuestions < questions.length) {
            questions[noOfQuestions++] = question;
            return true;
        } else {
            return false;
        }
    }
    public boolean questionsFull() {
        return noOfQuestions == questions.length;
    }
    public int getNoOfQuestions() {
        return noOfQuestions;
    }

    public String getQuestion(int index) {
        return questions[index].getText();
    }

    public boolean isCorrectAnswer(int questionIndex, String answer) {
        return questions[questionIndex].isCorrectAnswer(answer);
    }

    public static void showMenu() {
        System.out.println("Odaberite opciju:");
        System.out.println("1. Dodaj pitanje");
        System.out.println("2. Pokreni kviz");
        System.out.println("3. Izađi iz programa");
    }

    public void runQuiz() {
        if(this.getNoOfQuestions() == 0) {System.out.println("Kviz nema pitanja!") ; return;}
        Scanner sc = new Scanner(System.in);
        int noOfCorrectAnswers = 0;
        for (int i = 0; i < this.getNoOfQuestions(); i++) {
            System.out.println(this.getQuestion(i));
            String answer = sc.nextLine();
            if(this.isCorrectAnswer(i, answer)) {
                noOfCorrectAnswers++;
                System.out.println("Točno!");
            } else {
                System.out.println("Netočno.");
            }
        }
        System.out.println("Imali ste " + noOfCorrectAnswers + " točnih odgovora od ukupno " +
                this.getNoOfQuestions() + " sto je " +
                ((double)noOfCorrectAnswers/this.getNoOfQuestions())*100 + "%.");
    }

}
