package paquetExemple;
import java.util.Scanner;

/**
 * Aquesta classe l'utilitzarem per a gestionar dades.
 *
 * Principalment guardem dades a un array bidimensional que pot ser utilitzat
 * per obtenir o demanar aquestes dades.
 * @author Alberto Dos Santos
 *
 */
class GestioDades {
		/* Constants de mida de l'array emprat*/
		static final int MIDA = 40;
		static final int NUMCAMPS = 5;

		String[][] dades = new String[MIDA][NUMCAMPS];  // Llistat de dades

		int totalFiles;                                 // control de files inserides

		/**
		 * Aquest és el constructor de la classe, unicament inicialitza la variable totalfiles
		 */
		public GestioDades() {
				totalFiles = 0;
		}
		/**
		 * Aquest mètode guarda la linea introduida com a parametre al array 2d  i el situa a l'ultima linea
		 * @param linea String: la línea per introduir
		 */
		public void carregarLinea(String linea) {
				String[] vector = linea.split("/");
				for (int j = 0; j < vector.length; j++) {
						dades[totalFiles][j] = vector[j];
				}
		}
		/**
		 * Aquest mètode retorna la linea del array 2d que es situa a la posició del enter que introduiex l'usuari
		 * @return String: linea del array "posicio"
		 * @param posicio Integer: index del array per retornar
		 */
		public String crearLinea(int posicio) {
				String lineaPerArxivar = "";

				for (int j = 0; j < (NUMCAMPS - 1); j++) {
						lineaPerArxivar = lineaPerArxivar + dades[posicio][j] + "/";
				}
				lineaPerArxivar = lineaPerArxivar + dades[posicio][NUMCAMPS - 1];
				System.out.println("Linea per Arxivar: " + lineaPerArxivar);
				return (lineaPerArxivar);
		}
		/**
		 * Aquest getter retorna el valor de totalfiles que marca la posicio que s'escriuran les dades la proxima inserció
		 * @return int atribut totalfiles
		 */
		public int getNumFiles() {
				return (totalFiles);
		}
		/**
		 * Aquest mètode imprimeix per pantalla el nombre de files que hi han escrites i el seu contingut
		 */
		public void imprimirDades() {
				System.out.println("totalFiles: " + totalFiles);
				for (int i = 0; i < totalFiles; i++) {
						for (int j = 0; j < NUMCAMPS; j++) {
								System.out.printf("%15s  \t", dades[i][j]);
						}
						System.out.print("\n");
				}
		}
		/**
		 * Aquest mètode utilitza la funcio llegirCadenaText per demanar al usuari una cadena de text i la introduiex al array a la posicio totalfiles
		 */
		public void inserir() {
				String[] missatges = new String[NUMCAMPS];
				missatges[0] = "Introdueix camp1: ";
				missatges[1] = "Introdueix camp2: ";
				missatges[2] = "Introdueix camp3: ";
				missatges[3] = "Introdueix camp4: ";
				missatges[4] = "Introdueix camp5: ";
				for (int i = 0; i < NUMCAMPS; i++) {
						System.out.println("Introdueix camp" + (i + 1) + ": ");
						dades[totalFiles][i] = llegirCadenaText();
				}
				totalFiles++;
		}
		/**
		 * Aquest mètode l'utilitzem per demanar dades al usuari amb Scanner, essencial per inserir()
		 * @return String: cadena de text introduida per l'usuari
		 */
		public String llegirCadenaText() {
				Scanner entrada = new Scanner(System.in);
				String stringAux = entrada.nextLine();

				while (stringAux.length() == 0) {
						stringAux = entrada.nextLine();
				}
				return (stringAux);
		}
}
