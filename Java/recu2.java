import java.util.Scanner;

public class recu2 {
		public static int llegirEnter() {
				Scanner sc = new Scanner(System.in);

				return (sc.nextInt());
		}
		public static int[] llegirArray(int numeros[]) {
				for (int i = 0; i < numeros.length; i++) {
						numeros[i] = llegirEnter();
				}
				return (numeros);
		}
		public static int buscarCoincidencia(int elem, int[] numeros) {
				for (int i = 0; i < numeros.lengt; i++) {
						if (numeros[i] == elem) {
								return (i);
						}
				}
				return (-1);
		}
		public static void imprimirMissatge(int pos, int[] numeros) {
				Scanner sc = new Scanner(System.in);

				if (pos == -1) {
						System.out.println("no hi es.");
				} else {
						System.out.println("A la posició " + pos + " es troba l'element: " + numeros[pos]);
				}
		}
		public static void main(String[] args) {
				int numeros[] = new int[7];

				numeros = llegirArray(numeros);

				int valorabuscar = llegirEnter();
				int posicio = buscarCoincidencia(valorabuscar, numeros);

				imprimirMissatge(posicio, numeros);
		}
}
