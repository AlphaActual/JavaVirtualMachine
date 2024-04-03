abstract class Operation {
    protected double number1;
    protected double number2;

    public Operation(double number1, double number2) {
        this.number1 = number1;
        this.number2 = number2;
    }

    public abstract double execute();
}

class Addition extends Operation {
    public Addition(double number1, double number2) {
        super(number1, number2);
    }

    @Override
    public double execute() {
        return number1 + number2;
    }
}

class Subtraction extends Operation {
    public Subtraction(double number1, double number2) {
        super(number1, number2);
    }

    @Override
    public double execute() {
        return number1 - number2;
    }
}

class Multiplication extends Operation {
    public Multiplication(double number1, double number2) {
        super(number1, number2);
    }

    @Override
    public double execute() {
        return number1 * number2;
    }
}

class Division extends Operation {
    public Division(double number1, double number2) {
        super(number1, number2);
    }

    @Override
    public double execute() {
        if (number2 != 0) {
            return number1 / number2;
        } else {
            throw new ArithmeticException("Cannot divide by zero");
        }
    }
}

interface Calculator {
    double performOperation(Operation operation);
}

class SimpleCalculator implements Calculator {
    @Override
    public double performOperation(Operation operation) {
        return operation.execute();
    }
}