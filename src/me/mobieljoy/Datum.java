package me.mobieljoy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Datum {

	private int dag;
	private int maand;
	private int jaar;

	public Datum(int dag, int maand, int jaar) {
		this();
		if(this.bestaatDatum(dag, maand, jaar)){
			this.dag = dag;
			this.maand = maand;
			this.jaar = jaar;
		}
	}
	
	public Datum() {
		this.dag = 0;
		this.maand = 0;
		this.jaar = 0;
	}
	
	public boolean bestaatDatum(int dag, int maand, int jaar){
		boolean toreturn = true;
		//Basis Checks
		if(maand < 1 || maand > 12) {
			toreturn = false;
		}
		if(jaar < 1990 || jaar > 2100) {
			toreturn = false;
		}
		if(toreturn) { //Niet nodig om de rest te checken als de getallen niet goed zijn
			//Schrikkeljaren
			int schrikkelJaarDagen = 28;
			if(jaar % 4 == 0) {
				if(jaar % 100 == 0) {
					if(jaar % 400 == 0) {
						schrikkelJaarDagen = 29;
					}
				}else {
					schrikkelJaarDagen = 29;
				}
			}
			List<Integer> dagen = Arrays.asList(1,3,5,7,8,10,12);
			ArrayList<Integer> dagen30 = new ArrayList<Integer>();
			dagen30.addAll(dagen);
			if(dagen30.contains(maand)) {
				if(dag < 1 || dag > 31) {
					toreturn = false;
				}
			}else if(maand == 2) {
				if(dag < 1 || dag > schrikkelJaarDagen) {
					toreturn = false;
				}
			}else {
				if(dag < 1 || dag > 30) {
					toreturn = false;
				}
			}
		}
		return toreturn;
	}
	
	/**
	 * Getter voor Sting weergave van datum
	 * @return Geboortedatum
	 */
	public String getDatumAsString() {
		return dag+" "+maand+" "+jaar;
		}
	public int getDag() {
		return dag;
	}

	public void setDag(int dag) {
		this.dag = dag;
	}

	public int getMaand() {
		return maand;
	}

	public void setMaand(int maand) {
		this.maand = maand;
	}

	public int getJaar() {
		return jaar;
	}

	public void setJaar(int jaar) {
		this.jaar = jaar;
	}
}

