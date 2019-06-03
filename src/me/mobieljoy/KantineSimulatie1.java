package me.mobieljoy;

public class KantineSimulatie1 {

    private Kantine kantine;

    public static final int DAGEN = 7;

    /**
     * Constructor
     */
    public KantineSimulatie1() {
        kantine = new Kantine();
    }

    /**
     * Deze methode simuleert een aantal dagen in het
     * verloop van de kantine
     *
     * @param dagen
     */
    public void simuleer(int dagen) {

    	// herhaal voor elke dag
        for(int i = 1; i <= dagen; i++) {

            // per dag nu even vast 10 + i personen naar binnen
            // laten gaan, wordt volgende week veranderd...

            // for lus voor personen
            for(int j = 0; j < 10 + i; j++){
                this.kantine.loopPakSluitAan();
            }

            // verwerk rij voor de kassa
            this.kantine.verwerkRijVoorKassa();

            // toon dagtotalen (artikelen en geld in kassa)
            Kassa k = this.kantine.getKassa();
            System.out.println("Dag " + i + " totalen:");
            System.out.println(k.aantalArtikelen()+" artikelen en "+k.hoeveelheidGeldInKassa()+" in de kassa");

            // reset de kassa voor de volgende dag
            this.kantine.getKassa().resetKassa();
        }
    }

    /**
     * Start een simulatie
     */
    public static void main(String[] args) {
        int dagen;

        if (args.length == 0) {
            dagen = DAGEN;
        } else {
            dagen = Integer.parseInt(args[0]);
        }

        KantineSimulatie1 ks = new KantineSimulatie1();
        ks.simuleer(dagen);
    }
}
