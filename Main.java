package Projet2AssuranceQualiteLogiciels;

public class Main {
private static String cheminFichierImport = "src/Projet2AssuranceQualiteLogiciels/fichiers/facture.txt";
private static String cheminFichierExport = "src/Projet2AssuranceQualiteLogiciels/fichiers/factureSortie.txt";
	public static void main(String[] args) {
		Facture facture = new importerText(cheminFichierImport).getFacture();
		new exporterText(facture, cheminFichierExport);
	}

}
