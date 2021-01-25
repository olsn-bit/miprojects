import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * Aquesta classe s'encarrega de gestionar les parelles afegint configuracions
 *
 * @author: Alberto Dos Santos i Isaac Brull
 *
 * @version: 2020/Maig
 *
 */
public class Gestio {
		public static Scanner sc = new Scanner(System.in);

		/**
		 *
		 * Aquest mètode serveix per cridar configuracio i mostra les opcions de configuracio disponibles
		 *
		 *
		 */
		public static void configuracio() {
				System.out.println("Accions :" + "\n\"1\": Afegir parella al llistat." + "\n\"2\": Modificar parella del llistat." +
					"\n\"3\": Esborrar parella del llistat." + "\n\"4\": Arxivar el registre actual.");
				switch (sc.nextLine()) {
				case "1":               // afegir
						afegir();
						break;
				case "2":               // modificar
						esborrar();
						System.out.println("Torna a introduir les dades correctes de la parella borrada anteriorment.");
						afegir();
						break;
				case "3":               // esborrar
						esborrar();
						break;
				case "4":
						Start.registreActual.arxivar();
						break;
				}
		}
		/**
		 *
		 * Aquest mètode afegeix una parella al fitxer parelles.txt
		 *
		 *
		 *
		 */
		public static void afegir() {
				// Afegir una parella de paraules al registre de paraules-partides. Ens demanarà la paraula en català
				// i la paraula en anglès.
				System.out.println("Introduieix la paraula en català: (sense espais i en minuscula)");

				String catala = sc.nextLine();

				System.out.println("Introduieix la paraula en anglès: (sense espais i en minuscula)");

				String angles = sc.nextLine();
				String lineaCompleta = catala + "-" + angles + ",";

				try {
						PrintStream escriptor = new PrintStream(new FileOutputStream("", true));    // L'hem obert en append mode per afegir

						escriptor.write(lineaCompleta.getBytes());
						escriptor.close();
				} catch (Exception e) {
						// Excepció!

						e.printStackTrace(System.out);
				}
		}
		/**
		 *
		 * Aquest mètode esborra una parella del fitxer parelles.txt
		 *
		 *
		 */
		public static void esborrar() {
				ArrayList<String> parellesPassat = new ArrayList<String>();

				try {
						File fitxer = new File("parelles.txt");
						Scanner arxiu = new Scanner(fitxer);

						do{
								String linea = arxiu.nextLine();

								String[] parellesLinea = linea.split(",");
								for (int cada = 0; cada < parellesLinea.length; cada++) {
										parellesPassat.add(parellesLinea[cada]);
								}
						}while(arxiu.hasNextLine());
						arxiu.close();
				} catch (Exception e) {
						// Excepció!
						e.printStackTrace(System.out);
				}
				System.out.println("Introduiex la paraula en catala o angles que vols modificar/esborrar la parella");

				String search = sc.nextLine();

				System.out.println(Arrays.toString(new ArrayList[] { parellesPassat }));
				try {
						PrintStream escriptor = new PrintStream(new FileOutputStream("parelles.txt"));  // L'hem obert en append mode per afegir

						for (int i = 0; i < parellesPassat.size(); i++) {
								if (!parellesPassat.get(i).contains(search)) {
										escriptor.write((parellesPassat.get(i) + ",").getBytes());
								}
						}
						escriptor.close();
				} catch (Exception e) {
						// Excepció!

						e.printStackTrace(System.out);
				}
		}
// • Modificar una parella de paraules del registre de paraules-partides. Ens demanarà la paraula en
// català o en anglès. Comprovarà si té informació associada, i en cas que en tingui, ens demanarà
// confirmació per a fer la modificació i esborrar el contingut associat.

// • Esborrar una parella de paraules del registr de paraules-partides. Ens demanarà la paraula en
// català o anglès, demanarà confirmació i l’esborrarà l’entrada.
}
