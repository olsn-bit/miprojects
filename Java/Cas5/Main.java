import java.util.Scanner;
public class Main {
		public static void main(String[] args) {
				Scanner sc = new Scanner(System.in);

				System.out.println("Introduiex el preu de la entrada (decimal en coma)");

				double preuEntrada = sc.nextDouble();
				sc.nextLine();
				System.out.println("Numero de files al teatre (int)");

				int filesTeatre =  sc.nextInt();
				sc.nextLine();
				System.out.println("Numero de seients per fila al teatre (int)");

				int cadiresFilaTeatre = sc.nextInt();
				sc.nextLine();
				System.out.println("Nom de la obra:");

				String nomObra = sc.nextLine();

				System.out.println("Durada de l'obra en minuts (int):");

				int duradaObra = sc.nextInt();
				sc.nextLine();
				System.out.println("Autor de l'obra:");

				String autorObra = sc.nextLine();

				System.out.println("Restriccio adults nomes?(true/false)");

				boolean adultsObra = sc.nextBoolean();
				sc.nextLine();
				Obra obraprova = new Obra(nomObra, duradaObra, autorObra, adultsObra);

				Teatre provateatre = new Teatre(obraprova,preuEntrada,filesTeatre,cadiresFilaTeatre);

				System.out.println("Quants clients vols creear? (int)");
				Client[] clients = new Client[sc.nextInt()];
				sc.nextLine();
				for (int e = 0; e < clients.length; e++) {
					System.out.println("Introdueix el nom del client (String)");
					String nomClient = sc.nextLine();
					System.out.println("Introdueix la edat del client (int)");
					int edatClient = sc.nextInt();
					sc.nextLine();
					System.out.println("Introdueix els diners del client (int)");
					int dinersClient = sc.nextInt();
					sc.nextLine();
					clients[e] = new Client(nomClient, edatClient, dinersClient);
					if (obraprova.getAdults()) {
						if (clients[e].majorEdat() == false) {
							continue;
						}
					}
					if (!clients[e].pagarEntrada(preuEntrada)) {
						System.out.println(clients[e] + "\" Not enough money for client: "+ clients[e].nom+"\"");
						continue;
					}


					int filaClient,seientClient;
					do {
						System.out.println("Introdueix la fila que el vols situar(int)");
						filaClient = sc.nextInt();
						sc.nextLine();
						System.out.println("Introdueix el seient de la fila "+filaClient+" (int)");
						seientClient = sc.nextInt();
						sc.nextLine();
					} while(provateatre.seientOcupat(filaClient, seientClient) != "[O]");
					provateatre.setSeient(new Seient(filaClient, seientClient, clients[e]));
				}
				System.out.println(provateatre);
		}
}
