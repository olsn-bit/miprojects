import java.util.Scanner;
public class P34080{//P34080
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    int ronda = 0;
    String grid[] = {};
    while (input.hasNextInt()){
      ronda++;
      if ( ronda != 1 ){
          System.out.println();
          scanner.nextLine()
      }
      int side = input.nextInt();
      int numbers = 0;
      String strrow;
      for (int line = 0;line<side;line++){
        strrow = "";
        for (int row = 0;row<side;row++){
          strrow += numbers++;
          // numbers++;
          if (numbers == 10){
            numbers = 0;
          }
        }
        System.out.println(strrow);
      }
      // System.out.println();
    }
  }//DOCUMENTAR PROBLEMA
  //fer cadenes de numeros per no utilitzar tant el print ja que utilitza moltes linnes de codi i realentiza codi
}
