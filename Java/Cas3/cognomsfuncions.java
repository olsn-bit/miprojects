import java.util.Scanner;

/**
 * <h1>Editor de llistes</h1>
 * Aquest programa serveix per a fer diferents funcions
 * en una llista de cadenes de text mitjançant la terminal.
 * <b>Note:</b> Aquest programa pot parar de funcionar si no es retorna un valor del tipus demanat.
 *
 *
 *
 * @author  Grup 2 M03
 * @version Beta 1.0
 * @since   2020-26-2
 */
public class cognomsfuncions {
		public static String ResetColor = "\u001B[0m";
		public static String Roig = "\u001B[31m";
		public static String Groc = "\u001B[33m";
		public static String Cyan = "\u001B[36m";
		public static String Verd = "\u001B[32m";
		public static Scanner sc = new Scanner(System.in);

		/**
		 * Aquesta funcio és la principal, s'encarrega de executar les diferents funcions.
		 * @param args Sense Usar.
		 */
		public static void main(String[] args) {
				String[] opcions = {
						"Accions :", "\"i\": Inserir element a la llista", "\"l\": Localitzar un element de la llista",
						"\"r\": Recuperar l'element apartir de la posició", "\"s\": Suprimir un element de la llista",
						"\"d\": Suprimir element que coincideix de la llista", "\"a\": Anul·lar els elements de la llista",
						"\"p\": Imprimir el primer o darrer element de la llista", "\"m\": Imprimir la llista", "\"o\": Ordenar la llista",
						"\"e\": Localitzar En la llista Ordenada", "\"z\": Suprimir Dada En la llista Ordenada", "\"x\": Sortir del Programa"
				};
				String[] list_names = {
						"Aloy", "Ferre", "Bayo", "Falco", "Fernandez", "Didouh", "Garcia", "El Khattabi", "Alguero", "Brull"
				};                      // Elements:10

				int num_elements = 10;
				boolean running = true;

				while (running) {
						switch (Menu(opcions)) {    // ilrsdapmoezx
						case 'i':
								num_elements = Inserir(num_elements, list_names, AskPos(list_names.length, num_elements), AskElement());
								Imprimir(list_names, true);
								break;
						case 'l':

								String askelement = AskElement();

								if (Localitzar(list_names, askelement) != -1) {
										System.out.println(list_names[Localitzar(list_names, askelement)]);
								}
								break;
						case 'r':

								System.out.println(Reocuperar(list_names, AskPos(list_names.length, num_elements)));

								break;
						case 's':
								num_elements = Suprimir(list_names, AskPos(list_names.length, num_elements), num_elements);
								Imprimir(list_names, true);
								break;
						case 'd':
								num_elements = SuprimirDada(list_names, AskElement(), num_elements);
								break;

						case 'a':
								num_elements = Anular(list_names, num_elements);
								break;

						case 'p':
								PrimerDarrer(list_names, num_elements, AskPrimerDarrer());
								break;

						case 'o':
								Ordenar(list_names, num_elements);
								Imprimir(list_names, true);
								break;

						case 'e':
								Ordenar(list_names, num_elements);

								String element = AskElement();

								if (Localitzar(list_names, element) != -1) {
										System.out.println(list_names[Localitzar(list_names, element)]);
								}
								break;

						case 'z':
								Ordenar(list_names, num_elements);
								num_elements = SuprimirDada(list_names, AskElement(), num_elements);
								break;

						case 'x':
								running = false;
								break;
						case 'm':
								Imprimir(list_names, true);
								break;
						default:
								System.out.println(Roig + "Funció no operativa o codi erroni." + ResetColor);
								break;
						}
				}
		}
		/**
		 * Aquesta funcio fa de menú apartir d'una entrada retorna un caràcter per interactuar amb switch del mètode main.
		 * @param opcions Aquest parametre consta d'una llista amb les diferents opcions que pot triar l'usuari i el codi de cada una.
		 * @return char Retorna un caràcter que serà el codi que llegirà el swith del mètode main.
		 */
		public static char Menu(String[] opcions) {
				Imprimir(opcions, false);
				return (sc.nextLine().charAt(0));
		}
		/**
		 * Aquesta funció insereix un element a una llista.
		 * @param num_elements Aquesta variable actua com a contador del elements no null de la llista (list).
		 * @param list Aquesta variable serà la array que efectuarem les operacions.
		 * @param new_pos Aquesta variable s'encarrega de marcar la posició on inserirem el nou element.
		 * @param element Aquesta variable emmagatzema un valor String del element que anem a inserir.
		 * @return int Retorna el nombre d'elements actual de la llista una vegada s'han efecetuat totes les opearcions.
		 */
		public static int Inserir(int num_elements, String[] list, int new_pos, String element) {
				String siono;

				if (IsListFull(list)) {
						do {
								System.out.println(Roig + "La llista esta plena, vols que borrem l'ultim element \" " + list[list.length - 1] +
								                   " \" o no efectuar la acció ( si / no ) ?" + ResetColor);
								siono = sc.nextLine();
						} while(!(siono.equals("si") || siono.equals("no")));   // https://softwareengineering.stackexchange.com/questions/306881/how-to-properly-reverse-the-if-statement-when-you-have-two-conditions-in-it
						if (siono.equals("si")) {
								for (int e = num_elements - 1; e > new_pos; e--) {
										list[e] = list[e - 1];
								}
								list[new_pos] = element;
								return (num_elements);
						} else {
								System.out.println("Sortint..");
						}
				} else {
						for (int e = num_elements; e > new_pos; e--) {
								list[e] = list[e - 1];
						}
						list[new_pos] = element;
						num_elements++;
						return (num_elements);
				}
				return (num_elements);
		}
		/**
		 * Aquesta funció demana al usuari un enter valid de la llista.
		 * @param num_elements Aquesta variable actua com a contador del elements no null de la llista (list).
		 * @param listLength Aquesta variable de tipus enter marca el tamany complet de l'array (list.length).
		 * @return int Retorna la posició correcta inserida per l'usuari.
		 */
		public static int AskPos(int listLength, int num_elements) {
				int pos;

				while (true) {
						System.out.println(Groc + "Introdueix una posició: " + ResetColor);
						pos = sc.nextInt();
						sc.nextLine();
						if (pos >= 0 && pos < listLength && pos <= num_elements) {
								return (pos);
						} else {
								System.out.println(Roig + "Posició Incorrecta/Posicións anteriors buides" + ResetColor);
						}
				}
		}
		/**
		 * Aquesta funció demana al usuari un element vàlid.
		 * @return String - Retorna una cadena de text.
		 */
		public static String AskElement() {
				String element;

				do {
						System.out.println(Groc + "Introdueix un element: (Sense Comilles)" + ResetColor);
						element = sc.nextLine();
				} while(element.length() < 1);
				return (element);
		}
		/**
		 * Aquesta funció dona dues opcions, "primer" o "darrer" i l'usuari té que el·legir una.
		 * @return Retorna una cadena de text ("primer" o "darrer").
		 */
		public static String AskPrimerDarrer() {
				String primerDarrer;

				do {
						System.out.println(Verd + "Opcions: \"primer\" o \"darrer\"" + ResetColor);
						primerDarrer = sc.nextLine();
				} while(!(primerDarrer.equals("primer") || primerDarrer.equals("darrer")));
				return (primerDarrer);
		}
		/**
		 * Aquesta funció imprimeix per pantalla una llista.
		 * @param list Aquesta variable serà la array que efectuarem les operacions.
		 * @param numeracio Aquesta variable de tipus booleà marca si volem imprimir per pantalla els elements de la llista amb numeració o sense. (True = Amb numeració) o (False = Sense numeració).
		 */
		public static void Imprimir(String[] list, boolean numeracio) {
				if (IsListEmpty(list)) {
						System.out.println(Roig + "La llista és buida " + ResetColor);
				} else {
						String printline = "\n";

						for (int e = 0; e < list.length; e++) {
								if (list[e] != null) {
										if (!numeracio) { printline += list[e] + "\n"; } else { printline += (e) + ": " + list[e] + "\n"; }
								} else {
										if (!numeracio) { printline += "Empty\n"; } else { printline += (e) + ": " + "Empty\n"; }
								}
						}
						System.out.println(Groc + printline + ResetColor);
				}
		}
		/**
		 * Aquesta funció localitza un element de la llista apartir d'una cadena de text.
		 * @param list Aquesta variable serà la array que efectuarem les operacions.
		 * @param element Aquesta variable emmagatzema un valor String del element que anem a localitzar.
		 * @return Retorna un enter que es la posició a la llista del element a localitzar. Retornarà -1 si no s'ha localitzat l'element introduit.
		 *
		 */
		public static int Localitzar(String[] list, String element) {
				if (IsListEmpty(list)) {
						System.out.println(Roig + "La llista és buida " + ResetColor);
						return (0);
				}
				for (int i = 0;; i++) {
						if (i == list.length) {
								System.out.println(Roig + "L'element " + element + " no es troba a la llista " + ResetColor);
								return (-1);
						} else if (list[i] != null && list[i].equals(element)) {
								System.out.println(Verd + "L'element " + element + " es troba a la posició " + i + "" + ResetColor);
								return (i);
						}
				}
				// Return pos
		}
		/**
		 * Aquesta funció reocupera un element de la llista apartir de la seva posició.
		 * @param list Aquesta variable serà la array que efectuarem les operacions.
		 * @param pos Aquesta variable de tipus enter emmagatzema la posició de l'element que volem.
		 * @return Retorna una cadena de text que és l'element de la llista. Retorn null si no s'ha trobat l'element.
		 */
		public static String Reocuperar(String[] list, int pos) {
				if (list[pos] == null || IsListEmpty(list)) {
						System.out.println(Roig + "La posició " + pos + " es buida" + ResetColor);
						return (null);
				} else {
						System.out.println(Verd + "A la posició " + pos + " es troba l'element: " + list[pos] + ResetColor);
						return (list[pos]);
				}
		}
		/**
		 * Aquesta funció suprimeix un element de la llista apartir d'una posició.
		 * @param list Aquesta variable serà la array que efectuarem les operacions.
		 * @param num_elements Aquesta variable actua com a contador del elements no null de la llista (list).
		 * @param pos Aquesta variable de tipus enter emmagatzema la posició de l'element que volem.
		 * @return int Retorna el nombre d'elements actual de la llista una vegada s'han efecetuat totes les opearcions.
		 */
		public static int Suprimir(String[] list, int pos, int num_elements) {
				if (IsListEmpty(list)) {
						System.out.println(Roig + "La llista és buida " + ResetColor);
						return (num_elements);
				} else if (list[pos] != null) {
						// Sobreescriu les cel·les cap a l'esquerra i elimina la primera
						for (int e = pos; e < num_elements; e++) {
								list[e] = list[e + 1];
						}
						// llista = {1,2,3,null}
						list[num_elements - 1] = null;
						System.out.println(Verd + "S'ha eliminat l'element " + list[pos] + ResetColor);
						num_elements--;
						return (num_elements);
				} else {
						System.out.println(Roig + "Aquest element no es pot borrar perque no existeix. " + ResetColor);
				}
				return (num_elements);
		}
		/**
		 * Aquesta funció l'utilizarem per a saber si una llista és buida.
		 * @param list Aquesta variable serà la array que efectuarem les operacions.
		 * @return Retorna un boolea. Si el boolea és True la llista és buida, retorna False si no ho és.
		 */
		public static boolean IsListEmpty(String[] list) {
				for (int e = 0; e < list.length; e++) {
						if (list[e] != null) {
								return (false);
						}
				}
				return (true);
		}
		/**
		 * Aquesta funció l'utilizarem per a saber si una llista és plena.
		 * @param list Aquesta variable serà la array que efectuarem les operacions.
		 * @return Retorna un boolea. Si el boolea és True la llista és plena, retorna False si no ho és.
		 */
		public static boolean IsListFull(String[] list) {
				for (int e = 0; e < list.length; e++) {
						if (list[e] == null) {
								return (false);
						}
				}
				return (true);
		}
		/**
		 * Aquesta funció l'utilizarem per a el·liminar TOTS els elements de la llista.
		 * @param list Aquesta variable serà la array que efectuarem les operacions.
		 * @param num_elements Aquesta variable actua com a contador del elements no null de la llista (list).
		 * @return int Retorna el nombre d'elements actual de la llista una vegada s'han efecetuat totes les opearcions.
		 * Aquesta funcio sol retornar el valor "0" ja que el·limina tots els elements de la llista.
		 */
		public static int Anular(String[] list, int num_elements) {
				if (!IsListEmpty(list)) {
						for (int e = 0; e < list.length; e++) {
								list[e] = null;
						}
						return (0);
				}
				System.out.println(Roig + "La llista és buida " + ResetColor);
				return (num_elements);
		}
		/**
		 * Aquesta funció l'utilizarem per a suprimir els elements de la llista que coincideixen apartir d'una cadena de text.
		 * @param list Aquesta variable serà la array que efectuarem les operacions.
		 * @param num_elements Aquesta variable actua com a contador del elements no null de la llista (list).
		 * @param element Aquesta variable emmagatzema un valor String del element que anem a suprmir.
		 * @return int Retorna el nombre d'elements actual de la llista una vegada s'han efecetuat totes les opearcions.
		 */
		public static int SuprimirDada(String[] list, String element, int num_elements) {
				if (IsListEmpty(list)) { return (num_elements); }

				boolean not_found = true;

				for (int i = 0; i <= list.length; i++) {
						if (i == list.length) {
								if (not_found) {
										System.out.println(Roig + "Aquest element no es pot borrar perque no existeix. " + ResetColor);
								}
								break;
						} else if (list[i] != null && list[i].equals(element)) {
								System.out.println(Verd + "S'ha eliminat l'element " + list[i] + " a la posició " + i + ResetColor);
								for (int e = i; e < list.length - 1; e++) {
										list[e] = list[e + 1];
								}
								list[num_elements - 1] = null;
								num_elements--;
								i--;
								not_found = false;
						}
				}
				return (num_elements);
		}
		/**
		 * Aquesta funció l'utilizarem per a ordenar els elements de la llista alfabèticament A-Z.
		 * @param list Aquesta variable serà la array que efectuarem les operacions.
		 * @param num_elements Aquesta variable actua com a contador del elements no null de la llista (list).
		 */
		public static void Ordenar(String[] list, int num_elements) {
				String holder;

				if (!IsListEmpty(list)) {
						for (int i = 0; i < num_elements; i++) {
								for (int e = i; e < num_elements; e++) {
										if (list[i].compareTo(list[e]) > 0) {
												// utilitzo printline com a variable temporal, ja que quan es torni a utilitzar es sobreescriura i no s'utilitzara.
												holder = list[i];
												list[i] = list[e];
												list[e] = holder;
										}
								}
						}
				} else {
						System.out.println(Roig + "Llista buida ! " + ResetColor);
				}
		}
		/**
		 * Aquesta funció l'utilizarem per a suprimir un element de la llista, el primer o el darrer "últim".
		 * Per a aquesta funció es deuria acompanyar amb la funcio AskPrimerDarrer ja que retorna l'argument demanat aquest mètode.
		 * @param list Aquesta variable serà la array que efectuarem les operacions.
		 * @param num_elements Aquesta variable actua com a contador del elements no null de la llista (list).
		 * @param primerdarrer Aquesta variable emmagatzema un valor String que pot ser "primer" o "darrer".
		 * @return Retorna una String d'un element de la llista.
		 */
		public static String PrimerDarrer(String[] list, int num_elements, String primerdarrer) {
				if (primerdarrer.equals("primer")) {
						System.out.println(Verd + list[0] + ResetColor);
						return (list[0]);
				} else if (primerdarrer.equals("darrer")) {
						System.out.println(Verd + list[num_elements - 1] + ResetColor);
						return (list[num_elements - 1]);
				}
				return (null);
		}
}
public static void exemple(String prova, String[] proves){
		String
		        prova = "Hola";
		proves = hola;
}
