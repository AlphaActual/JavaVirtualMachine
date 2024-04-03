package hr.unipu.kotlin.abstract_interfaces

import java.time.LocalDate
import java.time.format.DateTimeFormatter


fun main(args: Array<String>) {
    val items = arrayOfNulls<Item>(4)
    items[0] = Beverage("23", "Coca cola", 10.0, 2.0)
    items[1] = Food("777", "CaoCao", 2.5, LocalDate.of(2016, 5, 11))
    items[2] = Cloth("045", "Simple T-shirt", 350.0, 54.0)
    items[3] = Milk("888", "Tonka", 6.5, 1.0, MilkType.COW, LocalDate.of(2015, 10, 25))
    printPerishableItems(items)
}

private fun printPerishableItems(items: Array<Item?>) {
    val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy.")
    for (item in items) {
        if (item is IPerishable) {
            val perishable = item as IPerishable
            System.out.format("%s, type: %s, use before: %s %n", item, item.itemType,
                    perishable.bestBefore?.format(formatter))
        }
    }
}


