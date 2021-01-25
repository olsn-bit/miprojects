package paquetExemple;
import java.io.File;
import java.util.*;

/**
 * Aquesta classe Principal utlitza totes les classes per carregar i guardar dades en fitxers
 *
 * @author Alberto Dos Santos
 *
 */
public class Principal {
		GestioDades dadesRegistrades;

		/**
		 * Aquest mètode main crea un objecte de tipus Principal i l'inicia amb inici()
		 */
		public static void main(String[] args) {
				Principal programa = new Principal();

				programa.inici();
		}
		/**
		 * Aquest mètode "inicia" carrega les dades , imprimeix les que hi han, dona la opcio per afegir més i les guarda.
		 */
		public void inici() {
				carregaInicialDades();
				System.out.printf("Aqui arriba?:" + dadesRegistrades.getNumFiles());
				dadesRegistrades.imprimirDades();
				afegirNovesDades();
				dadesRegistrades.imprimirDades();
				guardarDadesEnArxiu();
		}
		/*Llegim el fitxer i ho carreguem en l'objecte de la classe GestioDades*/

		/**
		 * Aquest mètode llegeix el fitxer amb la classe LLegirArxiu i guarda les dades a la variable objecte dadesRegistrades
		 */
		public void carregaInicialDades() {
				LlegirArxiu registre = new LlegirArxiu();

				dadesRegistrades = registre.llegirLinees();
		}
		/*manipulem les dades de l'objecte de la classe GestioDades*/

		/**
		 * Aquest mètode utilitza la classe GestioDades per inserir dades al array del objecte dadesRegistrades
		 */
		public void afegirNovesDades() {
				dadesRegistrades.inserir();
		}
		/*guardem les dades desde l'objecte de la classe GestioDades al fitxer*/

		/**
		 * Aquest mètode guarda les dades del array de dadesRegistrades al arxiu.
		 */
		public void guardarDadesEnArxiu() {
				GuardarArxiu registreActualitzat = new GuardarArxiu();

				registreActualitzat.guardarDades(dadesRegistrades);
		}
}
