package hr.unipu.kotlin.inheritance_polymorphism

import java.time.LocalDate

fun main(args: Array<String>) {

    val items = arrayOfNulls<Item>(3)    // polje artikala
    items[0] = Beverage("23", "Coca cola", 10.0, 2.0)
    items[1] = Food("777", "CaoCao", 2.5, LocalDate.of(2016, 5, 11))
    items[2] = Cloth("045", "Simple T-shirt", 350.0, 54.0)
    calculatePrice(items)    // poziv lokalne metode, prima se polje tipa Item

    // >   23 - Coca cola, price: 12.50, type: Beverage
    // >   777 - CaoCao, best before: 11.05.2016., price: 2.82, type: Food
    // >   045 - Simple T-shirt, price: 437.50, type: Cloth
    // >   Total price = 452.825
}


private fun calculatePrice(items: Array<Item?>) {
    var price = 0.0
    for (item in items) {
        System.out.format("%s, price: %.2f, type: %s%n", item, item?.getPrice(1), item?.itemType)
        price += item?.getPrice(1)!!       // ovaj 1 je count, cijena za n proizvoda, npr 2+1 gratis
    }
    println("Total price = $price")
}
