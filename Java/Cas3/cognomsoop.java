import java.util.Scanner;
public class cognomsoop {
		// variables del objecte
		int length;

		String[] list;

		int num_elements;
		String name;

		public cognomsoop(int listlength, String name) {  // constructor
				this.length = listlength;
				this.list = new String[this.length];
				this.num_elements = 0;
				this.name = name;
		}

		// colors globals i scanner
		public static final String ResetColor = "\u001B[0m";
		public static final String Roig = "\u001B[31m";
		public static final String Groc = "\u001B[33m";
		public static final String Cyan = "\u001B[36m";
		public static final String Verd = "\u001B[32m";
		public static Scanner sc = new Scanner(System.in);
		public static void main(String[] args) {
				cognomsoop prova1 = new cognomsoop(10, "cognoms");

				prova1.start();
		}
		public void start() {
				int input;
				boolean running = true;

				while (running) {
						print_menu();
						input = sc.nextInt();
						sc.nextLine();
						switch (input) {
						case 1:
								this.insert(this.ask_element(), this.ask_pos());
								print_list(this.list, this.num_elements);
								break;
						case 2:
								this.locate(this.ask_element(), -1);
								break;
						case 3:
								this.locate(null, this.ask_pos());
								break;
						case 4:
								this.remove(null, this.ask_pos());
								break;
						case 5:
								this.remove(this.ask_element(), -1);
								break;
						case 6:
								this.reset();
								break;
						case 7:
								this.primerdarrer();
								break;
						case 8:
								print_list(this.list, this.num_elements);
								break;
						case 9:
								this.order();
								print_list(this.list, this.num_elements);
								break;
						case 10:
								this.order();
								this.locate(this.ask_element(), -1);
								break;
						case 11:
								this.order();
								this.remove(this.ask_element(), -1);
								print_list(this.list, this.num_elements);
								break;
						case 12:
								System.out.println(Groc + "Fins la pròxima ;)" + ResetColor);
								running = false;
								break;
						default:
								System.out.println(Roig + "Funció no operativa o codi erroni." +
								                   ResetColor);
								break;
						}
				}
		}
		public void order() {
				String printline;

				if (this.num_elements > 1) {
						for (int i = 0; i < this.num_elements; i++) {
								for (int e = i + 1; e < this.num_elements; e++) {
										if (this.list[i].compareTo(this.list[e]) < 0) {
												// utilitzo printline com a variable temporal, ja que quan es torni a utilitzar es sobreescriura i no s'utilitzara.
												printline = this.list[i];
												this.list[i] = this.list[e];
												this.list[e] = printline;
										}
								}
						}
				} else {
						System.out.println(cognomsoop.Roig +
						                   "Llista massa curta per ordenar " + cognomsoop.ResetColor);
				}
		}
		public void primerdarrer() {
				String primerDarrer;

				do {
						System.out.println(cognomsoop.Verd +
						                   "Opcions: \"primer\" o \"darrer\"" + cognomsoop.ResetColor);
						primerDarrer = sc.next();
				} while(!(primerDarrer.equals("primer") || primerDarrer.equals(
								  "darrer")));
				if (primerDarrer.equals("primer"))
						System.out.println(cognomsoop.Verd + this.list[0] +
						                   cognomsoop.ResetColor);
				else if (primerDarrer.equals("darrer"))
						System.out.println(cognomsoop.Verd + this.list[this.num_elements -
						                                               1] + cognomsoop.ResetColor);
		}
		public void remove(String element, int position) {
				if (element == null) {
						if (this.list[position] != null) {
								// Sobreescriu les cel·les cap a l'esquerra i elimina la primera
								for (int e = position; e < this.num_elements; e++)
										this.list[e] = this.list[e + 1];
								// llista = {1,2,3,null}
								this.list[this.num_elements - 1] = null;
								System.out.println(cognomsoop.Verd +
								                   "S'ha eliminat l'element " + this.list[position] +
								                   cognomsoop.ResetColor);
						} else {
								System.out.println(cognomsoop.Roig +
								                   "Aquest element no es pot borrar perque no existeix. " +
								                   cognomsoop.ResetColor);
						}
				} else {
						boolean bool_aux = false;
						String printline = "a";

						for (int i = 0; i < this.length; i++) {
								if (bool_aux) {
										i--;
										bool_aux = false;
								}
								if (this.list[i] != null && this.list[i].equals(element)) {
										System.out.println(cognomsoop.Verd +
										                   "S'ha eliminat l'element " + this.list[i] +
										                   " a la posició " + i + cognomsoop.ResetColor);
										for (int e = i; e < this.length - 1; e++)
												this.list[e] = this.list[e + 1];
										this.list[this.num_elements - 1] = null;
										bool_aux = true;
										printline = "e";
								} else if (i == this.num_elements && printline.equals("a")) {
										System.out.println(cognomsoop.Roig +
										                   "Aquest element no es pot borrar perque no existeix. " +
										                   cognomsoop.ResetColor);
										break;
								}
						}
				}
		}
		public void locate(String element, int position) {  // nomes tens que posar el valor de un parametre, aixo fa que es pugue aprofitar la funcio per a diferents casos.
				if (position == -1) {
						for (int i = 0; i <= this.num_elements; i++) {
								if (i == this.num_elements) {
										System.out.println(cognomsoop.Roig + "L'element " +
										                   element + " no es troba a la llista " + this.name + "" +
										                   cognomsoop.ResetColor);
										break;
								}
								if (this.list[i] != null && this.list[i].equals(element)) {
										System.out.println(cognomsoop.Verd + "L'element " +
										                   element + " es troba a la posició " + i + "" +
										                   cognomsoop.ResetColor);
										break;
								}
						}
				} else {
						if (this.list[position] == null) {
								System.out.println("\u001B[32m" + "La posició " + position +
								                   " es buida" + cognomsoop.ResetColor);
						} else {
								System.out.println("\u001B[32m" + "A la posició " + position +
								                   " es troba l'element: " + this.list[position] + "" +
								                   cognomsoop.ResetColor);
						}
				}
		}
		public void insert(String new_value, int new_position) {
				String siono;

				if (this.num_elements == this.length) {
						do {
								System.out.println(cognomsoop.Roig +
								                   "La llista esta plena, vols que borrem l'ultim element \" "
								                   + list[list.length - 1] +
								                   " \" o no efectuar la acció ( si / no ) ?" +
								                   cognomsoop.ResetColor);
								siono = sc.nextLine();
						} while(!(siono.equals("si") || siono.equals("no"))); // https://softwareengineering.stackexchange.com/questions/306881/how-to-properly-reverse-the-if-statement-when-you-have-two-conditions-in-it
						if (siono.equals("si")) {
								for (int e = this.num_elements - 1; e > new_position; e--)
										this.list[e] = this.list[e - 1];
								this.list[new_position] = new_value;
						} else {
								System.out.println("Sortint.");
						}
				} else {
						for (int e = this.num_elements; e > new_position; e--)
								this.list[e] = this.list[e - 1];
						this.list[new_position] = new_value;
				}
				this.num_elements++;
		}
		public int ask_pos() {
				int pos;

				while (true) {
						System.out.println(cognomsoop.Groc + "Introdueix una posició: " +
						                   cognomsoop.ResetColor);
						pos = sc.nextInt();
						if (pos >= 0 && pos < this.length && pos <= this.num_elements) {
								return pos;
						} else {
								System.out.println(cognomsoop.Roig +
								                   "Posició Incorrecta/Posicións anteriors buides" +
								                   cognomsoop.ResetColor);
						}
				}
		}
		public void reset() {
				for (int e = 0; e < this.num_elements; e++)
						this.list[e] = null;
				System.out.println(cognomsoop.Verd + "La llista " + this.name +
				                   " ha estat buidada." + cognomsoop.ResetColor);
		}
		public String ask_element() {
				String element;

				do {
						System.out.println(cognomsoop.Groc +
						                   "Introdueix un element: (Sense Comilles)" +
						                   cognomsoop.ResetColor);
						element = sc.nextLine();
				} while(element.length() < 1);
				return element;
		}
		public static void print_menu() {
				System.out.println(cognomsoop.Cyan + "\nAccions :" +
				                   "\n \"1\": Inserir (element,pos,list)" +
				                   "\n \"2\": Localitzar (element,list)" +
				                   "\n \"3\": Recuperar (pos,list)" + "\n \"4\": Suprimir (pos,list)" +
				                   "\n \"5\": SuprimirDada (element,list)" +
				                   "\n \"6\": Anul·lar (list)" +
				                   "\n \"7\": PrimerDarrer (list,primer/darrer)" +
				                   "\n \"8\": Imprimir (list)" + "\n \"9\": Ordenar (list)" +
				                   "\n \"10\": LocalitzarEnOrdenada (element,list)" +
				                   "\n \"11\": SuprimirDadaEnOrdenada (element,list)" +
				                   "\n \"12\": Sortir del Programa" + cognomsoop.ResetColor);
		}
		public static void print_list(String[] llista, int num_elements) {
				String printline = "";

				for (int e = 0; e < num_elements - 1; e++)
						printline += llista[e] + ",";
				if (num_elements == 0)
						System.out.println(cognomsoop.Roig +
						                   "La llista no té ningun element." + cognomsoop.ResetColor);
				else if (llista[num_elements - 1] != null)
						System.out.println(cognomsoop.Verd + "\n" + printline +
						                   llista[num_elements - 1] + cognomsoop.ResetColor);
				else
						System.out.println(cognomsoop.Verd + "\n" + printline.substring(0,
						                                                                printline.length() - 1) + cognomsoop.ResetColor);
		}
}
