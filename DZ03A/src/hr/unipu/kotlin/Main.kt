package hr.unipu.kotlin

import java.util.Scanner

fun main(args: Array<String>) {

    // Instanciranje novog kviza
    val quiz = Quiz()

    // Dodavanje pitanja i točnih odgovora (kompozicija)
    quiz.addQuestion("U kojem jeziku se programira za Android?", "Java")
    quiz.addQuestion("U kojem jeziku se programira za iPhone?", "Objective-C")

    // Dodavanje pitanja i točnih odgovora (agregacija)
    //    val question1 = ShortAnswerQuestion("U kojem jeziku se programira za Android?", "Java")
    //    quiz.addQuestion(question1)
    //    val question2 = ShortAnswerQuestion("U kojem jeziku se programira za iPhone?", "Objective-C")
    //    quiz.addQuestion(question2)


    // Učitavanje odgovora s tipkovnice
    val scanner = Scanner(System.`in`)
    var noOfCorrectAnswers = 0
    for (i in 0 until quiz.noOfQuestions) {
        println(quiz.getQuestion(i))
        val answer = scanner.nextLine()
        if (quiz.isCorrectAnswer(i, answer)!!) {
            noOfCorrectAnswers++
            println("Točno!")
        } else {
            println("Netočno.")
        }
    }

    println("Imali ste " + noOfCorrectAnswers + " točnih odgovora od ukupno " + quiz.noOfQuestions + ".")

}
