package me.mobieljoy;

import java.math.BigDecimal;
import java.util.*;

public class KantineSimulatie2 {

    // kantine
    private Kantine kantine;

    // kantineaanbod
    private KantineAanbod kantineaanbod;

    // random generator
    private Random random;

    // aantal artikelen
    private static final int AANTAL_ARTIKELEN = 4;

    // artikelen
    private static final String[] artikelnamen = new String[]
        {"Koffie", "Broodje pindakaas", "Broodje kaas", "Appelsap"};

    // prijzen
    private static double[] artikelprijzen = new double[]{1.50, 2.10, 1.65, 1.65};

    // minimum en maximum aantal artikelen per soort
    private static final int MIN_ARTIKELEN_PER_SOORT = 10;
    private static final int MAX_ARTIKELEN_PER_SOORT = 20;

    // minimum en maximum aantal personen per dag
    private static final int MIN_PERSONEN_PER_DAG = 50;
    private static final int MAX_PERSONEN_PER_DAG = 100;

    // minimum en maximum artikelen per persoon
    private static final int MIN_ARTIKELEN_PER_PERSOON = 1;
    private static final int MAX_ARTIKELEN_PER_PERSOON = 4;

    /**
     * Constructor
     *
     */
    public KantineSimulatie2() {
        kantine = new Kantine();
        random = new Random();
        int[] hoeveelheden = getRandomArray(
            AANTAL_ARTIKELEN,
            MIN_ARTIKELEN_PER_SOORT,
            MAX_ARTIKELEN_PER_SOORT);
        kantineaanbod = new KantineAanbod(
            artikelnamen, artikelprijzen, hoeveelheden);

        kantine.setKantineAanbod(kantineaanbod);
    }

    /**
     * Methode om een array van random getallen liggend tussen
     * min en max van de gegeven lengte te genereren
     *
     * @param lengte
     * @param min
     * @param max
     * @return De array met random getallen
     */
    private int[] getRandomArray(int lengte, int min, int max) {
        int[] temp = new int[lengte];
        for(int i = 0; i < lengte ;i++) {
            temp[i] = getRandomValue(min, max);
        }

        return temp;
    }

    /**
     * Methode om een random getal tussen min(incl)
     * en max(incl) te genereren.
     *
     * @param min
     * @param max
     * @return Een random getal
     */
    private int getRandomValue(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }
    
    /**
     * Methode om op basis van een array van indexen voor de array
     * artikelnamen de bijhorende array van artikelnamen te maken
     *
     * @param indexen
     * @return De array met artikelnamen
     */
    private String[] geefArtikelNamen(int[] indexen) {
        String[] artikelen = new String[indexen.length];

        for(int i = 0; i < indexen.length; i++) {
            artikelen[i] = artikelnamen[indexen[i]];

        }

        return artikelen;
    }
    
    /**
     * Deze methode simuleert een aantal dagen
     * in het verloop van de kantine
     *
     * @param dagen
     */
    public void simuleer(int dagen) {
        // for lus voor dagen
    	int[] aantal = new int[dagen];
    	double[] omzet = new double[dagen];
        for(int i = 0; i < dagen; i++) {

            // bedenk hoeveel personen vandaag binnen lopen
        	ArrayList<Persoon> personen = new ArrayList<Persoon>();
        	for(int j=0;j<89;j++) {
				Persoon persoon = new Student(12365478, "Jasper", "van der Kooi", new Datum(22,04,2000), 'M',123456,"HBO-ICT");
				personen.add(persoon);
				System.out.println(persoon.toString());
			}
			for(int j=0;j<10;j++) {
				Persoon persoon = new Docent(12365478, "Rick", "Schoustra", new Datum(12,2,2000), 'M',"ABCD","SCMI");
				personen.add(persoon);
				System.out.println(persoon.toString());
			}
			Persoon persoon = new KantineMedewerker(12365478, "Jan", "Janus", new Datum(11,12,1990), 'M',987654,true);
			personen.add(persoon);
			System.out.println(persoon.toString());
            // laat de personen maar komen...
            for(int j = 0; j < 100; j++) {

                // maak persoon en dienblad aan, koppel ze
                // en bedenk hoeveel artikelen worden gepakt
                Dienblad klant = new Dienblad();
                persoon = personen.get(j);
                klant.setKlant(persoon);
            	int aantalartikelen = this.getRandomValue(MIN_ARTIKELEN_PER_PERSOON, MAX_ARTIKELEN_PER_PERSOON);

                // genereer de "artikelnummers", dit zijn indexen
                // van de artikelnamen
                int[] tepakken = getRandomArray(
                    aantalartikelen, 0, AANTAL_ARTIKELEN-1);

                // vind de artikelnamen op basis van
                // de indexen hierboven
                String[] artikelen = geefArtikelNamen(tepakken);

                // loop de kantine binnen, pak de gewenste
                // artikelen, sluit aan
                this.kantine.loopPakSluitAan(klant, artikelen);
            }

            // verwerk rij voor de kassa
            this.kantine.verwerkRijVoorKassa();
            // druk de dagtotalen af en hoeveel personen binnen
            // zijn gekomen
            Kassa k = this.kantine.getKassa();
            BigDecimal hoeveelheidinkassa = new BigDecimal(k.hoeveelheidGeldInKassa()).setScale(2, BigDecimal.ROUND_HALF_UP);
            int dagdisplay = i+1;
            System.out.println("Dag " + dagdisplay + ": " + k.aantalArtikelen() + " artikelen, " + hoeveelheidinkassa + " in de kassa");
            omzet[i] = k.hoeveelheidGeldInKassa();
            aantal[i] = k.aantalArtikelen();
            // reset de kassa voor de volgende dag
            k.resetKassa();
        }
        System.out.println("Gemiddelde omzet: " + Administratie.berekenGemiddeldeOmzet(omzet));
        System.out.println("Gemiddeld aantal producten: " + Administratie.berekenGemiddeldAantal(aantal));
    }
    
    public void simuleerRandom(int dagen) {
    	// for lus voor dagen
    	int[] aantal = new int[dagen];
    	double[] omzet = new double[dagen];
    	for(int i=0;i<dagen;i++) {
    		int aantalpersonen=getRandomValue(MIN_PERSONEN_PER_DAG, MAX_PERSONEN_PER_DAG);
    		for(int j=0;j<aantalpersonen;j++) {
    			int r=random.nextInt(100);
    			Persoon persoon;
    			if(r<89){
    				persoon = new Student(12365478, "Jasper", "van der Kooi", new Datum(22,04,2000), 'M',123456,"HBO-ICT");
    			} else if(r<99){
    				persoon = new Docent(12365478, "Rick", "Schoustra", new Datum(12,2,2000), 'M',"ABCD","SCMI");
    			} else {
    				persoon = new KantineMedewerker(12365478, "Jan", "Janus", new Datum(11,12,1990), 'M',987654,true);
    			}
    			Dienblad klant = new Dienblad();
    			klant.setKlant(persoon);
    			int aantalartikelen=getRandomValue(MIN_ARTIKELEN_PER_PERSOON,MAX_ARTIKELEN_PER_PERSOON);
    			int[] tepakken=getRandomArray(aantalartikelen, 0, AANTAL_ARTIKELEN-1);
    			String[] artikelen=geefArtikelNamen(tepakken);
    			kantine.loopPakSluitAan(klant, artikelen);
    		}
    		kantine.verwerkRijVoorKassa();
    		Kassa kassa = kantine.getKassa();
            BigDecimal hoeveelheidinkassa = new BigDecimal(k.hoeveelheidGeldInKassa()).setScale(2, BigDecimal.ROUND_HALF_UP);
            int dagdisplay = i + 1;
    		System.out.println("Dag " + dagdisplay + ": " + k.aantalArtikelen() + " artikelen, " + hoeveelheidinkassa + " in de kassa");
            omzet[i] = kassa.hoeveelheidGeldInKassa();
            aantal[i] = kassa.aantalArtikelen();
    		kassa.resetKassa();
    	}
    	System.out.println("Gemiddelde omzet: " + Administratie.berekenGemiddeldeOmzet(omzet));
        System.out.println("Gemiddeld aantal producten: " + Administratie.berekenGemiddeldAantal(aantal));
    }
    
}
