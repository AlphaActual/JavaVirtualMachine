public interface Operation {
    double execute();
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