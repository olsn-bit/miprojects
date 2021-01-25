package paquetExemple;
import java.io.File;
import java.io.PrintStream;

/**
 * Aquesta classe GuardarArxiu apartir d'un objecte GestioDades ho guarda a un fitxer.
 *
 * @author Alberto Dos Santos
 *
 */
class GuardarArxiu {
		File f;

		/**
		 * Aquest mètode utilitza un objecte tipus GestioDades per guardar les dades en un fitxer.
		 * @param informacio Objecte tipus GestioDades que conté la informacio per guardar
		 */
		public void guardarDades(GestioDades informacio) {
				try {
						// S'intenta obrir el fitxer de sortida
						f = new File("dades.txt");

						PrintStream escriptor = new PrintStream(f);
						int totalLinees = informacio.getNumFiles();

						escriptor.println(totalLinees);
						for (int j = 0; j < totalLinees; j++) {
								escriptor.println(informacio.crearLinea(j));    // aconseguim la linea i l'escrivim
						}
						escriptor.close();
				} catch (Exception e) {
						// Excepció!
						System.out.println("Error al guardar registre: " + e);
				}
		}
}
