package hr.unipu.java.inheritance_polymorphism;

// Bazna klasa
public class Item {	
	private String sku; //Stock Keeping Unit / ProductNumber
	private String name;
	private double netSalePrice;	//neto=bez PDV-a, bruto=sa PDV-om

	// Getter (accessor) metode
	public String getSku() {
		return sku;
	}	
	public String getName() {
		return name;
	}
	public double getNetSalePrice() {
		return netSalePrice;
	}
	public double getVAT(){
		return 0.25;
	}
	public double getPrice(int count){
		return count * getNetSalePrice() * (1 + getVAT());
	}
	public String getItemType(){
		return "";
	}

	// Setter (mutator) metode
	public void setName(String name) {
		this.name = name;
	}
	public void setNetSalePrice(double netSalePrice) {
		this.netSalePrice = netSalePrice;
	}


	// Konstruktor s 0 argumenata
	// -> prevoditelj sam ubaci "prazni konstruktor" (konstruktor bez argumenata) ako ga nema

	// Konstruktor s 2 argumenta
	public Item(String sku, String name){
		this.sku = sku;
		this.name = name;
	}

	// Konstruktor s 3 argumenta
	public Item(String sku, String name, double price){
		this(sku, name);			// Poziv konstruktora iste klase s 2 argumenta
		this.netSalePrice = price;
	}
	
	@Override
	public String toString() {
		return String.format("%s - %s", getSku(), getName());
	}
}
