// import java.util.Scanner;
public class mainauto {
		public static void main(String[] args) {
//				while(true) {
						func1();
						try{
								Thread.sleep(1000);
						}
						catch(Exception e) {}
//				}
		}
		public static void func1(){
				// Scanner sc = new Scanner(System.in);

				double preuEntrada = 9;
				int filesTeatre = 10;
				int cadiresFilaTeatre = 10;
				// int aforamentTeatre = filesTeatre * cadiresFilaTeatre;
				Obra obraprova = new Obra("TitolObraProva", 60, "Marcos Molitor", true);
				Teatre provateatre = new Teatre(obraprova, preuEntrada, filesTeatre, cadiresFilaTeatre);

				String[] noms = { "Alberto", "Jesucristo", "nobita", "chupapijos", "tamare", "spiderman", "mepica" };
				Client[] clients = new Client[noms.length];
				for (int e = 0; e < noms.length; e++) {
						clients[e] = new Client(noms[e], (int)(Math.random() * 99), (int)(Math.random() * 1000));
						if (obraprova.getAdults()) {
								if (clients[e].majorEdat() == false) {
										continue;
								}
						}
						if (!clients[e].pagarEntrada(preuEntrada)) {
								System.out.println(clients[e] + "\" Not enough money\"");
								continue;
						}

						int filarandom, seientrandom;

						do {
								filarandom = (int)(Math.random() * filesTeatre);
								seientrandom = (int)(Math.random() * cadiresFilaTeatre);
						} while(provateatre.seientOcupat(filarandom, seientrandom) != "[O]");
						provateatre.setSeient(new Seient(filarandom, seientrandom, clients[e]));
				}
				System.out.println(provateatre);

		}
}
