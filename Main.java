package Projet2AssuranceQualiteLogiciels;


public class Main {
private static String cheminFichierImport = "fichiers/facture.txt";
	public static void main(String[] args) {
		Facture facture = new importerText(cheminFichierImport).getFacture();
	}

}
