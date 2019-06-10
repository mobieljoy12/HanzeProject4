package me.mobieljoy;

public class Persoon {

	private int BSN;
	private String voornaam;
	private String achternaam;
	private Datum geboortedatum;
	private Character geslacht;
	
	public Persoon(int BSN, String voornaam, String achternaam, Datum geboortedatum, Character geslacht) {
		
		this.BSN = BSN;
		this.voornaam = voornaam;
		this.achternaam = achternaam;
		this.geboortedatum = geboortedatum;
		if(geslacht == "V".charAt(0) || geslacht == "M".charAt(0)) {
			this.geslacht = geslacht;
		}else {
			this.geslacht = "X".charAt(0);
		}
		
	}
	
	public Persoon() {
		this.BSN = (int) 0;
		this.voornaam = "";
		this.achternaam = "";
		this.geboortedatum = new Datum();
		this.geslacht = "X".charAt(0);
	}
	
	public int getBSN() {
		return BSN;
	}
	public void setBSN(int bSN) {
		this.BSN = bSN;
	}
	public String getVoornaam() {
		if(this.voornaam.length() > 0) {
			return voornaam;
		}else {
			return "Onbekend";
		}
	}
	public void setVoornaam(String voornaam) {
		this.voornaam = voornaam;
	}
	public String getAchternaam() {
		if(this.achternaam.length() > 0) {
			return this.achternaam;
		}else {
			return "Onbekend";
		}
	}
	public void setAchternaam(String achternaam) {
		this.achternaam = achternaam;
	}
	public String getGeboortedatum() {
		return this.geboortedatum.getDatumAsString();
	}
	public void setGeboortedatum(Datum geboortedatum) {
		this.geboortedatum = geboortedatum;
	}
	public String getGeslacht() {
		if(this.geslacht == "V".charAt(0)) {
			return "Vrouw";
		}else if(this.geslacht == "M".charAt(0)) {
			return "Man";
		}else {
			return "Onbekend";
		}
	}
	public void setGeslacht(Character geslacht) {
		if(geslacht == "V".charAt(0) || geslacht == "M".charAt(0)) {
			this.geslacht = geslacht;
		}else {
			this.geslacht = "X".charAt(0);
		}
	}
	public void drukAf(){
		System.out.println(this.voornaam + " " + this.achternaam);
		System.out.println("Geslacht: " + this.getGeslacht());
		System.out.println("Geboortedatum: "+ this.getGeboortedatum());
		System.out.println("BSN: "+ this.BSN); 
	}
}
