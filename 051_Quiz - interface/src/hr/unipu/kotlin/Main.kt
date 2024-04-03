package hr.unipu.kotlin


fun main(args: Array<String>) {
    val question1 = IShortAnswerQuestion("pitanje1", "o1")
    val question2 = IMultipleChoiceQuestion("pitanje2", "o1", "o2")

    println("SAQ")
    useQuestion(question1)

    println("MCQ")
    useQuestion(question2)
}

private fun useQuestion(question: Question) {
    // Dinamičko povezivanje = tip objekta određen u vremenu izvršavanja (runtime),
    // jer tip objekta ne može odrediti prevoditelj u trenutku prevođenja.
    println("Pitanje: " + question.text)

    println("o1: " + question.isCorrectAnswer("o1"))
    println("o2: " + question.isCorrectAnswer("o2"))
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