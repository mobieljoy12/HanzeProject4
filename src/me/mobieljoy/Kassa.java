package me.mobieljoy;

import java.util.Iterator;

public class Kassa {

	private int totaalproducten;
	private double totaalverkochtprijs;
	
    /**
     * Constructor
     */
    public Kassa(KassaRij kassarij) {
        this.totaalproducten = 0;
        this.totaalverkochtprijs = 0.0;
    }

    /**
     * Vraag het aantal artikelen en de totaalprijs op.
     * Tel deze gegevens op bij de controletotalen die voor
     * de kassa worden bijgehouden. De implementatie wordt
     * later vervangen door een echte betaling door de persoon.
     *
     * @param klant die moet afrekenen
     */
    public void rekenAf(Dienblad klant) {
        Iterator<Artikel> artikelen = klant.getArtikelen();
        Persoon persoon = klant.getKlant();
        int numproducten = 0;
        double afrekenprijs = 0.0;
        while(artikelen.hasNext()) {
        	Artikel a = artikelen.next();
        	numproducten++;
        	afrekenprijs += a.getPrijs();
        }
        	
        	double kortingPerc = 0.0;
        	boolean heeftMax = false;
        	double maxKorting = 0;
        
        	if(persoon instanceof Docent) {
        		kortingPerc = ((Docent) persoon).geefKortingsPercentage();
        		heeftMax = ((Docent) persoon).heeftMaximum();
        		maxKorting = ((Docent) persoon).geefMaximum();
        	}else if(persoon instanceof KantineMedewerker) {
        		kortingPerc = ((KantineMedewerker) persoon).geefKortingsPercentage();
        		heeftMax = ((KantineMedewerker) persoon).heeftMaximum();
        		maxKorting = ((KantineMedewerker) persoon).geefMaximum();
        	}
        	
        	double korting = afrekenprijs - (afrekenprijs * kortingPerc);
        	
        	if(heeftMax) {
        		if(korting > maxKorting) {
        			afrekenprijs -= maxKorting;
        		}else {
        			afrekenprijs -= korting;
        		}
        	}else {
        		afrekenprijs -= korting;
        	}
        	try {
        		persoon.getBetaalwijze().betaal(afrekenprijs);
        	}catch(TeWeinigGeldException e){
        		System.out.println(persoon.getVoornaam() + " " + persoon.getAchternaam() + " kon niet betalen. Reden: " + e.getMessage());
        		return;
        	}
        	
        	this.totaalproducten += numproducten;
            this.totaalverkochtprijs += afrekenprijs;
    }

    /**
     * Geeft het aantal artikelen dat de kassa heeft gepasseerd,
     * vanaf het moment dat de methode resetWaarden is aangeroepen.
     *
     * @return aantal artikelen
     */
    public int aantalArtikelen() {
        return this.totaalproducten;
    }

    /**
     * Geeft het totaalbedrag van alle artikelen die de kass
     * zijn gepasseerd, vanaf het moment dat de methode
     * resetKassa is aangeroepen.
     *
     * @return hoeveelheid geld in de kassa
     */
    public double hoeveelheidGeldInKassa() {
        return this.totaalverkochtprijs;
    }

    /**
     * reset de waarden van het aantal gepasseerde artikelen en
     * de totale hoeveelheid geld in de kassa.
     */
    public void resetKassa() {
        this.totaalproducten = 0;
        this.totaalverkochtprijs = 0.0;
    }
}
