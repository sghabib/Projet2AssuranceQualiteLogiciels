package Projet2AssuranceQualiteLogiciels;

public class Main {
private static String cheminFichierImport = "fichiers/facture.txt";
private static String cheminFichierExport = "fichiers/factureSortie.txt";
	public static void main(String[] args) {
		Facture facture = new importerText(cheminFichierImport).getFacture();
		new exporterText(facture, cheminFichierExport);
	}

}
