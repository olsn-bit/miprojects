import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * Aquesta classe s'encarrega de fer el joc de traduir, mostra les paraules al usuari i li demana una entrada
 *
 * @author: Alberto Dos Santos i Isaac Brull
 *
 * @version: 2020/Maig
 *
 */
public class Joc {
		// NOTES:
		// Les parelles aniran aixi. CATALA - ANGLES al arxiu parelles.txt i separat per coma
		// ruta del arxiu parelles.txt
		Scanner sc = new Scanner(System.in);
		final String idiomaPrincipal;

		String[] parellaActual;         // Guardarem [0] catala [1] angles

		ArrayList<Integer> paraulesFetes;
		ArrayList<String> parelles;
		int codiIdioma;                 // explicat a start()

		/**
		 *
		 * Constructor per a la classe JOC, inicialitza els atributs i carrega les parelles del fitxer parelles.txt
		 *
		 * @param idioma Idioma principal de les traduccions
		 *
		 *
		 */
		public Joc(String idioma) {
				this.parelles = new ArrayList<String>();
				this.idiomaPrincipal = idioma;
				this.paraulesFetes = new ArrayList<Integer>();
				this.loadParelles();
				this.start();
		}

		/**
		 *
		 * Aquesta mètode principal inicia el joc
		 *
		 */
		public void start() {
				// Aquest if que tenim a la part inferior, serveix per a guardar el codi d'idioma,
				// aixo influeix en la manera que guardem les paraules a l'arxiu parelles.csv,
				// les paraules en catala van primer i despres les d'angles, guardem el codi per a que el Joc
				// sapigue quin idioma te que inprimir.
				String idiomaSecundari;

				if (this.idiomaPrincipal == "catala") {
						this.codiIdioma = 0;
						idiomaSecundari = "angles";
				} else {
						idiomaSecundari = "catala";
						this.codiIdioma = 1;
				}
				System.out.println("Començem:");
				while (this.paraulesFetes.size() != this.parelles.size()) {
						System.out.println("Tradueix la paraula : " + this.displayWord());
						if (this.checkPair(sc.nextLine())) {
								Start.registreActual.registrar("Traducció correcta del " + this.idiomaPrincipal + " al " + idiomaSecundari + " la parella " +
									Arrays.toString(this.parellaActual));

								// Registrar paraula correcta.Registrar Traduccio correcta
						} else {
								Start.registreActual.registrar("Traducció incorrecta del " + this.idiomaPrincipal + " al " + idiomaSecundari + " la parella " +
									Arrays.toString(this.parellaActual));
								// Mostra la ratxa que tenia l'usuari.
								// Seguent paraula
								//
								// Traduccio incorrecta
						}
				}
				System.out.println("S'han acabat les parelles, afegeix més per seguir jugant.");
				Start.registreActual.guardar();
				// S'han acabat les parelles
		}
		/**
		 *
		 * Retorna una parella aleatoria del arxiu parelles.txt
		 * @return retorna una paraula del arxiu parelles.txt
		 */
		public String displayWord() {
				int numRandom;

				do{
						numRandom = (int)(Math.random() * (this.parelles.size()));
				}while(this.paraulesFetes.contains(numRandom));
				this.paraulesFetes.add(numRandom);
				this.parellaActual = parelles.get(numRandom).split("-");
				return (this.parellaActual[this.codiIdioma]);
				// Agafar una paraula de la llista de paraules i guardar-la a algun lloc per chekear si l'hem fet antreiorment.
				// Podriem guardar el index de la parella per saber si l'em fet avans
		}
		/**
		 *
		 * Comprova si la string entrada com a parametre es igual a la traduccio de la parella actual
		 *
		 * @param traduccio paraula per comprovar si la traduccio es correcta
		 * @return boolean true si la resposta es correcta, false en el cas contrari
		 */
		public boolean checkPair(String traduccio) {
				if (this.codiIdioma == 1) {
						if (this.parellaActual[0].equals(traduccio)) {
								System.out.println("Correcte!");
								return (true);
						} else {
								System.out.println("Erroni!");
								return (false);
						}
				} else {
						if (this.parellaActual[1].equals(traduccio)) {
								System.out.println("Correcte!");

								return (true);
						} else {
								System.out.println("Erroni!");

								return (false);
						}
				}
				// Tindriem que comprovar si hem fet totes les paraules.
				// Utilitizem parellaAcutal per checkear
				// Mirar si la traduccio és la correcta
		}
		/**
		 *
		 * Aquest mètode carrega les parelles del arxiu txt parelles.txt
		 *
		 */
		public void loadParelles() {    // Aquest mètode guarda totes les parelles a un array per a poder fer-ho random al programa ..
				try {
						File fitxer = new File("parelles.txt");
						Scanner arxiu = new Scanner(fitxer);

						do{
								String linea = arxiu.nextLine();

								String[] parellesLinea = linea.split(",");
								for (int cada = 0; cada < parellesLinea.length; cada++) {
										this.parelles.add(parellesLinea[cada]);
								}
						}while(arxiu.hasNextLine());
						System.out.println("debug- paraules carregades correctament.");
						arxiu.close();
				} catch (Exception e) {
						// Excepció!

						e.printStackTrace(System.out);
				}
		}
}
