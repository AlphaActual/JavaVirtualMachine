import java.util.Scanner;
import java.util.Locale;

/**
 *
 * @author Pritišanac Tin
 * @version 1.0
 * DZ 7A genericke definicije, upcasting i downcasting, autoboxing i unboxing
 * Kod svih zadaća dostupan je na git repozitoriju: https://github.com/AlphaActual/JavaVirtualMachine
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

        Operation<Double> op;
        switch (operation) {
            case "+":
                // upcasting Addition<Double> to Operation<Double>
                op = new Addition<>(number1, number2);
                break;
            case "-":
                // upcasting Subtraction<Double> to Operation<Double>
                op = new Subtraction<>(number1, number2);
                break;
            case "*":
                // upcasting Multiplication<Double> to Operation<Double>
                op = new Multiplication<>(number1, number2);
                break;
            case "/":
                // upcasting Division<Double> to Operation<Double>
                op = new Division<>(number1, number2);
                break;
            default:
                throw new IllegalArgumentException("Invalid operation");
        }

        SimpleCalculator<Double> calculator = new SimpleCalculator<>();
        double result = calculator.performOperation(op);

        System.out.println("Rezultat: " + result);
    }
}