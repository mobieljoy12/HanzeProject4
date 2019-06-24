package me.mobieljoy;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import me.mobieljoy.FactuurRegel;

import java.io.Serializable;

@Entity(name = "factuur")
@Table(name = "factuur")
@NamedQueries({
	@NamedQuery(name = "Factuur.totaal", query = "SELECT SUM(totaal), SUM(korting) FROM factuur"),
	@NamedQuery(name = "Factuur.gemiddelde", query = "SELECT AVG(totaal), AVG(korting) FROM factuur"),
	@NamedQuery(name = "Factuur.topdrie", query = "SELECT totaal, korting FROM factuur ORDER BY totaal DESC")
})
public class Factuur implements Serializable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private LocalDate datum;
	@Column(name = "korting")
	private double korting;
	@Column(name = "totaal")
	private double totaal;
	@Column(name = "numproducts")
	private int numproducts;
	@JoinTable(name = "factuur_regel", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "regel_id"))
    private List<FactuurRegel> regels;
	

	public Factuur() {
		this.totaal = 0;
		this.korting = 0;
		this.regels = new ArrayList<FactuurRegel>();
	}
	
	
	public Factuur(Dienblad klant, LocalDate datum) throws TeWeinigGeldException {
		this();
		
		this.datum = datum;
		
		verwerkBestelling(klant);
	}
	
	private void verwerkBestelling(Dienblad klant) throws TeWeinigGeldException {
		Iterator<Artikel> artikelen = klant.getArtikelen();
        Persoon persoon = klant.getKlant();
        double afrekenprijs = 0.0;
        while(artikelen.hasNext()) {
        	Artikel artikel = artikelen.next();
        	this.numproducts++;
        	afrekenprijs += artikel.getPrijs();
        	this.regels.add(new FactuurRegel(this, artikel));
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
        		throw new TeWeinigGeldException(e.getMessage());
        	}
        	
            this.totaal = afrekenprijs;
            this.korting = korting;
	}
	
	public double getTotaal() {
		return this.totaal;
	}
	
	public double getKorting() {
		return this.korting;
	}
	
	public double getTotaalPrijs() {
		return this.totaal;
	}
	
	public int getNumProducts() {
		return this.numproducts;
	}
	
	public String toString() {
		String rg = "";
		for(FactuurRegel fr : this.regels) {
			rg = rg + fr.toString() + "\n";
		}
		return "Prijs: " + this.totaal + ", Korting: " + this.korting + "Regels:" + rg;
	}
}