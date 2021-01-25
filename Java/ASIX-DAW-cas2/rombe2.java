
import java.util.Scanner;

class rombe2 {
  public static void printStar(int n,String thing){
      if(n > 0){
          System.out.print(thing);
          printStar(n-1,thing);
      }
  }
	public static void main(String[] args){
    String espai = " ";
    String estrella = "*";
    int numero = 4;
    int espais = 3;
    int estrelles = 1;
    for (int contador = 0;contador<numero ;contador++ ) {
      printStar(espais,espai);
      printStar(estrelles,estrella);
      System.out.println();
      espais -= 1;
      estrelles += 2;
    }
    for (int contador = 0;contador<numero ;contador++ ) {
      printStar(espais,espai);
      printStar(estrelles,estrella);
      System.out.println();
      espais += 1;
      estrelles -= 2;
    }
  }
}
