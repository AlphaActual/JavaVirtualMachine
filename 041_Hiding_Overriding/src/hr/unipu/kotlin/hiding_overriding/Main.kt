package hr.unipu.kotlin.hiding_overriding

// Bazna klasa
internal open class A {

    // Članska metoda
    internal open fun virt() {
        stat()
        stat()
    }

    companion object {

        // Statička metoda
        fun stat() {
            println("A.m")
        }
    }
}

// Izvedena klasa
internal class B : A() {

    // Članska metoda
    override fun virt() {
        stat()
        A.stat()
        stat()
    }

    companion object {

        // Statička metoda
        internal fun stat() {
            println("B.m")
        }
    }
}

fun main(args: Array<String>) {

    //        A aa = new A();
    //        System.out.println("calling aa.stat():");
    //        aa.stat();    // može se pozvati i sa: A.stat()
    //        System.out.println("calling aa.virt():");
    //        aa.virt();

    val bb = B()
    println("calling bb.stat():")
    //bb.stat()
    B.stat()    // U Kotlinu se može pozvati samo sa : B.stat()
    println("calling bb.virt():")
    bb.virt()

    val ab = B()
    println("calling ab.stat():")
    //ab.stat()
    B.stat()    // U Kotlinu se može pozvati samo sa : B.stat()
    println("calling ab.virt():")
    ab.virt()

}