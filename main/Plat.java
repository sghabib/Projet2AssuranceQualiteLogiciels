package main;

public class Plat {
	private String nom;
	private double prix;

	// Initialise avec le nom du plat
	public Plat(String nom) {
		this.nom = nom;
	}

	// Ajout du prix du plat
	public void setPrix(double prix) {
		this.prix = prix;
	}

	// Retourne le nom du plat
	public String getNom() {
		return nom;
	}

	// Retourne le prix du plat
	public double getPrix() {
		return prix;
	}

}
