import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Unesite prvi broj:");
        double number1 = scanner.nextDouble();

        System.out.println("Unesite drugi broj:");
        double number2 = scanner.nextDouble();

        System.out.println("Odaberite računsku operaciju (+, -, *, /):");
        String operation = scanner.next();

        Operation op;
        switch (operation) {
            case "+":
                op = new Addition(number1, number2);
                break;
            case "-":
                op = new Subtraction(number1, number2);
                break;
            case "*":
                op = new Multiplication(number1, number2);
                break;
            case "/":
                op = new Division(number1, number2);
                break;
            default:
                throw new IllegalArgumentException("Invalid operation");
        }

        SimpleCalculator calculator = new SimpleCalculator();
        double result = calculator.performOperation(op);

        System.out.println("Rezultat: " + result);
    }
}