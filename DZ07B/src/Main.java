import java.util.Scanner;
import java.util.Locale;

/**
 *
 * @author Pritišanac Tin
 * @version 1.0
 * DZ 7B lambda izrazi i anonimne klase
 * Kod svih zadaća dostupan je na git repozitoriju: <a href="https://github.com/AlphaActual/JavaVirtualMachine">...</a>
 *
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.UK);

        System.out.println("Unesite prvi broj:");
        while (!scanner.hasNextDouble()) {
            System.out.println("Nije unešen validan tip double:");
            scanner.next();
        }
        double number1 = scanner.nextDouble();

        System.out.println("Unesite drugi broj:");
        while (!scanner.hasNextDouble()) {
            System.out.println("Nije unešen validan tip double:");
            scanner.next();
        }
        double number2 = scanner.nextDouble();

        System.out.println("Odaberite računsku operaciju (+, -, *, /):");
        String operation = scanner.next();

        Operation op;
        switch (operation) {
            case "+":
                op = () -> number1 + number2; // lambda expression
                break;
            case "-":
                op = () -> number1 - number2; // lambda expression
                break;
            case "*":
                op = () -> number1 * number2; // lambda expression
                break;
            case "/":
                op = new Operation() { // anonymous class
                    @Override
                    public double execute() {
                        if (number2 == 0) {
                            throw new IllegalArgumentException("Cannot divide by zero");
                        }
                        return number1 / number2;
                    }
                };
                break;
            default:
                throw new IllegalArgumentException("Invalid operation");
        }

        SimpleCalculator calculator = new SimpleCalculator();
        double result = calculator.performOperation(op);

        System.out.println("Rezultat: " + result);
    }
}