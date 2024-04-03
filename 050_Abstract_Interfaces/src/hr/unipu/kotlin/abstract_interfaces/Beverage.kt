package hr.unipu.kotlin.abstract_interfaces

open class Beverage : Item {
    var volume: Double = 0.toDouble()

    override val itemType: String
        get() = "Beverage"

    constructor(sku: String, name: String, volume: Double) : super(sku, name) {
        this.volume = volume
    }

    constructor(sku: String, name: String, price: Double, volume: Double) : super(sku, name, price) {
        this.volume = volume
    }

}
