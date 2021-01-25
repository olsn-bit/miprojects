import java.io.File;
import java.util.Scanner;

/**
 *
 * Aquesta classe comprova que els fitxers necessaris són creats i gestiona el menu principal
 *
 * @author: Alberto Dos Santos i Isaac Brull
 *
 * @version: 2020/Maig
 *
 */
public class Start {
		/**
		 *
		 * Aquest mètode comprova que els fitxers necessaris son creats
		 *
		 *
		 */
		public static void checkFiles() {
				File parelles = new File("parelles.txt");
				File registre = new File("registre.txt");

				try {
						if (!parelles.exists()) {
								parelles.createNewFile();
						}
						if (!registre.exists()) {
								registre.createNewFile();
						}
				} catch (Exception e) {
						// Excepció!

						e.printStackTrace(System.out);
				}
		}
		public static Registre registreActual = new Registre();

		/**
		 *
		 * Aquest és el metode main, el menu principal del programa
		 *
		 *
		 */
		public static void main(String[] args) {
				checkFiles();

				Scanner sc = new Scanner(System.in);
				Joc partida;

				System.out.println("Benvolgut a ... jugar o configurar?");
				switch (sc.nextLine()) {
				case "jugar":
						System.out.println("Quin idioma vols traduir? catala/angles");
						switch (sc.nextLine()) {
						case "angles":
								partida = new Joc("catala");
								break;
						case "catala":
								partida = new Joc("angles");
								break;
						}
						break;
				case "configurar":
						Gestio.configuracio();
						break;
				}
		}
}
