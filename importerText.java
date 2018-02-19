package Projet2AssuranceQualiteLogiciels;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class importerText {
	private Facture facture;
	
	public  importerText(String cheminFichier) {
		
		File file = new File( cheminFichier );
		
		try {
			
			BufferedReader lecture = new BufferedReader( new FileReader( cheminFichier ) );
			
		} catch (Exception e) {
			
			
		
		}
		
		
		// TODO À continuer par Philippe
	}
	
	public Facture getFacture() {
		return facture;
	}
}
