package hr.unipu.kotlin.inheritance_polymorphism

import java.time.LocalDate

fun main(args: Array<String>) {

    val item = Item("1256", "Rambo keks")
    item.netSalePrice = 5.0
    //System.out.format("%s, price: %.2f, type: %s%n", item, item.getPrice(1), item.itemType)
    println("${item}, price: ${item.getPrice(1)}, type: ${item.itemType}")

    val food = Food("777", "CaoCao", 2.5, LocalDate.of(2016, 5, 11))
    //System.out.format("%s, price: %.2f, type: %s%n", food, food.getPrice(1), food.itemType)
    println("${food}, price: ${food.getPrice(1)}, type: ${food.itemType}")

    val beverage = Beverage("23", "Coca cola", 10.0, 2.0)
    //System.out.format("%s, price: %.2f, type: %s%n", beverage, beverage.getPrice(1), beverage.itemType)
    println("${beverage}, price: ${beverage.getPrice(1)}, type: ${beverage.itemType}")

    // >   1256 - Rambo keks, price: 6.25, type:
    // >   777 - CaoCao, best before: 11.05.2016., price: 2.82, type: Food
    // >   23 - Coca cola, price: 12.50, type: Beverage
}