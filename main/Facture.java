package main;

import java.util.ArrayList;

public class Facture {
	private ArrayList<Client> listeClient = new ArrayList<>();

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

	// Afficher la facture à l'écran
	public void afficherFacture() {
		System.out.println(this.toString());
	}

	// Retourner la chaîne de caractère pour le fichier de sortie
	@Override
	public String toString() {
		String facture = "Bienvenue chez Barette !\nFactures:\n";
		for (Client client : listeClient) {
			if(client.toString() != "")
				facture = facture + client.toString() + "\n";
		}
		return facture;
	}

	// Calcul du montant de la facture finale
	public static double calculerMontantFacture(Plat platCommande, int nbCommande) {
		return nbCommande * calculerTotalAvecTaxes(platCommande.getPrix());
	}
	
	// Calcul des taxes (TPS 5% et TVQ 10%)
	public double calculerTaxes(double prix) {
		return prix * 0.05 + prix * 0.10;
	}
	
	// Calcul du total avec les taxes
	public double calculerTotalAvecTaxes(double prix) {
		return prix + calculerTaxes(prix);
	}

}
