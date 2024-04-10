package zad2;

// Klasa za automobile
public class Car extends Vehicle implements Rentable {
    private boolean hasAC;
    private int numberOfDoors;
    private double rentingPrice;

    public Car(String manufacturer, String model, String id, double power, int numberOfPassengers, double regularPrice, boolean hasAC, int numberOfDoors) {
        super(manufacturer, model, id, power, numberOfPassengers, regularPrice);
        this.hasAC = hasAC;
        this.numberOfDoors = numberOfDoors;
    }

    // Metoda za izračun cijene automobila
    @Override
    public double getPrice(boolean isVIP) {
        if (isVIP) {
            return regularPrice * 0.9; // 10% popust za VIP
        } else {
            return regularPrice;
        }
    }
    // Metoda za dodavanje cijene najma
    @Override
    public void addRentingPrice(double rentingPrice) {
        this.rentingPrice = rentingPrice;
    }

    // Metoda za dohvaćanje cijene najma
    @Override
    public double getRentingPrice() {
        return this.rentingPrice;
    }
}
