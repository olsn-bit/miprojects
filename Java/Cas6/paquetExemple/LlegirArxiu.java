package paquetExemple;
import java.io.File;
import java.util.Scanner;

/**
 * Aquesta classe LlegirArxiu crea un objecte tipus GestioDades i emmagatzema les dades d'un fixer a aquest.
 *
 * @author Alberto Dos Santos
 *
 */
class LlegirArxiu {
		File f;

		/**
		 * Aquest mètode crea un objecte tipus GestioDades i emmagatzema les dades del fitxer
		 * al array del objecte
		 * @return objecte tipus GestioDades amb les linees del fitxer.
		 */
		public GestioDades llegirLinees() {
				// buidem l'objecte informacio per a carregar-hi les dades de l'arxiu
				GestioDades informacio = new GestioDades();

				try {
						// S'obri el fitxer
						f = new File("dades.txt");

						Scanner lector = new Scanner(f, "UTF-8");
						// AL fitxer hem guardat el nombre de linees a la primera fila
						int linees = Integer.parseInt(lector.nextLine());

						for (int i = 0; i < linees; i++) {
								// guardem la línea llegida en l'objecte informacio;
								informacio.carregarLinea(lector.nextLine());
						}
						lector.close();
				} catch (Exception e) {
						System.out.println("Error al llegir: " + e);
				}
				return (informacio);
		}
}
