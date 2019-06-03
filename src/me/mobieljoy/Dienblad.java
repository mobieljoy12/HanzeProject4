package me.mobieljoy;

import java.util.Iterator;
import java.util.Stack;

public class Dienblad {
    private Stack<Artikel> artikelen;
    private Persoon klant;

    /**
     * Constructor
     */
    public Dienblad() {
        this.artikelen = new Stack<Artikel>();
        this.klant = null;
    }
    
    public Dienblad(Persoon p) {
    	this.artikelen = new Stack<Artikel>();
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

    public Iterator<Artikel> getArtikelen(){
    	return this.artikelen.iterator();
    }

	public Persoon getKlant() {
		return klant;
	}

	public void setKlant(Persoon klant) {
		this.klant = klant;
	}
    
}


