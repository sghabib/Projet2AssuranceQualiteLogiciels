package main;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class exporterText {

	public exporterText(Facture facture, String cheminFichier) {

		DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy-HH:mm");
		DateTime dt = formatter.parseDateTime(string);
		
		Path chemin = Paths.get(cheminFichier + dt + ".txt");

		try {

			BufferedWriter ficEcriture = Files.newBufferedWriter(chemin, Charset.defaultCharset());

			ficEcriture.write(facture.toString());

			ficEcriture.close();

		} catch (IOException e) {

			e.printStackTrace();

		}
	}
}
