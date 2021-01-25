
package AlbertoDosSantos_uf2cas5;
import java.util.Scanner;

public class Barret {
    public static void crearBarret(Mocador[] mocadors) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Anem a crear el barret, que tindrà " + mocadors.length + " mocadors:");
        for (int n = 0; n < mocadors.length; n++) {
            System.out.print("Color del mocador " + n+1 + "?:");
            mocadors[n] = new Mocador(sc.nextLine());
            System.out.println();
        }
    }

    public static void imprimirBarret(Mocador[] mocadors) {
        System.out.println("Voltem el barret i oh! no hi ha res. Però... tachan! què veiem aquí:");
        for (int n = mocadors.length - 1; n > -1; n--) {
            System.out.println("ohhh un mocador " + mocadors[n].getColor());
        }
    }
}
