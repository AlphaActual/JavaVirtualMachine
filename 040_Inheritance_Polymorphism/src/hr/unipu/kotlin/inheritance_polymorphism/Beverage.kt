package hr.unipu.kotlin.inheritance_polymorphism

// Izvedena klasa
class Beverage : Item {
    var volume: Double = 0.0       // Novi atribut kojeg bazna klasa nema

    override val itemType: String
        get() = "Beverage"

    // Konstruktor 0
    // -> ovdje prvoditelj automatski ubacuje super() ako se instancira s praznim konstruktorom "new Beverage()"

    // Konstruktor 1
    constructor(sku: String, name: String, volume: Double) : super(sku, name) {
        this.volume = volume
    }

    // Konstruktor 2
    constructor(sku: String, name: String, price: Double, volume: Double) : super(sku, name, price) {
        this.volume = volume
    }
}
