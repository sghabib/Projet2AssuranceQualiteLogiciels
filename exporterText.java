package Projet2AssuranceQualiteLogiciels;


import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class exporterText {
	private String cheminFichier;
	private Facture facture;
	
	public exporterText(Facture facture, String cheminFichier) {
		this.facture = facture;
		this.cheminFichier = cheminFichier;
		
		Path chemin = Paths.get(cheminFichier);
		
		try {
			
			BufferedWriter ficEcriture = Files.newBufferedWriter(chemin, Charset.defaultCharset());

			ficEcriture.write(facture.toString());
			
			ficEcriture.close();
		
		} catch (IOException e) {

			e.printStackTrace();
			
		}
		
		// TODO À continuer par Philippe
	}
}
