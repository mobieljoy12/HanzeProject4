package me.mobieljoy;

public class Artikel {

	private String naam;
	private Double prijs;
	
	public Artikel(String naam, Double prijs) {
		this.naam = naam;
		this.prijs = prijs;
	}
	
	public Artikel() {
		this.naam = "";
		this.prijs = 0.0;
	}
	
	public String getNaam() {
		return this.naam;
	}
	
	public Double getPrijs() {
		return this.prijs;
	}
	
	public void setNaam(String naam) {
		this.naam = naam;
	}
	
	public void setPrijs(Double prijs) {
		this.prijs = prijs;
	}
	
	public String toString() {
		return this.naam + ", " + this.prijs;
	}
	
}

