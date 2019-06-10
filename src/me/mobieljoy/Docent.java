package me.mobieljoy;


public class Docent extends Persoon implements KortingskaartHouder{

	private String vierLetterCode;
	private String afdeling;
	
	
	public Docent(int burgerServiceNummer, String voornaam, String achternaam, Datum geboortedatum, char geslacht, String vierLetterCode, String afdeling) {
		super(burgerServiceNummer, voornaam, achternaam, geboortedatum, geslacht);
		this.vierLetterCode = vierLetterCode;
		this.afdeling = afdeling;
	}
	
	public Docent(String vierLetterCode, String afdeling) {
		super();
		this.vierLetterCode = vierLetterCode;
		this.afdeling = afdeling;
	}

	public String getVierLetterCode() {
		return vierLetterCode;
	}

	public void setVierLetterCode(String vierLetterCode) {
		this.vierLetterCode = vierLetterCode;
	}

	public String getAfdeling() {
		return afdeling;
	}

	public void setAfdeling(String afdeling) {
		this.afdeling = afdeling;
	}

	@Override
	public void drukAf() {
		super.drukAf();
		System.out.println("Vier letter code: "+vierLetterCode);
		System.out.println("Afdeling: "+afdeling);
	}

	@Override
	public double geefKortingsPercentage() {
		return 0.25;
	}

	@Override
	public boolean heeftMaximum() {
		return true;
	}

	@Override
	public double geefMaximum() {
		return 1;
	}
	
	
}

