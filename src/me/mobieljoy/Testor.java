package me.mobieljoy;

public class Testor {
	
	public static void print(String s) {
		System.out.println(s);
	}
	
	public static void main(String[] args) {
		
		Datum valid = new Datum(22,4,2000);
		Datum valid2 = new Datum(29,2,2000);
		Datum invalid = new Datum(29,2,2001);
		
        Testor.print(valid.getDatumAsString());
        Testor.print(valid2.getDatumAsString());
        Testor.print(invalid.getDatumAsString());
    }
	
}
