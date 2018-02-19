package Projet2AssuranceQualiteLogiciels;

import java.io.BufferedReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class importerText {
	private String cheminFichier;
	private Facture facture;
	
	public importerText(String cheminFichier) {
		this.cheminFichier = cheminFichier;
		
	
		
		// TODO À continuer par Philippe
	}
	
	public Facture getFacture() {
		return facture;
	}
}
