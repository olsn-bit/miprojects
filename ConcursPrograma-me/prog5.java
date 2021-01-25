import java.util.Scanner;

public class main8 {

public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextInt()) {
				int vegades = sc.nextInt();
				int tamany = sc.nextInt();
				int abono = sc.nextInt();
				int aigua = sc.nextInt();
				int distancia = sc.nextInt();
				String nom = sc.next();
				String finalet = "";
				for (int e = 0; e < vegades; e++) {
						int tamany2 = sc.nextInt();
						int abono2 = sc.nextInt();
						int aigua2 = sc.nextInt();
						int distancia2 = sc.nextInt();
						String nom2 = sc.next();
						if (tamany > tamany2) {
								finalet = nom;
								continue;
						}
						if (tamany2 > tamany) {
								finalet = nom2;
								continue;
						}
						if (aigua2 > aigua) {
								finalet = nom;
								continue;
						}
						if (aigua > aigua2 ) {
								finalet = nom2;
								continue;
						}
						if (distancia2 > distancia) {
								finalet = nom;
								continue;
						} if (distancia > distancia2) {
								finalet = nom2;
								continue;
						}
						if (abono > abono2) {
								finalet = nom;
								continue;
						}
						if (abono2 > abono) {
								finalet = nom2;
								continue;
						}
						tamany = tamany2;
						abono = abono2;
						aigua = aigua2;
						distancia = distancia2;
						nom = nom2;

				}
				System.out.println(finalet);
		}
}
}
