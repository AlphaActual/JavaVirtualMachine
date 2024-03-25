package hr.unipu.java.hiding_overriding;

// Bazna klasa
class A {

    // Statička metoda
    static void stat() {
        System.out.println("A.m");
    }

    // Članska metoda
    void virt() {
        stat();
        A.stat();
    }
}

// Izvedena klasa
class B extends A {

    // Statička metoda
    static void stat() {
        System.out.println("B.m");
    }

    // Članska metoda
    void virt() {
        stat();
        A.stat();
        B.stat();
    }
}

public class Main {

    public static void main(String[] args) {

//        A aa = new A();
//        System.out.println("calling aa.stat():");
//        aa.stat();    // može se pozvati i sa: A.stat()
//        System.out.println("calling aa.virt():");
//        aa.virt();

        B bb = new B();
        System.out.println("calling bb.stat():");
        bb.stat();      // može se pozvati i sa: B.stat()
        System.out.println("calling bb.virt():");
        bb.virt();

        A ab = new B();
        System.out.println("calling ab.stat():");
        ab.stat();
        System.out.println("calling ab.virt():");
        ab.virt();

    }

}
