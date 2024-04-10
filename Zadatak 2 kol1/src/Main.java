import java.util.ArrayList;
import zad2.Car;
import zad2.Motorcycle;
import zad2.Truck;
import zad2.Vehicle;
import zad2.Rentable;
import zad2.MotorcycleType;

/**
 *
 * @author Pritišanac Tin
 * @version 1.0
 * Kolokvij 1 zadatak 2
 *
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<Vehicle> vehicles = loadVehicles();

        // Zbrajanje cijena najma za sva vozila koja se mogu iznajmiti
        double totalRentingPrice = 0;
        System.out.println("Modeli i cijene vozila koja se mogu iznajmiti:");
        for (Vehicle vehicle : vehicles) {
            // Ako je vozilo rentable, dodaj cijenu najma
            if (vehicle instanceof Rentable) {
                System.out.println(vehicle.getManufacturer() + " " + vehicle.getModel() + " - " + ((Rentable) vehicle).getRentingPrice() + " eur");
                totalRentingPrice += ((Rentable) vehicle).getRentingPrice();
            }
        }

        System.out.println("Ukupna cijena najma za sva vozila koja se mogu iznajmiti: " + totalRentingPrice);
    }

    // Metoda koja simulira učitavanje vozila iz baze podataka
    public static ArrayList<Vehicle> loadVehicles() {
        ArrayList<Vehicle> vehicles = new ArrayList<>();

        // Dodavanje vozila u listu
        Car car = new Car("Toyota", "Corolla", "123", 100, 4, 20000, true, 4);
        car.addRentingPrice(100);
        vehicles.add(car);

        Truck truck = new Truck("Volvo", "FH", "456", 500, 2, 50000, 20000);
        vehicles.add(truck);

        Motorcycle motorcycle = new Motorcycle("Yamaha", "YZF-R1", "789", 200, 1, 15000, MotorcycleType.SPORT);
        motorcycle.addRentingPrice(50);
        vehicles.add(motorcycle);

        Car car2 = new Car("Renault", "Twingo", "164", 50, 4, 7000, true, 3);
        car2.addRentingPrice(65);
        vehicles.add(car2);

        return vehicles;
    }
}