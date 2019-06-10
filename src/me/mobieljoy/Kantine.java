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
    public void loopPakSluitAan(Dienblad dienblad, String[] artikelnamen) {
        for(String s : artikelnamen) {
        	dienblad.voegToe(this.kantineAanbod.getArtikel(s));
        }
        this.kassarij.sluitAchteraan(dienblad);
    }

    /**
     * Deze methode handelt de rij voor de kassa af.
     */
    public void verwerkRijVoorKassa() {
    	while(kassarij.erIsEenRij()) {
            Dienblad dienblad = kassarij.eerstePersoonInRij();
            this.kassa.rekenAf(dienblad);
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
