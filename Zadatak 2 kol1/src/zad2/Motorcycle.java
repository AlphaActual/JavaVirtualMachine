package zad2;

// Klasa za motocikle
public class Motorcycle extends Vehicle implements Rentable {
    private MotorcycleType type;
    private double rentingPrice;

    public Motorcycle(String manufacturer, String model, String id, double power, int numberOfPassengers, double regularPrice, MotorcycleType type) {
        super(manufacturer, model, id, power, numberOfPassengers, regularPrice);
        this.type = type;
    }

    // Metoda za izračun cijene motocikla
    @Override
    public double getPrice(boolean isVIP) {
        if (isVIP) {
            return regularPrice * 0.85; // 15% popusta za VIP
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



