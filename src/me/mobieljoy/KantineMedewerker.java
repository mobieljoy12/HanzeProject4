package me.mobieljoy;


public class KantineMedewerker extends Persoon implements KortingskaartHouder {

	private int medewerkersNummer;
	private boolean magAchterKassa;
	
	public KantineMedewerker(int burgerServiceNummer, String voornaam, String achternaam, Datum geboortedatum, char geslacht, int medewerkersNummer, boolean magAchterKassa) {
		super(burgerServiceNummer, voornaam, achternaam, geboortedatum, geslacht);
		this.medewerkersNummer = medewerkersNummer;
		this.magAchterKassa = magAchterKassa;
	}
	
	public KantineMedewerker(int medewerkersNummer, boolean magAchterKassa) {
		super();
		this.medewerkersNummer = medewerkersNummer;
		this.magAchterKassa = magAchterKassa;
	}

	public int getMedewerkersNummer() {
		return medewerkersNummer;
	}

	public void setMedewerkersNummer(int medewerkersNummer) {
		this.medewerkersNummer = medewerkersNummer;
	}

	public boolean isMagAchterKassa() {
		return magAchterKassa;
	}

	public void setMagAchterKassa(boolean magAchterKassa) {
		this.magAchterKassa = magAchterKassa;
	}

	@Override
	public void drukAf() {
		super.drukAf();
		System.out.println("Medewerkers nummer: "+medewerkersNummer);
		System.out.println("Mag achter kassa: "+ magAchterKassa);
	}

	@Override
	public double geefKortingsPercentage() {
		return 0.35;
	}

	@Override
	public boolean heeftMaximum() {
		return false;
	}

	@Override
	public double geefMaximum() {
		return 0;
	}
}

