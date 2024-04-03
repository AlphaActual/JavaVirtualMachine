package hr.unipu.kotlin.abstract_interfaces

class Cloth : Item {
    var size: Double = 0.toDouble()

    override val itemType: String
        get() = "Cloth"

    constructor(sku: String, name: String, size: Double) : super(sku, name) {
        this.size = size
    }

    constructor(sku: String, name: String, price: Double, size: Double) : super(sku, name, price) {
        this.size = size
    }

}
