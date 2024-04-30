abstract class Operation<T extends Number> {
    protected T number1;
    protected T number2;

    public Operation(T number1, T number2) {
        this.number1 = number1;
        this.number2 = number2;
    }

    public abstract double execute();
}

class Addition<T extends Number> extends Operation<T> {
    public Addition(T number1, T number2) {
        super(number1, number2);
    }

    @Override
    public double execute() {
        // Implicit unboxing from Number to double
        return number1.doubleValue() + number2.doubleValue();
    }
}

class Subtraction<T extends Number> extends Operation<T> {
    public Subtraction(T number1, T number2) {
        super(number1, number2);
    }

    @Override
    public double execute() {
        // Implicit unboxing from Number to double
        return number1.doubleValue() - number2.doubleValue();
    }
}

class Multiplication<T extends Number> extends Operation<T> {
    public Multiplication(T number1, T number2) {
        super(number1, number2);
    }

    @Override
    public double execute() {
        // Implicit unboxing from Number to double
        return number1.doubleValue() * number2.doubleValue();
    }
}

class Division<T extends Number> extends Operation<T> {
    public Division(T number1, T number2) {
        super(number1, number2);
    }

    @Override
    public double execute() {
        if (number2.doubleValue() != 0) {
            // Implicit unboxing from Number to double
            return number1.doubleValue() / number2.doubleValue();
        } else {
            throw new ArithmeticException("Cannot divide by zero");
        }
    }
}

interface Calculator<T extends Number> {
    double performOperation(Operation<T> operation);
}

class SimpleCalculator<T extends Number> implements Calculator<T> {
    @Override
    public double performOperation(Operation<T> operation) {
        return operation.execute();
    }
}