package hr.unipu.java.abstract_interfaces;

import java.time.LocalDate;

public interface IPerishable {
	//Podrazumijevana (default) implementacija u sučeljima
	default public String getInstructions(){
		return "Keep in dry and cool place";
	}
	public LocalDate getBestBefore();
	public void setBestBefore(LocalDate bestBefore);
}
