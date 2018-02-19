package Projet2AssuranceQualiteLogiciels;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class importerText {
	private Facture facture;
	private List<Plat> listePlats;
	
	public  importerText(String cheminFichier) {
		
		String ligne = "";
		
		int categorie = -1;
		
		this.facture = new Facture();
		
		this.listePlats = new ArrayList<>();
		
		try {
			
			BufferedReader lecture = new BufferedReader( new FileReader( cheminFichier ) );
			
			while( ( ligne = lecture.readLine() ) != null)  {
				
				//System.out.println( ligne );
				
				if (ligne.equals("Clients :")) {
					
					categorie = 1;
					
				} else if (ligne.equals("Plats :")) {
					
					categorie = 2;
					
				} else if (ligne.equals("Commandes :")) {
					
					categorie = 3;
					
				} else if (ligne.equals("Fin")) {
					
					break;
					
				} else {
					
					if (categorie == 1) {
						
						this.facture.addClient( new Client( ligne ) );
						
					} else if(categorie == 2) {
						
						Plat plat = new Plat(ligne.split(" ")[0]);
						
						plat.setPrix(Double.parseDouble(ligne.split(" ")[1]));
						
						this.listePlats.add(plat);

					} else if(categorie == 3) {
						
						// test de départ
						if(ligne.split(" ").length != 3) {
							throw new Exception("Le fichier ne respecte pas le format demandé !");
						}
						
						
						String nomClient = ligne.split(" ")[0];
						String nomPlat = ligne.split(" ")[1];
						String quantiteTemp = ligne.split(" ")[2];
						int quantite;
						
						quantite = Integer.parseInt(quantiteTemp);
						
						int indiceClient = -1;
						int indcePlat = -1;
						
						for (int i = 0; i < this.facture.getListeClient().size(); i++) {
							if(this.facture.getListeClient().get(i).getNom().equals(nomClient)) {
								indiceClient = i;
								break;
							}
						}
						
						for (int i = 0; i < this.listePlats.size(); i++) {
							if(this.listePlats.get(i).getNom().equals(nomPlat)) {
								indcePlat = i;
								break;
							}
						}
						
						if(indiceClient != -1) {
							
							if(indcePlat != -1) {
								
								double montantFacture = this.facture.getListeClient().get(indiceClient).getMontantFacture();
								
								montantFacture += Facture.calculerMontantFacture(this.listePlats.get(indcePlat), quantite);
								
								this.facture.getListeClient().get(indiceClient).setMontantFacture(montantFacture);
								
							}else {
								throw new Exception("Plat n'existe pas");
							}
							
						}else {
							throw new Exception("Client n'existe pas");
						}
						
					}
					
				}
			
			}
			
			lecture.close();
			
			this.facture.genererFacture();
			this.facture.afficherFacture();
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		
		}
		
		
		// TODO À continuer par Philippe
	}
	
	public Facture getFacture() {
		return facture;
	}
}
