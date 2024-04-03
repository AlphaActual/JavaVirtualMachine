package hr.unipu.kotlin.abstract_interfaces

import java.time.LocalDate

interface IPerishable {
    //Podrazumijevana (default) implementacija u sučeljima
    val instructions: String
        get() = "Keep in dry and cool place"
    var bestBefore: LocalDate?
}
