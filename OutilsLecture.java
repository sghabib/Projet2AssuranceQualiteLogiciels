/**
 * Auteure : Soti
 * Fichier : OutilsLecture.java
 * Package : outilsjava
 * Date    : Hiver 2017
 * Cours   : Programmation avec Java
 */

// La classe OutilsLecture fait partie du package outilsjava.

package Projet2AssuranceQualiteLogiciels;

// Package du syst�me.
import java.io.*;

/**
 * Classe qui contient certaines m�thodes utilitaires de lecture.
 */

public class OutilsLecture {
	// Constantes pour les types de lecture.
	public static final char LECTURE_CLAVIER = 'C';
	public static final char LECTURE_FICHIER = 'F';

	// Nom logique du fichier. Par d�faut, lecture du clavier.
	public static BufferedReader fic = 
			new BufferedReader( new InputStreamReader( System.in ) );
	
	// Type de Lecture. Par d�faut, lecture du clavier.
	public static char type = LECTURE_CLAVIER;

	/**
	 * On d�finit le constructeur private pour emp�cher la cr�ation d'instances
	 * de la classe OutilsLecture.
	 */
	
	private OutilsLecture() {
	}
	
	/**
	 * La m�thode publique lireEntree() permet d'afficher une question et
	 * de lire seulement la touche Entr�e du clavier.
	 * 
	 * @param question
	 *            La question � afficher.
	 */

	public static void lireEntree( String question ) {
		String chaine;
		boolean valide;
		int lgChaine;

		do {
			valide = true;
			System.out.print( question );

			try {
				// Peut lire la touche Entree du fichier texte des jeux d'essai
				// ou du clavier.
				chaine = fic.readLine();

				if ( type == LECTURE_FICHIER ) {
					// Si lecture du fichier texte, on l'affiche sur la console.
					System.out.println(chaine);
				}

				lgChaine = chaine.length();

				// Erreur, si la cha�ne lue n'est pas vide.

				if ( lgChaine > 0 ) {
					System.out.println( "\nErreur, appuyez sur la touche "
							+ "Entr�e seulement." );
					valide = false;
				}
			}

			catch ( IOException errIO ) {
				System.out.println( "\nUne erreur d'entr�e-sortie" +
						" est survenue." );
				valide = false;
			}

			catch ( Exception err ) {
				System.out.println( "\nUne erreur de lecture est survenue." );
				valide = false;
			}
		} while ( !valide );
	}

	/**
	 * La m�thode publique lireChaine() permet d'afficher une question et de
	 * lire une cha�ne de caract�res quelconque.
	 * 
	 * @param question
	 *            La question � afficher.
	 * @return La cha�ne de caract�res lue.
	 */

	public static String lireChaine( String question ) {
		String chaine = "";
		boolean valide;
		int lgChaine;

		do {
			valide = true;
			System.out.print( question );

			try {
				// Peut lire une cha�ne du fichier texte des jeux d'essai
				// ou du clavier.
				chaine = fic.readLine();
				
				if ( type == LECTURE_FICHIER ) {
					// Si lecture du fichier texte, on l'affiche sur la console.
					System.out.println(chaine);
				}

				lgChaine = chaine.length();

				// Erreur, si la cha�ne lue est vide.

				if ( lgChaine == 0 ) {
					System.out.println( "\nErreur, l'entr�e ne doit pas" +
							" �tre vide." );
					valide = false;
				}
			}

			catch ( IOException errIO ) {
				System.out.println( "\nUne erreur d'entr�e-sortie" +
						" est survenue." );
				valide = false;
			}

			catch ( Exception err ) {
				System.out.println( "\nUne erreur de lecture est survenue." );
				valide = false;
			}
		} while ( !valide );

		return chaine;
	}

	/**
	 * La m�thode publique lireChaineValide() permet d'afficher une question et
	 * de lire une cha�ne de caract�res dont la longueur fait partie d'un
	 * intervalle.
	 * 
	 * @param question
	 *            La question � afficher.
	 * @param nbMinCar
	 *            Le nombre minimum de caract�res � lire.
	 * @param nbMaxCar
	 *            Le nombre maximum de caract�res � lire.
	 * @return La cha�ne de caract�res lue.
	 */

	public static String lireChaineValide( String question,
										   int nbMinCar, int nbMaxCar ) {
		String chaine = "";
		boolean valide;
		int lgChaine;

		do {
			valide = true;

			chaine = OutilsLecture.lireChaine( question );
			lgChaine = chaine.length();

			// Erreur, si le nombre de caract�res de la cha�ne lue
			// n'est pas entre nbMinCar et nbMaxCar.

			if ( lgChaine < nbMinCar || lgChaine > nbMaxCar ) {
				System.out.println( "\nErreur, entrez entre " + nbMinCar +
						" et " + nbMaxCar + " caract�res." );
				valide = false;
			}
		} while ( !valide );

		return chaine;
	}

	/**
	 * La m�thode publique lireChaineExacte() permet d'afficher une question et
	 * de lire une cha�ne de caract�res d'une certaine longueur.
	 * 
	 * @param question
	 *            La question � afficher.
	 * @param nbCar
	 *            Le nombre exact de caract�res � lire.
	 * @return La cha�ne de caract�res lue.
	 */

	public static String lireChaineExacte( String question, int nbCar ) {
		String chaine = "";
		boolean valide;
		int lgChaine;

		do {
			valide = true;

			chaine = OutilsLecture.lireChaine( question );
			lgChaine = chaine.length();

			// Erreur, si le nombre de caract�res de la cha�ne lue
			// n'est pas exactement nbCar.

			if ( lgChaine != nbCar ) {
				System.out.println( "\nErreur, entrez exactement " + nbCar
						+ " caract�res." );
				valide = false;
			}
		} while ( !valide );

		return chaine;
	}

	/**
	 * La m�thode publique lireCaractere() permet d'afficher une question et de
	 * lire un caract�re quelconque.
	 * 
	 * @param question
	 *            La question � afficher.
	 * @return Le caract�re lu.
	 */

	public static char lireCaractere( String question ) {
		String chaine = "";
		boolean valide;
		int lgChaine;

		do {
			valide = true;
			chaine = OutilsLecture.lireChaine( question );
			lgChaine = chaine.length();

			// Erreur, si le nombre de caract�res de la cha�ne lue
			// n'est pas exactement 1.
			
			if ( lgChaine != 1 ) {
				System.out.println( "\nErreur, entrez un seul caract�re." );
				valide = false;
			}
		} while ( !valide );

		// Retourne le premier caract�re de la cha�ne lue.
		return chaine.charAt( 0 );
	}

	/**
	 * La m�thode publique lireOuiNon() permet d'afficher une question et de
	 * lire une r�ponse O ou N de l'utilisateur.
	 * 
	 * @param question
	 *            La question � afficher.
	 * @return Le caract�re O ou N en majuscule.
	 */

	public static char lireOuiNon( String question ) {
		final char OUI = 'O';
		final char NON = 'N';
		
		char rep = '\0';  // Caract�re nul (vide).
		boolean valide;

		do {
			valide = true;

			// Convertir le caract�re lu en majuscule.
			rep = Character.toUpperCase(
					OutilsLecture.lireCaractere( question ) );

			// Erreur, si le caract�re lu n'est pas O ou N.
			
			if ( rep != OUI && rep != NON ) {
				System.out.println( "\nErreur, r�pondez par " + OUI + " ou "
						+ NON + " seulement." );
				valide = false;
			}
		} while ( !valide );

		return rep;
	}

	/**
	 * La m�thode publique lireCaractereValide() permet d'afficher une question
	 * et de lire un caract�re qui fait partie d'un intervalle.
	 * 
	 * @param question
	 *            La question � afficher.
	 * @param carMin
	 *            Le caract�re minimum.
	 * @param carMax
	 *            Le caract�re maximum.
	 * @return Le caract�re lu en majuscule.
	 */

	public static char lireCaractereValide( String question,
										    char carMin, char carMax ) {
		char rep = '\0';  // Caract�re nul (vide).
		boolean valide;

		// Convertir carMin et carMax en majuscules.
		carMin = Character.toUpperCase( carMin );
		carMax = Character.toUpperCase( carMax );

		do {
			valide = true;

			// Convertir le caract�re lu en majuscule.
			rep = Character.toUpperCase(
					OutilsLecture.lireCaractere( question ) );

			// Erreur, si le caract�re lu n'est pas entre carMin et carMax.

			if ( rep < carMin || rep > carMax ) {
				System.out.println( "\nErreur, entrez un caract�re entre "
						+ carMin + " et " + carMax + "." );
				valide = false;
			}
		} while ( !valide );

		return rep;
	}

	/**
	 * La m�thode publique lireCaractereDisparate() permet d'afficher une
	 * question et de lire un caract�re qui fait partie d'une certaine cha�ne
	 * de caract�res.
	 * 
	 * @param question
	 *            La question � afficher.
	 * @param carPossibles
	 *            La cha�ne de caract�res qui contient les diff�rents
	 *            caract�res que l'on peut lire.
	 * @return Le caract�re lu en majuscule.
	 */

	public static char lireCaractereDisparate( String question,
											   String carPossibles ) {
		char rep = '\0';  // Caract�re nul (vide).
		boolean valide;

		// Convertir les caract�res possibles en majuscules.
		carPossibles = carPossibles.toUpperCase();

		do {
			valide = true;

			// Convertir le caract�re lu en majuscule.
			rep = Character.toUpperCase(
					OutilsLecture.lireCaractere( question ) );

			// Erreur, si le caract�re lu ne fait pas partie des car. possibles.
			
			if ( carPossibles.indexOf( rep ) == -1 ) {
				System.out.println("\nErreur, entrez un caract�re parmi les "
						+ "suivants : " + carPossibles + ".");
				valide = false;
			}
		} while ( !valide );

		return rep;
	}

	/**
	 * La m�thode publique lireEntier() permet d'afficher une question et de
	 * lire un nombre entier quelconque.
	 * 
	 * @param question
	 *            La question � afficher.
	 * @return Le nombre entier lu.
	 */

	public static int lireEntier( String question ) {
		String chaine = "";
		boolean valide;
		int nombreLu = 0;
		
		do {
			valide = true;

			chaine = OutilsLecture.lireChaine( question );

			try {
				nombreLu = Integer.parseInt( chaine );
			}

			catch ( NumberFormatException errFormat ) {
				System.out.println( "\nErreur de formatage, " +
						"entrez un nombre entier." );
				valide = false;
			}
		} while ( !valide );

		return nombreLu;
	}

	/**
	 * La m�thode publique lireEntierValide() permet d'afficher une question et
	 * de lire un nombre entier qui fait partie d'un intervalle.
	 * 
	 * @param question
	 *            La question � afficher.
	 * @param min
	 *            Le nombre minimum.
	 * @param max
	 *            Le nombre maximum.
	 * @return Le nombre entier lu.
	 */

	public static int lireEntierValide( String question, int min, int max ) {
		int nombreLu = 0;
		boolean valide;

		do {
			valide = true;

			nombreLu = OutilsLecture.lireEntier( question );
			
			// Erreur, si le nombre lu n'est pas entre min et max.

			if ( nombreLu < min || nombreLu > max ) {
				System.out.println( "\nErreur, entrez un nombre entier entre "
						+ min + " et " + max + "." );
				valide = false;
			}
		} while ( !valide );

		return nombreLu;
	}

	/**
	 * La m�thode publique lireReel() permet d'afficher une question et de lire
	 * un nombre r�el quelconque.
	 * 
	 * @param question
	 *            La question � afficher.
	 * @return Le nombre r�el lu.
	 */

	public static double lireReel( String question ) {
		String chaine = "";
		boolean valide;
		double nombreLu = 0;
		
		do {
			valide = true;

			chaine = OutilsLecture.lireChaine( question );

			try {
				nombreLu = Double.parseDouble( chaine );
			}

			catch ( NumberFormatException errFormat ) {
				System.out.println( "\nErreur de formatage, " +
						"entrez un nombre r�el." );
				valide = false;
			}
		} while ( !valide );

		return nombreLu;
	}

	/**
	 * La m�thode publique lireReelValide() permet d'afficher une question et de
	 * lire un nombre r�el qui fait partie d'un intervalle.
	 * 
	 * @param question
	 *            La question � afficher.
	 * @param min
	 *            Le nombre minimum.
	 * @param max
	 *            Le nombre maximum.
	 * @return Le nombre r�el lu.
	 */

	public static double lireReelValide( String question,
										 double min, double max ) {
		double nombreLu = 0;
		boolean valide;

		do {
			valide = true;

			nombreLu = OutilsLecture.lireReel( question );

			// Erreur, si le nombre lu n'est pas entre min et max.

			if ( nombreLu < min || nombreLu > max ) {
				System.out.println( "\nErreur, entrez un nombre r�el entre "
						+ min + " et " + max + "." );
				valide = false;
			}
		} while ( !valide );

		return nombreLu;
	}
}