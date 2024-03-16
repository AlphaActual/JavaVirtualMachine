package hr.unipu.kotlin

import java.util.Scanner

fun main(args: Array<String>) {
    // Kreiranje objekta 'question', zapis reference u varijablu
    val question = ShortAnswerQuestion("U kojem jeziku se programira za Android?", "Java")

    // Poziv medota nad objektom 'question'. Ispis pitanja.
    println(question.text)

    // Učitavanje odgovora s tipkovnice
    val scanner = Scanner(System.`in`)

    var isCorrectAnswer = false

    // Ponavaljanje učitavanja odgovora s tipkovnice dok odgovor nije točan
    while (!isCorrectAnswer) {
        val answer = scanner.nextLine()
        isCorrectAnswer = question.isCorrectAnswer(answer)
        if (isCorrectAnswer) {
            println("Točno!!!")
        } else {
            println("Netočno.")
        }
    }

}
