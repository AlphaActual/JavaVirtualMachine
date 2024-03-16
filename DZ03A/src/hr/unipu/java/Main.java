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

public class Main {

    public static void main(String[] args) {

        // Instanciranje novog kviza
        Quiz quiz = null;

        do {
            Quiz.showMenu();
            Scanner scanner = new Scanner(System.in);
            if(!isInputInt(scanner)) {
                continue;
            }
            int choice = scanner.nextInt(); scanner.nextLine();
            switch (choice) {
                // dodavanje pitanja kompozicijom
                case 1:
                    // Postavljanje novog kviza
                    if(quiz == null) {
                        System.out.println("Unesite ime kviza: ");
                        String name = scanner.nextLine();
                        System.out.println("Unesite maksimalan broj pitanja: ");
                        int maxQuestions = scanner.nextInt(); scanner.nextLine();
                        quiz = new Quiz(name, maxQuestions);
                    }
                    if(quiz.questionsFull()) {
                        System.out.println("Nije moguće dodati više pitanja!");
                        break;
                    }
                    System.out.println("Unesite pitanje: ");
                    String question = scanner.nextLine();
                    System.out.println("Unesite točan odgovor: ");
                    String answer = scanner.nextLine();
                    boolean questionAdded = quiz.addQuestion(question, answer);
                    if(questionAdded) {
                        System.out.println("Pitanje je uspješno dodano!");
                    }
                    break;
                case 2:
                    if (quiz == null) {
                        System.out.println("Nije moguće pokrenuti kviz jer nije postavljen niti jedan kviz!");
                        break;
                    }
                    quiz.runQuiz();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Nepostojeći izbor!");
            }
        } while (true);

    }
    public static boolean isInputInt(Scanner scanner) {
        if(!scanner.hasNextInt()){
            System.out.println("Netočan unos. Unesite brojčanu vrijednost");
            scanner.next(); // consume the invalid input
            return false;
        }
        return true;
    }
}
