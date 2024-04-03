package hr.unipu.kotlin.abstract_interfaces

import java.time.LocalDate

class Milk(sku: String, name: String, price: Double, volume: Double, var type: MilkType?, override var bestBefore: LocalDate?) : Beverage(sku, name, price, volume), IPerishable {
    var fatPercentage: Double = 0.toDouble()

    override val itemType: String
        get() = "Milk"

    override val vat: Double
        get() = 0.05
}
