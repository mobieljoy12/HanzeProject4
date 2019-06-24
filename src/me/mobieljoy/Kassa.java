package me.mobieljoy;

import java.time.LocalDate;
import java.util.Iterator;

import javax.persistence.EntityManager;

public class Kassa {

	private int totaalproducten;
	private double totaalverkochtprijs;
	private EntityManager manager;
	
    /**
     * Constructor
     */
    public Kassa(KassaRij kassarij, EntityManager manager) {
        this.totaalproducten = 0;
        this.totaalverkochtprijs = 0.0;
        this.manager = manager;
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
        
    		LocalDate today = LocalDate.now();
    	
    		try {
    			Factuur factuur = new Factuur(klant, today);
    			this.totaalproducten += factuur.getNumProducts();
                this.totaalverkochtprijs += factuur.getTotaalPrijs();
    		}catch(TeWeinigGeldException e) {
    			System.out.println("Kon Factuur niet opslaan: " + e.getMessage());
    		}
    		
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
