import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
public class Main7 {

public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		ArrayList<Integer> llista = new ArrayList<>();


		while (true) {
				int vegades = sc.nextInt();
				if (vegades == 0) {
						break;
				}

				int diferencia = 0;
				for (int e = 0; e < vegades; e++) {
						llista.add(sc.nextInt());
				}
				Collections.sort(llista);



				int numero1 = llista.get(0);
				for (int e = 0; e < vegades-1; e++) {
						int numero2 = llista.get(e+1);
						if (numero1 > numero2 && diferencia < (numero1 - numero2)) {
								diferencia = numero1 - numero2;

						} else if (numero2 > numero1 && diferencia < (numero2 - numero1)) {

								diferencia = numero2 - numero1;

						}
						numero1 = numero2;

				}
				System.out.println(diferencia);

		}
}
}
