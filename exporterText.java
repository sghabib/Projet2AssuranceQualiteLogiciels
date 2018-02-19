package Projet2AssuranceQualiteLogiciels;

import java.io.ObjectOutputStream;

public class exporterText {
	private String cheminFichier;
	private Facture facture;
	
	public exporterText(Facture facture, String cheminFichier) {
		this.facture = facture;
		this.cheminFichier = cheminFichier;
		
		ObjectOutputStream fichier = OutilsFichier.ouvrirFicBinEcriture(cheminFichier);
		
		// TODO À continuer par Philippe
	}
}
