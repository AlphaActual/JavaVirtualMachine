package hr.unipu.kotlin

fun main(args: Array<String>) {

    // Kreiranje 2 objekta 'question', zapis reference u varijablu
    val question1 = ShortAnswerQuestion(
            "U kojem jeziku se programira za Android?", "Java")
    val question2 = ShortAnswerQuestion(
            "U kojem jeziku se programira za iPhone?", "Objective-C")


    // Poziv metoda nad 1. objektom: 'question1'
    println(question1.text)
    println("objective-c: " + question1.isCorrectAnswer("objective-c"))
    println("java: " + question1.isCorrectAnswer("java"))
    // > U kojem jeziku se programira za Android?
    // > objective-c: false
    // > java: true


    // Poziv metoda nad 2. objektom: 'question2'
    println(question2.text)
    println("objective-c: " + question2.isCorrectAnswer("objective-c"))
    println("java: " + question2.isCorrectAnswer("java"))
    // > U kojem jeziku se programira za iPhone?
    // > objective-c: true
    // > java: false

}
