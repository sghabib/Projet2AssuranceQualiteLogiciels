package Projet2AssuranceQualiteLogiciels;

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
}
