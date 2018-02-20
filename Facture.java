package Projet2AssuranceQualiteLogiciels;

import java.util.ArrayList;

public class Facture {
	private ArrayList<Client> listeClient = new ArrayList<>();

	private String facture = "Bienvenue chez Barette !\nFactures:\n";

	// Initialise d'abord une facture vide
	public Facture() {

	}

	public ArrayList<Client> getListeClient() {
		return listeClient;
	}

	// Ajoute un client à toutes les fois que nous en avons un
	public void addClient(Client client) {
		listeClient.add(client);
	}

	// Génère la chaîne de caractère du fichier de sortie
	public void genererFacture() {
		facture = "Bienvenue chez Barette !\nFactures:\n";
		for (Client client : listeClient) {
			facture = facture + client.toString() + "\n";
		}
	}

	// Afficher la facture à l'écran
	public void afficherFacture() {
		System.out.println(facture);
	}

	// Retourner la chaîne de caractère pour le fichier de sortie
	@Override
	public String toString() {
		return facture;
	}

	// Calcul du montant de la facture finale
	public static double calculerMontantFacture(Plat platCommande, int nbCommande) {
		return nbCommande * platCommande.getPrix();
	}

}
