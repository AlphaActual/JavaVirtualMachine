package zad2;

// Klasa za kamione
public class Truck extends Vehicle {
    private double maxWeight;

    public Truck(String manufacturer, String model, String id, double power, int numberOfPassengers, double regularPrice, double maxWeight) {
        super(manufacturer, model, id, power, numberOfPassengers, regularPrice);
        this.maxWeight = maxWeight;
    }

    // Metoda za izračun cijene kamiona
    @Override
    public double getPrice(boolean isVIP) {
        if (isVIP) {
            return regularPrice * 0.95; // 5% popust za  VIP
        } else {
            return regularPrice;
        }
    }
}
