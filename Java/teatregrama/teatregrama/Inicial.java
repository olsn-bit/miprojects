// package teatregrama;
import java.util.Arrays;
import java.util.Scanner;

public class Inicial {
		public static void main(String arg[]) {
				Scanner in = new Scanner(System.in);
				String Titol;
				String Autor;
				String durada;
				int numPersones;
				int files;
				int columnes;
				int eedat;
				int ediners;
				int edatMinima;
				int fila;
				int columna;
				double preu;
				String enom = "";

				System.out.println("Escriu la següent informació sobre l'obra:\nTitol:\nDurada:\nAutor:");

				Titol = in.next();
				durada = in.next();
				Autor = in.next();

				System.out.println("Edat minima de l'obra");
				edatMinima = in.nextInt();

				Obra obraT = new Obra(Titol, durada, Autor, edatMinima);

				System.out.println(obraT.toString());

				System.out.println("\nEscriu la següent informació sobre el Teatre:\nFiles:\ncolumnes:\nPreu:");

				files = in.nextInt();
				columnes = in.nextInt();
				preu = in.nextDouble();

				Teatre sala = new Teatre(files, columnes, preu, obraT);

				System.out.println("Quates persones hi han de public?");
				numPersones = in.nextInt();
				// num_personesz
				// Canvi numero 1
				Persona[] personesPublic = new Persona[numPersones];
				for (int i = 0; i < personesPublic.length; i++) {
						// int entrada=1;
						System.out.println("Introdueix les dades(nom, edat i *diners)");
						enom = in.next();
						eedat = in.nextInt();
						ediners = in.nextInt();
						// p=new Persona(enom,eedat,ediners);
						personesPublic[i] = new Persona(enom, eedat, ediners);
						if (sala.potEntrar(personesPublic[i])) {
								System.out.println("Quina fila i columna et vols sentar?(de la fila 0 a la " + (files - 1) + " )");
								fila = in.nextInt();
								columna = in.nextInt();
								// Seient seientProva = new Seient(files, columnes);
								if (sala.seientBuit(fila, columna)) {
										sala.seure(new Seient(fila, columna, personesPublic[i]));
										personesPublic[i].pagarEntrada(preu);
								} else {
										System.out.println("Seient Ocupat a la posicio fila:" + fila + " columna:" + columna);
								}
						}
				}
				// imprimir seients
				System.out.println("\n\nLlista de Clients:");
				for (int filaX = 0; filaX < sala.sessio.length; filaX++) {
						for (int columnaX = 0; columnaX < sala.sessio[filaX].length; columnaX++) {
								if (sala.sessio[filaX][columnaX] != null) {
										System.out.println(sala.sessio[filaX][columnaX]);
								}
						}
				}
				System.out.println("\n\nGràfic del teatre:");
				for (int filaX = 0; filaX < sala.sessio.length; filaX++) {
						System.out.println();
						for (int columnaX = 0; columnaX < sala.sessio[filaX].length; columnaX++) {
								if (sala.sessio[filaX][columnaX] == null) {
										System.out.print(" [O] ");
								} else {
										System.out.print(" [X] ");
								}
						}
				}
				System.out.println();
		}
}
