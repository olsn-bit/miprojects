import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 *
 * Aquesta classe gestiona un registre dels encerts i errors de les traduccions del joc
 *
 * @author: Alberto Dos Santos i Isaac Brull
 *
 * @version: 2020/Maig
 *
 */
public class Registre {
		// De cada paraula guardarem la
// paraula en català, la seva traducció a l’anglès, si l’hem sabut traduir o no del català a l’anglès i si l’hem
// sabut traduir o no de l’anglès al català. Les parelles de paraules les introduirem nosaltres. "
// "quan acabem cada partida.""
		String registreComplet;

		/**
		 *
		 * Constructor per a la classe Registre, inicia l'atribut registrecomplet
		 *
		 *
		 */
		public Registre() {
				this.registreComplet = "";
		}
// metode que com a parametre entra String i es guarda a un string Principal

/**
 *
 * Constructor per a la classe Registre, inicia l'atribut registrecomplet
 * @param principal String per afegir al registre complet.
 *
 */
		public void registrar(String principal) {
				this.registreComplet += principal + ",\n";
		}
// metode que agafa el String princpial i l'escriu al registre.TXT

/**
 *
 * Aquest mètode guarda el contingut de registre complet al arxiu registre.txt
 *
 *
 */
		public void guardar() {
				try {                                                                                           // Exemple agafat de afegir() de Gestio.java
						PrintStream escriptor = new PrintStream(new FileOutputStream("registre.txt", true));    // L'hem obert en append mode per afegir

						escriptor.write(this.registreComplet.getBytes());
						escriptor.close();
				} catch (Exception e) {
						// Excepció!

						e.printStackTrace(System.out);
				}
		}
// metode arxivar que pregunta al usuari un nom d'un arxiu, el crea i guarda el registre actual al arxiu especific

/**
 *
 * Aquest mètode arxiva el registre actual a un altre arxiu que anomenara l'usuari
 *
 *
 */
		public void arxivar() {
				// canviar de nom al registre i crear un registre nou 1000 IQ
				Scanner sc = new Scanner(System.in);

				System.out.println("Introdueix el nom de l'arxiu per arxivar el registre actual.");

				String nomArxiu = sc.nextLine();

				try {
						File antic = new File("registre.txt");
						File arxivat = new File(nomArxiu + ".txt");

						if (antic.renameTo(arxivat)) {
								antic.createNewFile();
								System.out.println("Registre creat");
						} else {
								System.out.println("El registre no s'ha pogut crear");
						}
				} catch (Exception e) {
						// Excepció!

						e.printStackTrace(System.out);
				}
		}
// public
}
