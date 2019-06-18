package me.mobieljoy;

public class Contant extends Betaalwijze {
    /**
     * Methode om betaling af te handelen
     */
    public void betaal(double tebetalen) throws TeWeinigGeldException {
        if(tebetalen <= this.saldo) {
        	this.saldo -= tebetalen;
        }else {
        	throw new TeWeinigGeldException("Onvoldoende Saldo.");
        }
    }
}
