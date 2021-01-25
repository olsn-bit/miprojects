import java.util.Scanner;
public class Main{//P71753
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    while (input.hasNextInt()){
      int numeros = input.nextInt();
      int max = 0;
      for (int total = numeros;total != 0;total--){
        int nextint = input.nextInt();
        if (total == numeros || nextint > max){
          max = nextint;
        }
      }
      System.out.println(max);
    }
  }
}
