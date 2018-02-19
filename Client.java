package Projet2AssuranceQualiteLogiciels;

import java.text.DecimalFormat;

public class Client {
	private String nom;
	private double montantFacture;
	private int nbCommande;
	private Plat platCommande;
	
	// Initialise avec le nom du client
	public Client(String nom) {
		this.nom = nom;
	}
	
	// Ajout du montant de la facture
	public void setMontantFacture(double montantFacture) {
		this.montantFacture = montantFacture;
	}
	
	// Ajout du plat commandé
	public void setPlatCommande(Plat platCommande) {
		this.platCommande = platCommande;
	}
	
	// Ajout du nom de plat commandé
	public void setNbCommande(int nbCommande) {
		this.nbCommande = nbCommande;
	}
	
	// Calcul du montant de la facture finale
	public void calculerMontantFacture() {
		montantFacture = nbCommande * platCommande.getPrix();
	}
	
	// Retourne le nom du client
	public String getNom() {
		return nom;
	}
	
	// Retourne le montant de la facture
	public double getMontantFacture() {
		return montantFacture;
	}

	// Génération de la chaîne de sortie pour ce client
	@Override
	public String toString() {
		DecimalFormat decimalFormat = new DecimalFormat("#.00");
		return nom + ' ' + decimalFormat.format(montantFacture) + "$" ;
	}
	
	
}
