import java.lang.Math.*;
import java.util.Scanner;
//importem Math per a utilitzar el .pow i la variable PI
//importem Scanner per introduir dades al codi

public class main{
  //Creem la classe principal main
  public static void main(String []args){

    final double dmercuri = 4879;// km
  	final double dvenus = 12104;// km
  	final double dterra =  12742;// km
  	final double dmart = 6779; // km
  	final double  vmercuri = (((double)4/3)*Math.PI)*Math.pow(dmercuri/2, 3);
  	final double  vvenus = (((double)4/3)*Math.PI)*Math.pow(dvenus/2, 3);
  	final double vterra =(((double)4/3)*Math.PI)*Math.pow(dterra/2, 3);
  	final double  vmart =(((double)4/3)*Math.PI)*Math.pow(dmart/2, 3);
    //creem la base inicial de variables posant les dades que utilitzarem després
  	System.out.println("Enter the asteroid diameter:");
    //imprimim per a l'usuari una pregunta
    Scanner dasteroideinput = new Scanner(System.in);
    int dasteroide = dasteroideinput.nextInt();
    //creem el primer input demanan el volum del asteroide

  	final double vasteroide = (((double)4/3)*Math.PI)*Math.pow(dasteroide/2, 3);

  	System.out.println("The asteroid has a volume of "+vasteroide+" km^3:");
    System.out.println("Enter the asteroid velocity in km/h:");
    //imprimim al usuari varies dades que hem calculat anteriorment
    Scanner velasteroideinput = new Scanner(System.in);

    int velasteroidekmh = velasteroideinput.nextInt();
    // Després convertirem el escanner a un numero enter per poder fer operacions després
  	final int velasteroidekmdia = velasteroidekmh *24;
  	final int terraamart = 57600000;//km
  	final int terraamercuri = 77000000;//km
    final int terraavenus = 40000000;//km
    final int temsterraamart = terraamart/velasteroidekmdia;//dies
  	final int temsterraamercuri = terraamercuri/velasteroidekmdia;//dies
    final int temsterraavenus = terraavenus/velasteroidekmdia;//dies

    System.out.println("Temps que tarda en arribar:\nTerra a Mart = "+temsterraamart+" dies \nTerra a Mercuri = "+temsterraamercuri+" dies \nTerra a Venus = " + temsterraavenus+" dies \n");

    boolean canterraamart = temsterraamart < 500;
    boolean canterraavenus = temsterraavenus < 500;
    boolean canterraamercuri = temsterraamercuri < 500;

    System.out.println("Es probable que arribem vius a Mercuri?  "+canterraamercuri+" \nEs probable que arribem vius a Mart?  "+canterraamart+" \nEs probable que arribem vius a Venus?  "+canterraavenus+" \n");
    //per acabar hem imprimit les dades/conclusions finals del programa
     }
}
