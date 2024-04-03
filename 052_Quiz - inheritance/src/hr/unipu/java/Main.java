package hr.unipu.java;

public class Main {

    public static void main(String[] args) {
        Question question1 =  new EShortAnswerQuestion("pitanje1", "o1");
        Question question2 =  new EMultipleChoiceQuestion("pitanje2", "o1", "o2");

        System.out.println("SAQ");
        useQuestion(question1);

        System.out.println("MCQ");
        useQuestion(question2);
    }

    private static void useQuestion(Question question) {
        // Dinamičko povezivanje = tip objekta određen u vremenu izvršavanja (runtime),
        // jer tip objekta ne može odrediti prevoditelj u trenutku prevođenja.
        System.out.println("Pitanje: " + question.getText());

        System.out.println("o1: " + question.isCorrectAnswer("o1"));
        System.out.println("o2: " + question.isCorrectAnswer("o2"));
    }

}

//        // Kreiranje objekta 'question', zapis reference u varijablu
//        ShortAnswerQuestion question = new ShortAnswerQuestion("U kojem jeziku se programira za Android?", "Java");
//
//        // Poziv medota nad objektom 'question'. Ispis pitanja.
//        System.out.println(question.getText());
//
//        // Učitavanje odgovora s tipkovnice
//        Scanner scanner = new Scanner(System.in);
//
//        boolean isCorrectAnswer = false;
//
//        while(!isCorrectAnswer){
//            String answer = scanner.nextLine();
//            isCorrectAnswer = question.isCorrectAnswer(answer);
//            if (isCorrectAnswer) {
//                System.out.println("Točno!!!");
//            } else {
//                System.out.println("Netočno.");
//            }
//        }

        // Predaja odgovora
//        System.out.println("C: " + question.isCorrectAnswer("C"));
//        System.out.println("Java: " + question.isCorrectAnswer("Java"));