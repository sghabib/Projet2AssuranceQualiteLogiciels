/**
 * Auteure : Soti
 * Fichier : OutilsFichier.java
 * Package : outilsjava
 * Date    : Hiver 2017
 * Cours   : Programmation avec Java
 */

// La classe OutilsFichier fait partie du package outilsjava.

package Projet2AssuranceQualiteLogiciels;

// Packages du syst�me.
import java.io.*;
import java.nio.file.*;
import java.nio.charset.*;

/**
 * Classe qui contient certaines m�thodes utilitaires pour les fichiers. Cette
 * classe fait partie du package outilsjava.
 */

public class OutilsFichier {

	private static final int MAX_CAR_FICHIER = 250;
	private static final char OUI = 'O';
	
	/**
	 * On d�finit le constructeur private pour emp�cher la cr�ation d'instances
	 * de la classe OutilsFichier.
	 */
	
	private OutilsFichier() {
	}

	/**
	 * La m�thode publique lireNomFichier() permet d'afficher une question et de
	 * lire une cha�ne de caract�res repr�sentant un nom physique de fichier.
	 * 
	 * @param question
	 *            La question � afficher.
	 * @return La cha�ne de caract�res repr�sentant un nom physique de fichier.
	 */

	public static String lireNomFichier( String question ) {
		String nomFic;

		nomFic = OutilsLecture.lireChaineValide( question, 1, MAX_CAR_FICHIER );

		return nomFic;
	}

	/**
	 * La m�thode publique ouvrirFicTexteLecture() permet d'ouvrir un fichier
	 * texte en mode lecture bufferis�e.
	 * 
	 * @param nomFichier
	 *            Le nom physique du fichier.
	 * @return le nom logique du fichier si l'ouverture est un succ�s ou
	 *         null dans le cas contraire.
	 */

	public static BufferedReader ouvrirFicTexteLecture( String nomFichier ) {

		boolean valide = true;
		Path chemin = null;
		String cheminAbsolu = "";
		BufferedReader ficLecture = null;

		// Cr�ation du chemin.
		try {
			chemin = Paths.get( nomFichier );

		} 
		catch ( InvalidPathException errNomFichier ) {
			System.out.println( "\nErreur, le fichier " + nomFichier 
					+ " contient des caract�res ill�gaux." );
			valide = false;
		}

		// Si la cr�ation du chemin est valide, on peut poursuivre.

		if ( valide ) {
			cheminAbsolu = chemin.toAbsolutePath().toString();

			// V�rifier l'existence du fichier.

			if ( Files.notExists( chemin ) ) {
				// Le fichier n'existe pas.
				System.out.println( "\nErreur, le fichier " + cheminAbsolu
						+ " n'existe pas." );
				valide = false;

			} else if ( Files.exists( chemin ) ) {
				// Le fichier existe.
				// Est-ce un fichier ordinaire ?

				if ( !Files.isRegularFile( chemin ) ) {

					System.out.println( "\nErreur, le fichier " + cheminAbsolu
							+ " n'est pas un fichier ordinaire." );
					valide = false;
				} else {
					// C'est un fichier ordinaire.
					// Est-ce un fichier permis en lecture ?

					if ( !Files.isReadable( chemin ) ) {

						System.out.println( "\nErreur, le fichier "
								+ cheminAbsolu
								+ " n'est pas permis en lecture." );
						valide = false;
					} else {
						// Le fichier existe, est ordinaire 
						// et permis en lecture.

						// Ouverture du fichier texte en mode lecture.

						try {
							ficLecture = Files.newBufferedReader( chemin,
											        Charset.defaultCharset() );
						}
						catch ( IOException errIO ) {
							System.out
									.println( "\nErreur, impossible d'ouvrir "
											+ "le fichier " + cheminAbsolu
											+ " en mode lecture texte." );
							valide = false;
						}
					}
				}
			} else {
				System.out.println( "\nErreur, impossible de v�rifier "
						+ "l'existence du fichier " + cheminAbsolu + "." );
				valide = false;
			}
		}

		return ficLecture;
	}

	/**
	 * La m�thode publique ouvrirFicTexteEcriture() permet d'ouvrir un fichier
	 * texte en mode �criture bufferis�e.
	 * 
	 * @param nomFichier
	 *            Le nom physique du fichier.
	 * @return le nom logique du fichier si l'ouverture est un succ�s ou
	 *         null dans le cas contraire.
	 */

	public static BufferedWriter ouvrirFicTexteEcriture( String nomFichier ) {

		boolean valide = true;
		Path chemin = null;
		String cheminAbsolu = "";
		BufferedWriter ficEcriture = null;

		// Cr�ation du chemin.
		try {
			chemin = Paths.get( nomFichier );

		}
		catch ( InvalidPathException errNomFichier ) {
			System.out.println( "\nErreur, le fichier " + nomFichier
					+ " contient des caract�res ill�gaux." );
			valide = false;
		}

		// Si la cr�ation du chemin est valide, on peut poursuivre.

		if ( valide ) {
			cheminAbsolu = chemin.toAbsolutePath().toString();

			// V�rifier l'existence du fichier.

			if ( Files.notExists( chemin ) ) {
				// Le fichier n'existe pas. On peut l'ouvrir en �criture.
				valide = true;

			} else if ( Files.exists( chemin ) ) {
				// Le fichier existe.
				// Est-ce un fichier ordinaire ?

				if ( !Files.isRegularFile( chemin ) ) {

					System.out.println( "\nErreur, le fichier " + cheminAbsolu
							+ " n'est pas un fichier ordinaire." );
					valide = false;
				} else {
					// C'est un fichier ordinaire.
					// Est-ce un fichier permis en �criture ?

					if ( !Files.isWritable( chemin ) ) {

						System.out.println( "\nErreur, le fichier "
								+ cheminAbsolu
								+ " n'est pas permis en �criture." );
						valide = false;
					} else {
						// Le fichier existe, est ordinaire 
						// et permis en �criture.
						// On demande une confirmation avant de l'�craser.

						System.out.println( "\nLe fichier " + cheminAbsolu
								+ " existe." );

						char conf =	OutilsLecture.lireOuiNon( "Voulez-vous "
										+ "�craser ce fichier ( O ou N ) ? " );

						valide = ( conf == OUI ); // valide = true ou false.
					}
				}
			} else {
				System.out.println( "\nErreur, impossible de v�rifier "
						+ "l'existence du fichier " + cheminAbsolu + "." );
				valide = false;
			}
		}

		if ( valide ) {
			// Le fichier n'existe pas.
			// Ou le fichier existe, est ordinaire, est permis �criture et
			// on veut l'�craser.
			
			// Ouverture du fichier texte en mode �criture.

			try {
				ficEcriture = Files.newBufferedWriter( chemin,
												Charset.defaultCharset() );
			}
			catch ( IOException errIO ) {
				System.out.println( "\nErreur, impossible d'ouvrir "
						+ "le fichier " + cheminAbsolu
						+ " en mode �criture texte." );
				valide = false;
			}
		}

		return ficEcriture;
	}

	/**
	 * La m�thode publique ouvrirFicTexteEcritureAjout() permet d'ouvrir un
	 * fichier texte en mode ajout de texte � la fin du fichier. Le fichier est
	 * cr��, s'il n'existe pas.
	 * 
	 * @param nomFichier
	 *            Le nom physique du fichier.
	 * @return le nom logique du fichier si l'ouverture est un succ�s ou null
	 *         dans le cas contraire.
	 */

	public static BufferedWriter ouvrirFicTexteEcritureAjout( 
														String nomFichier ) {

		boolean valide = true;
		Path chemin = null;
		String cheminAbsolu = "";
		BufferedWriter ficEcriture = null;

		// Cr�ation du chemin.
		try {
			chemin = Paths.get( nomFichier );

		}
		catch ( InvalidPathException errNomFichier ) {
			System.out.println( "\nErreur, le fichier " + nomFichier
					+ " contient des caract�res ill�gaux." );
			valide = false;
		}

		// Si la cr�ation du chemin est valide, on peut poursuivre.

		if ( valide ) {
			cheminAbsolu = chemin.toAbsolutePath().toString();

			// V�rifier l'existence du fichier.

			if ( Files.notExists( chemin ) ) {
				// Le fichier n'existe pas. On peut l'ouvrir en �criture.
				valide = true;

			} else if ( Files.exists( chemin ) ) {
				// Le fichier existe.
				// Est-ce un fichier ordinaire ?

				if ( !Files.isRegularFile( chemin ) ) {

					System.out.println( "\nErreur, le fichier " + cheminAbsolu
							+ " n'est pas un fichier ordinaire." );
					valide = false;
				} else {
					// C'est un fichier ordinaire.
					// Est-ce un fichier permis en �criture ?

					if ( !Files.isWritable( chemin ) ) {

						System.out.println( "\nErreur, le fichier "
								+ cheminAbsolu
								+ " n'est pas permis en �criture." );
						valide = false;
					} else {
						// Le fichier existe, est ordinaire et
						// est permis en �criture.
						// On peut l'ouvrir en �criture pour ajouter � la fin.
						valide = true;
					}
				}
			} else {
				System.out.println( "\nErreur, impossible de v�rifier "
						+ "l'existence du fichier " + cheminAbsolu + "." );
				valide = false;
			}
		}

		if ( valide ) {
			// Le fichier n'existe pas.
			// Ou le fichier existe, est ordinaire et est permis �criture.
			// Ouverture du fichier texte en mode �criture (ajouter � la fin).

			try {
				ficEcriture =
						Files.newBufferedWriter( chemin,
								Charset.defaultCharset(),
								StandardOpenOption.CREATE,
								StandardOpenOption.APPEND );
			}
			catch ( IOException errIO ) {
				System.out.println( "\nErreur, impossible d'ouvrir "
						+ "le fichier " + cheminAbsolu
						+ " en mode �criture texte (ajouter � la fin)." );
				valide = false;
			}
		}

		return ficEcriture;
	}

	/**
	 * La m�thode publique fermerFicTexteLecture() permet de fermer un fichier
	 * texte en mode lecture bufferis�e.
	 * 
	 * @param nomLogique
	 *            Le nom logique du fichier.
	 * @param nomFic
	 *            Le nom physique du fichier.
	 * @return true si la fermeture du fichier est un succ�s ou false dans le
	 *         cas contraire.
	 */

	public static boolean fermerFicTexteLecture( BufferedReader nomLogique,
			String nomFic ) {

		boolean fermerFic = true;

		try {
			nomLogique.close();
		}
		catch ( IOException errIO ) {
			System.out.println( "Erreur, impossible de fermer le fichier "
					+ nomFic + "." );
			fermerFic = false;
		}

		return fermerFic;
	}

	/**
	 * La m�thode publique fermerFicTexteEcriture() permet de fermer un fichier
	 * texte en mode �criture bufferis�e.
	 * 
	 * @param nomLogique
	 *            Le nom logique du fichier.
	 * @param nomFic
	 *            Le nom physique du fichier.
	 * @return true si la fermeture du fichier est un succ�s ou false dans le
	 *         cas contraire.
	 */

	public static boolean fermerFicTexteEcriture( BufferedWriter nomLogique,
			String nomFic ) {

		boolean fermerFic = true;

		try {
			nomLogique.close();
		}
		catch ( IOException errIO ) {
			System.out.println( "Erreur, impossible de fermer le fichier "
					+ nomFic + "." );
			fermerFic = false;
		}

		return fermerFic;
	}

	/**
	 * La m�thode publique ouvrirFicBinLecture() permet d'ouvrir un fichier
	 * s�rialis� (binaire) en mode lecture.
	 * 
	 * @param nomFichier
	 *            Le nom physique du fichier.
	 * @return le nom logique du fichier si l'ouverture est un succ�s ou null
	 *         dans le cas contraire.
	 */

	public static ObjectInputStream ouvrirFicBinLecture( String nomFichier ) {

		boolean valide = true;
		Path chemin = null;
		String cheminAbsolu = "";
		ObjectInputStream ficLecture = null;

		// Cr�ation du chemin.
		try {
			chemin = Paths.get( nomFichier );
		}
		catch ( InvalidPathException errNomFichier ) {
			System.out.println( "\nErreur, le fichier " + nomFichier
					+ " contient des caract�res ill�gaux." );
			valide = false;
		}

		// Si la cr�ation du chemin est valide, on peut poursuivre.

		if ( valide ) {
			cheminAbsolu = chemin.toAbsolutePath().toString();

			// V�rifier l'existence du fichier.

			if ( Files.notExists( chemin ) ) {
				// Le fichier n'existe pas.
				System.out.println( "\nErreur, le fichier " + cheminAbsolu
						+ " n'existe pas." );
				valide = false;

			} else if ( Files.exists( chemin ) ) {
				// Le fichier existe.
				// Est-ce un fichier ordinaire ?

				if ( !Files.isRegularFile( chemin ) ) {

					System.out.println( "\nErreur, le fichier " + cheminAbsolu
							+ " n'est pas un fichier ordinaire." );
					valide = false;
				} else {
					// C'est un fichier ordinaire.
					// Est-ce un fichier permis en lecture ?

					if ( !Files.isReadable( chemin ) ) {

						System.out.println( "\nErreur, le fichier "
								+ cheminAbsolu
								+ " n'est pas permis en lecture." );
						valide = false;
					} else {
						// Le fichier existe, est ordinaire et 
						// est permis en lecture.
						
						// Ouverture du fichier texte en mode lecture.

						try {
							ficLecture = new ObjectInputStream( 
											new FileInputStream( nomFichier ) );
						}
						catch ( IOException errIO ) {
							System.out
									.println( "\nErreur, impossible d'ouvrir "
											+ "le fichier " + cheminAbsolu
											+ " en mode lecture binaire." );
							valide = false;
						}
					}
				}
			} else {
				System.out.println( "\nErreur, impossible de v�rifier "
						+ "l'existence du fichier " + cheminAbsolu + "." );
				valide = false;
			}
		}

		return ficLecture;
	}


	/**
	 * La m�thode publique ouvrirFicBinEcriture() permet d'ouvrir un fichier
	 * s�rialis� (binaire) en mode �criture.
	 * 
	 * @param nomFichier
	 *            Le nom physique du fichier.
	 * @return le nom logique du fichier si l'ouverture est un succ�s ou null
	 *         dans le cas contraire.
	 */

	public static ObjectOutputStream ouvrirFicBinEcriture( String nomFichier ) {

		boolean valide = true;
		Path chemin = null;
		String cheminAbsolu = "";
		ObjectOutputStream ficEcriture = null;

		// Cr�ation du chemin.
		try {
			chemin = Paths.get( nomFichier );
		}
		catch ( InvalidPathException errNomFichier ) {
			System.out.println( "\nErreur, le fichier " + nomFichier
					+ " contient des caract�res ill�gaux." );
			valide = false;
		}

		// Si la cr�ation du chemin est valide, on peut poursuivre.

		if ( valide ) {
			cheminAbsolu = chemin.toAbsolutePath().toString();

			// V�rifier l'existence du fichier.

			if ( Files.notExists( chemin ) ) {
				// Le fichier n'existe pas. On peut l'ouvrir en �criture.
				valide = true;

			} else if ( Files.exists( chemin ) ) {
				// Le fichier existe.
				// Est-ce un fichier ordinaire ?

				if ( !Files.isRegularFile( chemin ) ) {

					System.out.println( "\nErreur, le fichier " + cheminAbsolu
							+ " n'est pas un fichier ordinaire." );
					valide = false;
				} else {
					// C'est un fichier ordinaire.
					// Est-ce un fichier permis en �criture ?

					if ( !Files.isWritable( chemin ) ) {

						System.out.println( "\nErreur, le fichier "
								+ cheminAbsolu
								+ " n'est pas permis en �criture." );
						valide = false;
					} else {
						// Le fichier existe, est ordinaire et 
						// est permis en �criture.
						// On demande une confirmation avant de l'�craser.

						System.out.println( "\nLe fichier " + cheminAbsolu
								+ " existe." );

						char conf =	OutilsLecture.lireOuiNon( "Voulez-vous "
										+ "�craser ce fichier ( O ou N ) ? " );

						valide = ( conf == OUI ); // valide = true ou false.
					}
				}
			} else {
				System.out.println( "\nErreur, impossible de v�rifier "
						+ "l'existence du fichier " + cheminAbsolu + "." );
				valide = false;
			}
		}

		if ( valide ) {
			// Le fichier n'existe pas.
			// Ou le fichier existe, est ordinaire, est permis �criture et
			// on veut l'�craser.
			
			// Ouverture du fichier texte en mode �criture.

			try {
				ficEcriture = new ObjectOutputStream( 
										new FileOutputStream( nomFichier ) );
			}
			catch ( IOException errIO ) {
				System.out.println( "\nErreur, impossible d'ouvrir "
						+ "le fichier " + cheminAbsolu
						+ " en mode �criture binaire." );
				valide = false;
			}
		}

		return ficEcriture;
	}

	/**
	 * La m�thode publique fermerFicBinLecture() permet de fermer un fichier
	 * s�rialis� (binaire) en mode lecture.
	 * 
	 * @param nomLogique
	 *            Le nom logique du fichier.
	 * @param nomFic
	 *            Le nom physique du fichier.
	 * @return true si la fermeture du fichier est un succ�s ou false dans le
	 *         cas contraire.
	 */

	public static boolean fermerFicBinLecture( ObjectInputStream nomLogique,
			String nomFic ) {

		boolean fermerFic = true;

		try {
			nomLogique.close();
		}
		catch ( IOException errIO ) {
			System.out.println( "Erreur, impossible de fermer le fichier "
					+ nomFic + "." );
			fermerFic = false;
		}

		return fermerFic;
	}

	/**
	 * La m�thode publique fermerFicBinEcriture() permet de fermer un fichier
	 * s�rialis� (binaire) en mode �criture.
	 * 
	 * @param nomLogique
	 *            Le nom logique du fichier.
	 * @param nomFic
	 *            Le nom physique du fichier.
	 * @return true si la fermeture du fichier est un succ�s ou false dans le
	 *         cas contraire.
	 */

	public static boolean fermerFicBinEcriture( ObjectOutputStream nomLogique,
			String nomFic ) {

		boolean fermerFic = true;

		try {
			nomLogique.close();
		}
		catch ( IOException errIO ) {
			System.out.println( "Erreur, impossible de fermer le fichier "
					+ nomFic + "." );
			fermerFic = false;
		}

		return fermerFic;
	}
	
	/**
	 * La m�thode publique ouvrirFicRandom() permet d'ouvrir un fichier en mode
	 * acc�s al�atoire lecture ou lecture/�criture.
	 * 
	 * @param nomFichier
	 *            Le nom physique du fichier.
	 * @param mode
	 *            Le mode "r" ou "rw".
	 * @return Le nom logique du fichier si capable de l'ouvrir et null dans le
	 *         cas contraire.
	 */

	public static RandomAccessFile ouvrirFicRandom( String nomFichier,
													String mode ) {

		boolean valide = true;
		Path chemin = null;
		String cheminAbsolu = "";
		RandomAccessFile ficRandom = null;

		// Cr�ation du chemin.
		try {
			chemin = Paths.get( nomFichier );

		}
		catch ( InvalidPathException errNomFichier ) {
			System.out.println( "\nErreur, le fichier " + nomFichier
					+ " contient des caract�res ill�gaux." );
			valide = false;
		}

		// Si la cr�ation du chemin est valide, peut poursuivre.

		if ( valide ) {
			cheminAbsolu = chemin.toAbsolutePath().toString();

			valide = false; // Assume suite pas ok.

			mode = mode.toLowerCase();

			if ( mode.equals( "r" ) ) {

				// V�rifier si peut ouvrir le fichier en mode lecture.

				if ( Files.notExists( chemin ) ) {
					// Le fichier n'existe pas.

					System.out.println( "\nLe fichier " + cheminAbsolu
							+ " n'existe pas." );

				} else if ( Files.exists( chemin ) ) {
					// Le fichier existe.

					// Fichier ordinaire ?

					if ( !Files.isRegularFile( chemin ) ) {

						System.out.println( "\nErreur, le fichier "
								+ cheminAbsolu
								+ " n'est pas un fichier ordinaire." );
					} else {
						// C'est un fichier ordinaire.

						// Permis en lecture ?

						if ( !Files.isReadable( chemin ) ) {

							System.out.println( "\nErreur, le fichier "
									+ cheminAbsolu
									+ " n'est pas permis en lecture." );
						} else {
							// Fichier existe,
							// est ordinaire et permis en lecture.
							valide = true;
						}
					}
				}

			} else if ( mode.equals( "rw" ) ) {
				// V�rifier si peut ouvrir le fichier en mode lecture/�criture.
				// Si le fichier n'existe pas, on veut le cr�er et travailler
				// avec en mode lecture/�criture.

				if ( Files.notExists( chemin ) ) {
					// Le fichier n'existe pas, on essaie de le cr�er vide.

					System.out.println( "\nLe fichier " + cheminAbsolu
							+ " n'existe pas.\nCr�ation de ce fichier vide." );
					try {
						Files.createFile( chemin );

						// Le fichier existe maintenant. On peut essayer de
						// l'ouvrir en mode lecture/�criture.

						valide = true;
					}

					catch ( IOException erEx ) {
						System.out.println( "\nErreur, impossible de cr�er le "
								+ "fichier " + cheminAbsolu + " vide." );
					}
					
				} else if ( Files.exists( chemin ) ) {
					// Le fichier existe. On peut essayer de l'ouvrir en
					// mode lecture/�criture.

					valide = true;
				}

			} else {
				// Ce n'est pas un mode "r" ou "rw".

				System.out.println( "\nErreur, impossible d'ouvrir le fichier "
						+ cheminAbsolu + " en mode " + mode + "." );
			}

		}

		if ( valide ) {
			// Essayer d'ouvrir le fichier en mode lecture ou lecture/�criture.

			try {
				ficRandom = new RandomAccessFile( nomFichier, mode );
			}

			catch ( IOException erEx ) {
				System.out.println( "\nErreur, impossible d'ouvrir le fichier "
						+ cheminAbsolu + " en mode " + mode + "." );
				ficRandom = null;
			}
		}

		return ficRandom;
	}

	/**
	 * La m�thode publique fermerFicRandom() permet de fermer un fichier en
	 * acc�s al�atoire, en mode lecture ou en mode lecture/�criture.
	 * 
	 * @param nomLogique
	 *            Le nom logique du fichier.
	 * @param nomFic
	 *            Le nom physique du fichier.
	 * @return true si capable de fermer le fichier et false dans le cas
	 *         contraire.
	 */

	public static boolean fermerFicRandom( RandomAccessFile nomLogique,
										   String nomFic ) {
		
		boolean fermerFic = true;

		try {
			nomLogique.close();
		}
		
		catch ( IOException erEx ) {
			System.out.println( "Erreur, impossible de fermer le fichier "
					+ nomFic + "." );
			fermerFic = false;
		}

		return fermerFic;
	}

}