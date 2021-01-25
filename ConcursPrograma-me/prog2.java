
import java.util.Scanner;
public class Main6 {
public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int vegades =sc.nextInt();
		int orden = 1;
		for (int e = 0; e<vegades; e++) {
				int kiloskvol = sc.nextInt();
				int botelles = 0;
				while(!false) {
						int num = sc.nextInt();
						if (num == 0) {break;}
						botelles += num;
				}
				if ( (botelles * 0.125) >= kiloskvol) {
						System.out.println(orden);


				}else{
						System.out.println("SIGAMOS RECICLANDO");
				}
				orden++;
		}
}
}
