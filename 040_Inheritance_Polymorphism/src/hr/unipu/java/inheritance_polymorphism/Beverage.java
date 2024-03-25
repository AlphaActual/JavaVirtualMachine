package hr.unipu.java.inheritance_polymorphism;

public class Beverage extends Item {
	private double volume;		// Novi atribut kojeg bazna klasa nema

	// Konstruktor 0
	// -> ovdje prvoditelj automatski ubacuje super() ako se instancira s praznim konstruktorom "new Beverage()"

	// Konstruktor 1
	public Beverage(String sku, String name, double volume){
		super(sku, name);			// Prva naredba: eksplicitno poziv konstruktora bazne klase
		this.volume = volume;
	}

	// Konstruktor 2
	public Beverage(String sku, String name, double price, double volume){
		super(sku, name, price);	// Prva naredba: eksplicitno poziv konstruktora bazne klase
		this.volume = volume;
	}
	
	@Override
	public String getItemType() {
		return "Beverage";
	}

	public double getVolume() {
		return volume;
	}
	public void setVolume(double volume) {
		this.volume = volume;
	}
	
}
