package me.mobieljoy;

public class Testor {
	
	public static void print(String s) {
		System.out.println(s);
	}
	
	public static void main(String[] args) {
		
		//int[] gem = {45, 56, 34, 39, 40, 31};
		//double[] omzet = {567.70, 498.25, 458.90};
		//System.out.println(Administratie.berekenGemiddeldAantal(gem));
		//System.out.println(Administratie.berekenGemiddeldeOmzet(omzet));
		
		KantineSimulatie2 ks = new KantineSimulatie2();
		ks.simuleer(10);
		
    }
	
}