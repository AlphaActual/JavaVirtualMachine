package hr.unipu.kotlin


fun main(args: Array<String>) {
    // Instanciranje 2 pitanja i točna odgovora: jedno s jednostrukim odgovorm i jedno s višestrukim odgovorom
    val question1a = AShortAnswerQuestion("pitanje1", "o1")
    val question1b = AShortAnswerQuestion("pitanje1", "o1")
    val question2 = AMultipleChoiceQuestion("pitanje2", arrayOf("o1", "o2"))

    // Test jesu li pitanja ista?
    if (question1a == question1b) {
        println("Pitanja su jednaka.")
    } else {
        println("Pitanja su različita.")
    }

    // Pokretanje kviza
    /*
    System.out.println("SAQ");
    useQuestion(question1a);

    System.out.println("MCQ");
    useQuestion(question2);
    */
}

private fun useQuestion(question: Question) {
    // Dinamičko povezivanje = tip objekta određen u vremenu izvršavanja (runtime),
    // jer tip objekta ne može odrediti prevoditelj u trenutku prevođenja.
    println("Pitanje: " + question.text)   //postavljanje pitanja

    println("o1: " + question.isCorrectAnswer("o1"))    //predaja odgovora
    println("o2: " + question.isCorrectAnswer("o2"))    //predaja odgovora
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