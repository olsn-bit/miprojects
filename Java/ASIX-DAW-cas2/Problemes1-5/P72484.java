import java.util.Scanner;
public class Main{//P72484
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    int llargada = input.nextInt();
    for(int linea = 1;linea<(llargada)*2;linea+=2){
      String strline = "";
      for(int espais = 1;espais < (llargada-linea/2);espais++){
        strline += " ";
      }
      for(int asterisc = 0;asterisc<linea;asterisc++){
        strline += "*";
      }
      System.out.println(strline);
    }
    for(int linea = ((llargada)*2)-3;linea>0;linea-=2){
      String strline = "";
      for(int espai = 1;espai < llargada-linea/2;espai++){
        strline += " ";
      }
      for(int asterisc = linea;asterisc>0;asterisc--){
        strline += "*";
      }
      System.out.println(strline);
    }
  }
}
