import java.lang.Math.*;
import java.util.Scanner;
public class parellsenar{
  public static void main(String[] args){
    Scanner prova = new Scanner(System.in);
    int numero = prova.nextInt();
    if ((numero%2) == 0){
      System.out.println("parell");
    }else{
      System.out.println("senar");
    }
  }
}
