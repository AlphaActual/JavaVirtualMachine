package hr.unipu.kotlin.abstract_interfaces

abstract class Item(val sku: String //Stock Keeping Unit / ProductNumber
                    , var name: String?) {
    var netSalePrice: Double = 0.toDouble()
    open val vat: Double
        get() = 0.25
    abstract val itemType: String
    fun getPrice(count: Int): Double {
        return count.toDouble() * netSalePrice * (1 + vat)
    }

    constructor(sku: String, name: String, price: Double) : this(sku, name) {
        this.netSalePrice = price
    }

    override fun toString(): String {
        return String.format("%s - %s (%s)", sku, name, itemType)
    }
}
