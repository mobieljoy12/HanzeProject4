package me.mobieljoy;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "regel")
public class FactuurRegel implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@JoinColumn(name = "factuur_id")
	private Factuur factuur;
	
	@Embedded
	private Artikel artikel;
	
	public FactuurRegel() {
		
	}
	
	public FactuurRegel(Factuur factuur, Artikel artikel) {
		this.factuur = factuur;
		this.artikel = artikel;
	}
	
	public String toString() {
		return "";
	}
	
}
