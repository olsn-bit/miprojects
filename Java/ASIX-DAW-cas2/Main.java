
import java.util.Scanner;

class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
    while (sc.hasNextInt()) {
      int primer_numero = sc.nextInt();
      if (primer_numero < 1){
        System.out.println("Posicio incorrecta.");
        primer_numero = 0;
        while(primer_numero!=(-1)){
          primer_numero = sc.nextInt();
        }
      }else{
        for (int e = 1;e<=primer_numero ;e++ ) {
          int seq = sc.nextInt();
          if (seq == (-1)) {
            System.out.println("Posicio incorrecta.");
            break;
  				}
          if (e == primer_numero){
            System.out.println("A la posicio " + e + " hi ha un " + seq + ".");
            while(seq!=(-1)){
              seq = sc.nextInt();
            }
          }
  			}
      }
    }
	}
}
