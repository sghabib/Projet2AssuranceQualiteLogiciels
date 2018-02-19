package Projet2AssuranceQualiteLogiciels;

import java.io.ObjectInputStream;

public class importerText {
	private Facture facture;
	
	public  importerText(String cheminFichier) {
		
		ObjectInputStream fichier = OutilsFichier.ouvrirFicBinLecture(cheminFichier);
		
		
	
		// TODO À continuer par Philippe
	}
	
	public Facture getFacture() {
		return facture;
	}
}
