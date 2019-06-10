package me.mobieljoy;


public class Student extends Persoon {

	private int studentnummer;
	private String studieRichting;
	
	
	public Student(int burgerServiceNummer, String voornaam, String achternaam, Datum geboortedatum, char geslacht, int studentnummer, String studieRichting) {
		super(burgerServiceNummer, voornaam, achternaam, geboortedatum, geslacht);
		this.studentnummer = studentnummer;
		this.studieRichting = studieRichting;
	}

	public Student(int studentnummer, String studieRichting) {
		super();
		this.studentnummer = studentnummer;
		this.studieRichting = studieRichting;
	}

	public int getStudentnummer() {
		return studentnummer;
	}

	public void setStudentnummer(int studentnummer) {
		this.studentnummer = studentnummer;
	}

	public String getStudieRichting() {
		return studieRichting;
	}

	public void setStudieRichting(String studieRichting) {
		this.studieRichting = studieRichting;
	}

	@Override
	public void drukAf() {
		super.drukAf();
		System.out.println("Studienummer: " + this.studentnummer);
		System.out.println("Studierichting: " + this.studieRichting);
	}

}
