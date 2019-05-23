package me.mobieljoy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class Dienblad {
    private ArrayList<Artikel> artikelen;
    private Persoon klant;

    /**
     * Constructor
     */
    public Dienblad() {
        this.artikelen = new ArrayList<Artikel>();
        this.klant = null;
    }
    
    public Dienblad(Persoon p) {
    	this.artikelen = new ArrayList<Artikel>();
    	this.klant = p;
    }

    /**
     * Methode om artikel aan dienblad toe te voegen
     *
     * @param artikel
     */
    public void voegToe(Artikel artikel) {
        this.artikelen.add(artikel);
    }

    /**
     * Methode om aantal artikelen op dienblad te tellen
     *
     * @return Het aantal artikelen
     */
    public int getAantalArtikelen() {
        return this.artikelen.size();
    }

    /**
     * Methode om de totaalprijs van de artikelen
     * op dienblad uit te rekenen
     *
     * @return De totaalprijs
     */
    public double getTotaalPrijs() {
        double totaal = 0.0;
        for(Artikel a : this.artikelen) {
        	totaal+=a.getPrijs();
        }
        return totaal;
    }

	public Persoon getKlant() {
		return klant;
	}

	public void setKlant(Persoon klant) {
		this.klant = klant;
	}
    
}


