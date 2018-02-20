package Projet2AssuranceQualiteLogiciels;

import java.io.IOException;

public class Main {
	private static String cheminFichierImport = "src/Projet2AssuranceQualiteLogiciels/fichiers/facture.txt";
	private static String cheminFichierExport = "src/Projet2AssuranceQualiteLogiciels/fichiers/factureSortie.txt";

	public static void main(String[] args) {
		Facture facture;
		try {
			facture = new importerText(cheminFichierImport).getFacture();
			new exporterText(facture, cheminFichierExport);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
