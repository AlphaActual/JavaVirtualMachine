package hr.unipu.kotlin.abstract_interfaces

import java.time.LocalDate


fun main(args: Array<String>) {
    val items = arrayOfNulls<Item>(3)
    items[0] = Beverage("23", "Coca cola", 10.0, 2.0)
    items[1] = Food("777", "CaoCao", 2.5, LocalDate.of(2016, 5, 11))
    items[2] = Cloth("045", "Simple T-shirt", 350.0, 54.0)
    calculatePrice(items)
}

private fun calculatePrice(items: Array<Item?>) {
    var price = 0.0
    for (item in items) {
        System.out.format("%s, price: %.2f, type: %s%n", item, item?.getPrice(1), item?.itemType)
        price += item?.getPrice(1) ?: 0.0
    }
    println("Total price = $price")
}


