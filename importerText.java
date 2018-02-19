package Projet2AssuranceQualiteLogiciels;

public class importerText {
	private Facture facture;
	
	public  importerText(String cheminFichier) {
		
		OutilsFichier.ouvrirFicBinLecture(cheminFichier);
	
		
		// TODO À continuer par Philippe
	}
	
	public Facture getFacture() {
		return facture;
	}
}
