package main;

import java.io.IOException;

public class Main {
	private static String cheminFichierImport = "src/main/fichiers/facture.txt";
	private static String cheminFichierExport = "src/main/fichiers/Facture-du-";

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
