package hr.unipu.kotlin.abstract_interfaces

import java.time.LocalDate
import java.time.format.DateTimeFormatter

class Food : Item, IPerishable {
    var weight: Double = 0.toDouble()
    override var bestBefore: LocalDate? = null

    override val itemType: String
        get() = "Food"

    override val vat: Double
        get() = 0.13

    constructor(sku: String, name: String, bestBefore: LocalDate) : super(sku, name) {
        this.bestBefore = bestBefore
    }

    constructor(sku: String, name: String, price: Double, bestBefore: LocalDate) : super(sku, name, price) {
        this.bestBefore = bestBefore
    }

    override fun toString(): String {
        var s = super.toString()
        val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy.")
        s += ", best before: " + bestBefore!!.format(formatter)
        return s
    }
}
