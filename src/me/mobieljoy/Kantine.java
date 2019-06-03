package me.mobieljoy;

public class Kantine {

    private Kassa kassa;
    private KassaRij kassarij;
    private KantineAanbod kantineAanbod;

    /**
     * Constructor
     */
    public Kantine() {
        this.kassarij = new KassaRij();
        this.kassa = new Kassa(kassarij);
    }

    /**
     * In deze methode wordt een Persoon en Dienblad gemaakt
     * en aan elkaar gekoppeld. Maak twee Artikelen aan
     * en plaats deze op het dienblad. Tenslotte sluit de
     * Persoon zich aan bij de rij voor de kassa.
     */
    public void loopPakSluitAan(Persoon persoon, String[] artikelnamen) {
        Dienblad d = new Dienblad();
        d.setKlant(persoon);
        for(String s : artikelnamen) {
        	d.voegToe(this.kantineAanbod.getArtikel(s));
        }
        this.kassarij.sluitAchteraan(d);
    }

    /**
     * Deze methode handelt de rij voor de kassa af.
     */
    public void verwerkRijVoorKassa() {
    	while(kassarij.erIsEenRij()) {
            Dienblad d = kassarij.eerstePersoonInRij();
            this.kassa.rekenAf(d);
        }
    }

    //Getters
	public Kassa getKassa() {
		return kassa;
	}

	public KantineAanbod getKantineAanbod() {
		return kantineAanbod;
	}

	public void setKantineAanbod(KantineAanbod kantineAanbod) {
		this.kantineAanbod = kantineAanbod;
	}
    
}
