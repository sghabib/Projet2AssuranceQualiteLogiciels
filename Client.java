package Projet2AssuranceQualiteLogiciels;

import java.text.DecimalFormat;
import java.util.Currency;

public class Client {
	private String nom;
	private double montantFacture;
	
	public Client(String nom, double montantFacture) {
		this.nom = nom;
		this.montantFacture = montantFacture;
	}
	
	public String getNom() {
		return nom;
	}
	
	public double getMontantFacture() {
		return montantFacture;
	}

	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat ( ) ; 
		return nom + ' ' + df.setCurrency(Currency.getInstance("ISO 124")); ;
	}
	
	
}
