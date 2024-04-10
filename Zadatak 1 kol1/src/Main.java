/**
 *
 * @author Pritišanac Tin
 * @version 1.0
 * Kolokvij zadatak 1
 *
 *
 */
public class Main {
    public static void main(String[] args) {
        Razlomak r1 = new Razlomak(1, 2);
        Razlomak r2 = new Razlomak(1, 2);

        System.out.println("Zbroj: " + r1.zbroji(r2));
        System.out.println("Razlika: " + r1.oduzmi(r2));
        System.out.println("Umnozak: " + r1.pomnozi(r2));
        System.out.println("Kvocijent: " + r1.podijeli(r2));

        System.out.println("Izazivanje iznimke kod dijeljenja s nulom");
        Razlomak r3 = new Razlomak(3, 0);
    }
}