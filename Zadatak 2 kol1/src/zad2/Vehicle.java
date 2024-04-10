package zad2;

// Temeljna abstraktna klasa za sva vozila
public abstract class Vehicle {
    protected String manufacturer;
    protected String model;
    protected String id;
    protected double power;
    protected int numberOfPassengers;
    protected double regularPrice;

    public Vehicle(String manufacturer, String model, String id, double power, int numberOfPassengers, double regularPrice) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.id = id;
        this.power = power;
        this.numberOfPassengers = numberOfPassengers;
        this.regularPrice = regularPrice;
    }

    // Abstraktna metoda za izračun cijene vozila - svaka klasa ju zasebno implementira
    public abstract double getPrice(boolean isVIP);

    // Metoda za dohvaćanje proizvođača
    public String getManufacturer() {
        return manufacturer;
    }

    // Metoda za dohvaćanje modela
    public String getModel() {
        return model;
    }
}
