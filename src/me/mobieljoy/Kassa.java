package me.mobieljoy;

import java.util.Iterator;

public class Kassa {

	private KassaRij kassarij;
	private int totaalproducten;
	private double totaalverkochtprijs;
	
    /**
     * Constructor
     */
    public Kassa(KassaRij kassarij) {
        this.kassarij = kassarij;
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
    	Double totaalprijs = klant.getTotaalPrijs();
        int aantal = klant.getAantalArtikelen();
        this.totaalproducten+=aantal;
        this.totaalverkochtprijs+=totaalprijs;
    }

    /**
     * Geeft het aantal artikelen dat de kassa heeft gepasseerd,
     * vanaf het moment dat de methode resetWaarden is aangeroepen.
     *
     * @return aantal artikelen
     */
    public int aantalArtikelen() {
        return this.aantalArtikelen();
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
