package hr.unipu.kotlin.inheritance_polymorphism

// Bazna klasa
open class Item(val sku: String, var name: String?) {
    var netSalePrice: Double = 0.0   //neto=bez PDV-a, bruto=sa PDV-om
    open val VAT: Double
        get() = 0.25
    open val itemType: String
        get() = ""

    fun getPrice(count: Int): Double {
        return count.toDouble() * netSalePrice * (1 + VAT)
    }

    // Konstruktor s 3 argumenta
    constructor(sku: String, name: String, price: Double) : this(sku, name) {
        this.netSalePrice = price
    }

    override fun toString(): String {
        return String.format("%s - %s", sku, name)
    }
}
